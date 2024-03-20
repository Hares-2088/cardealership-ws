package com.bessam.cardealershipws.salesandmarketingsubdomain.business;

import com.bessam.cardealershipws.customerrelationssubdomain.datalayer.Customer;
import com.bessam.cardealershipws.customerrelationssubdomain.datalayer.CustomerRepository;
import com.bessam.cardealershipws.humanresourcessubdomain.dataaccesslayer.employee.Employee;
import com.bessam.cardealershipws.humanresourcessubdomain.dataaccesslayer.employee.EmployeeRepository;
import com.bessam.cardealershipws.inventorymanagementsubdomain.dataaccesslayer.inventory.Inventory;
import com.bessam.cardealershipws.inventorymanagementsubdomain.dataaccesslayer.inventory.InventoryRepository;
import com.bessam.cardealershipws.inventorymanagementsubdomain.dataaccesslayer.vehicle.Status;
import com.bessam.cardealershipws.inventorymanagementsubdomain.dataaccesslayer.vehicle.Vehicle;
import com.bessam.cardealershipws.inventorymanagementsubdomain.dataaccesslayer.vehicle.VehicleRepository;
import com.bessam.cardealershipws.salesandmarketingsubdomain.dataaccess.*;
import com.bessam.cardealershipws.salesandmarketingsubdomain.mapper.SaleRequestMapper;
import com.bessam.cardealershipws.salesandmarketingsubdomain.mapper.SaleResponseMapper;
import com.bessam.cardealershipws.salesandmarketingsubdomain.presentation.SaleRequestModel;
import com.bessam.cardealershipws.salesandmarketingsubdomain.presentation.SaleResponseModel;
import com.bessam.cardealershipws.utils.exceptions.InvalidInputException;
import com.bessam.cardealershipws.utils.exceptions.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class SaleServiceImpl implements  SaleService{

    // reference attributes
    private final VehicleRepository vehicleRepository;
    private final InventoryRepository inventoryRepository;
    private final SaleRepository saleRepository;
    private final CustomerRepository customerRepository;
    private final EmployeeRepository employeeRepository;
    private final SaleResponseMapper saleResponseMapper;
    private final SaleRequestMapper saleRequestMapper;


    public SaleServiceImpl(VehicleRepository vehicleRepository, InventoryRepository inventoryRepository, SaleRepository saleRepository, CustomerRepository customerRepository, EmployeeRepository employeeRepository, SaleResponseMapper saleResponseMapper, SaleRequestMapper saleRequestMapper) {
        this.vehicleRepository = vehicleRepository;
        this.inventoryRepository = inventoryRepository;
        this.saleRepository = saleRepository;
        this.customerRepository = customerRepository;
        this.employeeRepository = employeeRepository;
        this.saleResponseMapper = saleResponseMapper;
        this.saleRequestMapper = saleRequestMapper;
    }


    @Override
    public List<SaleResponseModel> getAllPurchases(String customerId) {
        Customer customer = customerRepository.findByCustomerIdentifier_CustomerId(customerId);
        if (customer == null) {
            throw new InvalidInputException("Customer not found");
        }

        List<SaleResponseModel> saleResponseModels = new ArrayList<>();
        List<Sale> sales = saleRepository.findSalesByCustomerIdentifier_CustomerId(customerId);

        sales.forEach(purchase ->{
            log.debug("Purchase" + purchase.toString());
            Employee employee = employeeRepository.findEmployeeByEmployeeIdentifier_EmployeeId(purchase.getEmployeeIdentifier().getEmployeeId());
            if (employee == null) {
                throw new InvalidInputException("Employee provided is invalid" + purchase.getEmployeeIdentifier().getEmployeeId());
            }
            Vehicle vehicle = vehicleRepository.findVehicleByVehicleIdentifier_VehicleId(purchase.getVehicleIdentifier().getVehicleId());
            if (vehicle == null) {
                throw new InvalidInputException("Vehicle provided is invalid" + purchase.getVehicleIdentifier().getVehicleId());
            }

            saleResponseModels.add(saleResponseMapper.entityToResponseModel(purchase, customer, employee, vehicle));
        });
        return saleResponseModels;
    }

    @Override
    public SaleResponseModel getCustomerPurchaseBySaleId(String customerId, String saleId) {

        //verify customer exists
        Customer customer = customerRepository.findByCustomerIdentifier_CustomerId(customerId);

        if (customer == null) {
            throw new InvalidInputException("Customer not found");
        }

        // verify sale exists
        Sale sale = saleRepository.findSaleByCustomerIdentifier_CustomerIdAndSaleIdentifier_SaleId(customerId, saleId);
        if (sale == null) {
            throw new NotFoundException("Unknown SaleId provided" + saleId);
        }

        Employee employee = employeeRepository.findEmployeeByEmployeeIdentifier_EmployeeId(sale.getEmployeeIdentifier().getEmployeeId());
        if (employee == null) {
            throw new InvalidInputException("Employee provided is invalid" + sale.getEmployeeIdentifier().getEmployeeId());
        }

        Vehicle vehicle = vehicleRepository.findVehicleByVehicleIdentifier_VehicleId(sale.getVehicleIdentifier().getVehicleId());
        if (vehicle == null) {
            throw new InvalidInputException("Vehicle provided is invalid" + sale.getVehicleIdentifier().getVehicleId());
        }
        return saleResponseMapper.entityToResponseModel(sale, customer, employee, vehicle);
    }

    @Override
    public SaleResponseModel addCustomerPurchase(String customerId, SaleRequestModel saleRequestModel) {
        //verify customer exists
        Customer customer = customerRepository.findByCustomerIdentifier_CustomerId(customerId);
        if (customer == null) {
            throw new InvalidInputException("Customer not found");
        }
        //verify employee exists
        Employee employee = employeeRepository.findEmployeeByEmployeeIdentifier_EmployeeId(saleRequestModel.getEmployeeId());
        if (employee == null) {
            throw new InvalidInputException("Employee not found");
        }

        //verify that vehicle is in inventory
        Vehicle vehicle = vehicleRepository.findByInventoryIdentifier_InventoryIdAndVehicleIdentifier_VehicleId(saleRequestModel.getInventoryId(), saleRequestModel.getVehicleId());
        if (vehicle == null) {
            throw new InvalidInputException("Vehicle not found in the inventory" + saleRequestModel.getInventoryId());
        }

        //verify that vehicle is not sold
        if (vehicle.getStatus() != Status.Available) {
            throw new InvalidInputException("Vehicle already sold");
        }
        //get inventory
        Inventory inventory = inventoryRepository.findInventoryByInventoryIdentifier_InventoryId(saleRequestModel.getInventoryId());

        //convert request model to entity
        Sale sale = saleRequestMapper.requestModelToEntity(saleRequestModel, new SaleIdentifier(), customer.getCustomerIdentifier(), employee.getEmployeeIdentifier(), inventory.getInventoryIdentifier(), vehicle.getVehicleIdentifier(),
                new Price(saleRequestModel.getSalePrice(),saleRequestModel.getCurrency()), saleRequestModel.getFinancingAgreementDetails());

        //save sale
        Sale savedSale = saleRepository.save(sale);
        return saleResponseMapper.entityToResponseModel(savedSale, customer, employee, vehicle);
    }

    @Override
    public SaleResponseModel updateSale(SaleRequestModel saleRequestModel, String saleId, String customerId) {

        Sale sale = saleRepository.findSaleByCustomerIdentifier_CustomerIdAndSaleIdentifier_SaleId(customerId, saleId);

        if (sale == null) {
            throw new NotFoundException("Sale not found");
        }
        //verify employee exists
        Employee employee = employeeRepository.findEmployeeByEmployeeIdentifier_EmployeeId(saleRequestModel.getEmployeeId());
        if (employee == null) {
            throw new InvalidInputException("Employee not found");
        }
        //verify that vehicle is in inventory
        Vehicle vehicle = vehicleRepository.findByInventoryIdentifier_InventoryIdAndVehicleIdentifier_VehicleId(saleRequestModel.getInventoryId(), saleRequestModel.getVehicleId());
        if (vehicle == null) {
            throw new InvalidInputException("Vehicle not found in the inventory" + saleRequestModel.getInventoryId());
        }
        //verify that vehicle is not sold
        if (vehicle.getStatus() != Status.Available) {
            throw new InvalidInputException("Vehicle already sold");
        }
        //get inventory
        Inventory inventory = inventoryRepository.findInventoryByInventoryIdentifier_InventoryId(saleRequestModel.getInventoryId());
        //convert request model to entity
        Sale updatedSale = saleRequestMapper.requestModelToEntity(saleRequestModel, sale.getSaleIdentifier(), sale.getCustomerIdentifier(), employee.getEmployeeIdentifier(), inventory.getInventoryIdentifier(), vehicle.getVehicleIdentifier(),
                new Price(saleRequestModel.getSalePrice(),saleRequestModel.getCurrency()), saleRequestModel.getFinancingAgreementDetails());

        updatedSale.setId(sale.getId());


        return saleResponseMapper.entityToResponseModel(saleRepository.save(updatedSale), customerRepository.findByCustomerIdentifier_CustomerId(customerId), employee, vehicle);
    }

    @Override
    public void deleteSale(String saleId, String customerId) {
        Sale sale = saleRepository.findSaleByCustomerIdentifier_CustomerIdAndSaleIdentifier_SaleId(customerId, saleId);
        if (sale == null) {
            throw new NotFoundException("Sale not found");
        }
        saleRepository.delete(sale);
    }

}