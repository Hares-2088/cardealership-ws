package com.bessam.cardealershipws.inventorymanagementsubdomain.mapperlayer.inventory;

import com.bessam.cardealershipws.inventorymanagementsubdomain.dataaccesslayer.inventory.Inventory;
import com.bessam.cardealershipws.inventorymanagementsubdomain.dataaccesslayer.vehicle.Vehicle;
import com.bessam.cardealershipws.inventorymanagementsubdomain.mapperlayer.vehicle.VehicleResponseMapper;
import com.bessam.cardealershipws.inventorymanagementsubdomain.presentationlayer.inventory.InventoryVehicleResponseModel;
import com.bessam.cardealershipws.inventorymanagementsubdomain.presentationlayer.vehicle.VehicleResponseModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper(componentModel = "spring")
public interface InventoryVehicleResponseMapper {


    @Mapping(expression = "java(inventory.getInventoryIdentifier().getInventoryId())", target = "inventoryId")
    InventoryVehicleResponseModel entityToResponseModel(Inventory inventory, List<VehicleResponseModel> availableVehicles);
}