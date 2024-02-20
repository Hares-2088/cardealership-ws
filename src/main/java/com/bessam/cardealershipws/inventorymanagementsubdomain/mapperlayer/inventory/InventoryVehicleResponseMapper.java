package com.bessam.cardealershipws.inventorymanagementsubdomain.mapperlayer.inventory;

import com.bessam.cardealershipws.inventorymanagementsubdomain.dataaccesslayer.inventory.Inventory;
import com.bessam.cardealershipws.inventorymanagementsubdomain.dataaccesslayer.vehicle.Vehicle;
import com.bessam.cardealershipws.inventorymanagementsubdomain.presentationlayer.inventory.InventoryVehicleResponseModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface InventoryVehicleResponseMapper {

    @Mapping(expression = "java(inventory.getInventoryIdentifier().getInventoryId())", target = "inventoryId")
    InventoryVehicleResponseModel entityToResponseModel(Inventory inventory, List<Vehicle> availableVehicles);
}