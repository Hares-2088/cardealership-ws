package com.bessam.cardealershipws.inventorymanagementsubdomain.mapperlayer.vehicle;

import com.bessam.cardealershipws.inventorymanagementsubdomain.dataaccesslayer.vehicle.Vehicle;
import com.bessam.cardealershipws.inventorymanagementsubdomain.presentationlayer.vehicle.VehicleController;
import com.bessam.cardealershipws.inventorymanagementsubdomain.presentationlayer.vehicle.VehicleResponseModel;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.hateoas.Link;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Mapper(componentModel = "spring")
public interface VehicleResponseMapper {

    @Mapping(expression = "java(vehicle.getVehicleIdentifier().getVehicleId())", target = "vehicleId")
    VehicleResponseModel entityToResponseModel(Vehicle vehicle);

    List<VehicleResponseModel> entityListToResponseModelList(List<Vehicle> vehicles);

    @AfterMapping
    default  void addLinks(@MappingTarget VehicleResponseModel model, Vehicle vehicle){
        //self Link
        Link selfLink= linkTo(methodOn(VehicleController.class)
                .getVehicleById(model.getInventoryId(), model.getVehicleId()))
                .withSelfRel();
        model.add(selfLink);
    }
}
