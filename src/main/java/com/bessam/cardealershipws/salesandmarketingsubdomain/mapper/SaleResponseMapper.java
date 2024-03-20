package com.bessam.cardealershipws.salesandmarketingsubdomain.mapper;

import com.bessam.cardealershipws.customerrelationssubdomain.datalayer.Customer;
import com.bessam.cardealershipws.humanresourcessubdomain.dataaccesslayer.employee.Employee;
import com.bessam.cardealershipws.inventorymanagementsubdomain.dataaccesslayer.vehicle.Vehicle;
import com.bessam.cardealershipws.inventorymanagementsubdomain.presentationlayer.vehicle.VehicleController;
import com.bessam.cardealershipws.salesandmarketingsubdomain.dataaccess.Sale;
import com.bessam.cardealershipws.salesandmarketingsubdomain.presentation.CustomerPurchaseController;
import com.bessam.cardealershipws.salesandmarketingsubdomain.presentation.SaleResponseModel;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.hateoas.Link;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

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

    @AfterMapping
    default void addLinks(@MappingTarget SaleResponseModel model, Sale sale, Customer customer, Employee employee, Vehicle vehicle) {
        Link selfLink = linkTo(methodOn(CustomerPurchaseController.class).
                getCustomerPurchaseBySaleId(model.getCustomerId(), model.getSaleId())).withSelfRel();
        model.add(selfLink);

    //all purchases for customer
    Link purchasesLink =
            linkTo(methodOn(CustomerPurchaseController.class).
                    getAllPurchases(model.getCustomerId())).withRel
                    ("all purchases");
    model.add(purchasesLink);

    //vehicle link
    Link vehicleLink =
            linkTo(methodOn(VehicleController.class).
                    getVehicleById(vehicle.getInventoryIdentifier().getInventoryId(), model.getVehicleId())).
                    withRel("vehicle");
    model.add(vehicleLink);
    }
}
