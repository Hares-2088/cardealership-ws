package com.bessam.cardealershipws.inventorymanagementsubdomain.businesslayer.inventory;


import com.bessam.cardealershipws.inventorymanagementsubdomain.presentationlayer.inventory.InventoryRequestModel;
import com.bessam.cardealershipws.inventorymanagementsubdomain.presentationlayer.inventory.InventoryResponseModel;
import com.bessam.cardealershipws.inventorymanagementsubdomain.presentationlayer.inventory.InventoryVehicleResponseModel;

import java.util.List;

public interface InventoryService {
    List<InventoryResponseModel> getInventories();
    InventoryVehicleResponseModel getInventoryByInventoryId(String inventoryId);
    InventoryResponseModel updateInventory(String inventoryId, InventoryRequestModel inventoryRequestModel);
    InventoryResponseModel addInventory(InventoryRequestModel inventoryRequestModel);
    void deleteInventory(String inventoryId);
}
