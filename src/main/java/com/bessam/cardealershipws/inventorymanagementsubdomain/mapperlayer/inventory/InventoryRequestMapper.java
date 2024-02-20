package com.bessam.cardealershipws.inventorymanagementsubdomain.mapperlayer.inventory;

import com.bessam.cardealershipws.inventorymanagementsubdomain.dataaccesslayer.inventory.Inventory;
import com.bessam.cardealershipws.common.InventoryIdentifier;
import com.bessam.cardealershipws.inventorymanagementsubdomain.presentationlayer.inventory.InventoryRequestModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface InventoryRequestMapper {
    @Mapping(target = "id", ignore = true)
    Inventory requestModelToEntity(InventoryRequestModel inventoryRequestModel, InventoryIdentifier inventoryIdentifier);
}
