package com.bessam.cardealershipws.salesandmarketingsubdomain.mapper;

import com.bessam.cardealershipws.customerrelationssubdomain.datalayer.Customer;
import com.bessam.cardealershipws.humanresourcessubdomain.dataaccesslayer.employee.Employee;
import com.bessam.cardealershipws.inventorymanagementsubdomain.dataaccesslayer.inventory.Inventory;
import com.bessam.cardealershipws.inventorymanagementsubdomain.dataaccesslayer.vehicle.Vehicle;
import com.bessam.cardealershipws.salesandmarketingsubdomain.dataaccess.Sale;
import com.bessam.cardealershipws.salesandmarketingsubdomain.presentation.SaleResponseModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "Spring")
public interface SaleResponseMapper {

    @Mapping(expression = "java(sale.getVehicleIdentifier().getVehicleId())", target = "vehicleId")
    @Mapping(expression = "java(sale.getInventoryIdentifier().getInventoryId())", target = "inventoryId")
    @Mapping(expression = "java(sale.getSaleIdentifier().getSaleId())", target = "saleId")
    @Mapping(expression = "java(sale.getCustomerIdentifier().getCustomerId())", target = "customerId")
    @Mapping(expression = "java(sale.getEmployeeIdentifier().getEmployeeId())", target = "employeeId")
    @Mapping(expression = "java(sale.getSalePrice().getAmount())", target = "salePrice")
    @Mapping(expression = "java(sale.getSalePrice().getCurrency())", target = "currency")
    @Mapping(expression = "java(vehicle.getMake())", target = "vehicleMake")
    @Mapping(expression = "java(vehicle.getModel())", target = "vehicleModel")
    @Mapping(expression = "java(customer.getFirstName())", target = "employeeFirstName")
    @Mapping(expression = "java(employee.getLastName())", target = "employeeLastName")
    @Mapping(expression = "java(customer.getFirstName())", target = "customerFirstName")
    @Mapping(expression = "java(customer.getLastName())", target = "customerLastName")
    SaleResponseModel entityToResponseModel(Sale sale, Customer customer, Employee employee, Vehicle vehicle);

    List<SaleResponseModel> entityListToResponseModelList(List<Sale> sales);
}
