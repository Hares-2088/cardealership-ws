package com.bessam.cardealershipws.inventorymanagementsubdomain.presentationlayer.inventory;

import com.bessam.cardealershipws.inventorymanagementsubdomain.dataaccesslayer.inventory.InventoryType;
import com.bessam.cardealershipws.inventorymanagementsubdomain.presentationlayer.vehicle.VehicleResponseModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InventoryVehicleResponseModel {

    private String inventoryId;
    private InventoryType type;
    private List<VehicleResponseModel> availableVehicles;

}