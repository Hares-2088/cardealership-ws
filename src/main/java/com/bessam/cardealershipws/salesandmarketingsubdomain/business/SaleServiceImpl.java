package com.bessam.cardealershipws.salesandmarketingsubdomain.business;

import com.bessam.cardealershipws.customerrelationssubdomain.datalayer.Customer;
import com.bessam.cardealershipws.customerrelationssubdomain.datalayer.CustomerRepository;
import com.bessam.cardealershipws.humanresourcessubdomain.dataaccesslayer.employee.Employee;
import com.bessam.cardealershipws.humanresourcessubdomain.dataaccesslayer.employee.EmployeeRepository;
import com.bessam.cardealershipws.inventorymanagementsubdomain.dataaccesslayer.inventory.Inventory;
import com.bessam.cardealershipws.inventorymanagementsubdomain.dataaccesslayer.inventory.InventoryRepository;
import com.bessam.cardealershipws.inventorymanagementsubdomain.dataaccesslayer.vehicle.Vehicle;
import com.bessam.cardealershipws.inventorymanagementsubdomain.dataaccesslayer.vehicle.VehicleRepository;
import com.bessam.cardealershipws.inventorymanagementsubdomain.mapperlayer.vehicle.VehicleRequestMapper;
import com.bessam.cardealershipws.inventorymanagementsubdomain.mapperlayer.vehicle.VehicleResponseMapper;
import com.bessam.cardealershipws.salesandmarketingsubdomain.dataaccess.Sale;
import com.bessam.cardealershipws.salesandmarketingsubdomain.dataaccess.SaleRepository;
import com.bessam.cardealershipws.salesandmarketingsubdomain.mapper.SaleResponseMapper;
import com.bessam.cardealershipws.salesandmarketingsubdomain.presentation.SaleRequestModel;
import com.bessam.cardealershipws.salesandmarketingsubdomain.presentation.SaleResponseModel;
import com.bessam.cardealershipws.utils.exceptions.InvalidInputException;
import com.bessam.cardealershipws.utils.exceptions.NotFoundException;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class SaleServiceImpl implements  SaleService{

    private final VehicleRepository vehicleRepository;
    private final InventoryRepository inventoryRepository;
    private final SaleRepository saleRepository;
    private final CustomerRepository customerRepository;
    private final EmployeeRepository employeeRepository;
    private final SaleResponseMapper saleResponseMapper;


    public SaleServiceImpl(VehicleRepository vehicleRepository, InventoryRepository inventoryRepository, SaleRepository saleRepository, CustomerRepository customerRepository, EmployeeRepository employeeRepository, SaleResponseMapper saleResponseMapper) {
        this.vehicleRepository = vehicleRepository;
        this.inventoryRepository = inventoryRepository;
        this.saleRepository = saleRepository;
        this.customerRepository = customerRepository;
        this.employeeRepository = employeeRepository;
        this.saleResponseMapper = saleResponseMapper;
    }


    @Override
    public List<SaleResponseModel> getAllPurchases(String customerId, String saleId) {
        Customer customer = customerRepository.findByCustomerIdentifier_CustomerId(customerId);
        if (customer == null) {
            throw new InvalidInputException("Customer not found");
        }

        List<SaleResponseModel> saleResponseModels = new ArrayList<>();
        List<Sale> sales = saleRepository.findSalesByCustomerIdentifier_CustomerId(customerId);

        sales.forEach(purchase ->{
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
    public SaleResponseModel addSale(SaleRequestModel saleRequestModel) {
        return null;
    }

    @Override
    public void deleteSale(String saleId, String inventoryId, String vehicleId, String customerId, String employeeId) {

    }

    @Override
    public SaleResponseModel updateSale(SaleRequestModel saleRequestModel, String saleId) {
        return null;
    }
}