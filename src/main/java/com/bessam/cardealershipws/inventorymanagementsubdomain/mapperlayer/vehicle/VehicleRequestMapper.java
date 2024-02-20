package com.bessam.cardealershipws.inventorymanagementsubdomain.mapperlayer.vehicle;

import com.bessam.cardealershipws.inventorymanagementsubdomain.dataaccesslayer.vehicle.Vehicle;
import com.bessam.cardealershipws.common.VehicleIdentifier;
import com.bessam.cardealershipws.inventorymanagementsubdomain.presentationlayer.vehicle.VehicleRequestModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface VehicleRequestMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(expression = "java(vehicle.getOptions())", target = "options")
    Vehicle requestModelToEntity(VehicleRequestModel vehicleRequestModel, VehicleIdentifier vehicleIdentifier);
}
