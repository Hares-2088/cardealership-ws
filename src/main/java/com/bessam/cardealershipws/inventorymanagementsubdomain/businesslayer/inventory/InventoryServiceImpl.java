package com.bessam.cardealershipws.inventorymanagementsubdomain.businesslayer.inventory;

import com.bessam.cardealershipws.inventorymanagementsubdomain.presentationlayer.inventory.InventoryRequestModel;
import com.bessam.cardealershipws.inventorymanagementsubdomain.presentationlayer.inventory.InventoryResponseModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryServiceImpl implements InventoryService{

    @Override
    public List<InventoryResponseModel> getInventories() {
        return null;
    }

    @Override
    public InventoryResponseModel getInventoryByInventoryId(String inventoryId) {
        return null;
    }

    @Override
    public InventoryResponseModel updateInventory(String inventoryId, InventoryRequestModel inventoryRequestModel) {
        return null;
    }

    @Override
    public InventoryResponseModel addInventory(InventoryRequestModel inventoryRequestModel) {
        return null;
    }

    @Override
    public void deleteInventory(String inventoryId) {

    }
}
