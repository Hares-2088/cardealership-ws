package com.bessam.cardealershipws.inventorymanagementsubdomain.presentationlayer.inventory;

import com.bessam.cardealershipws.inventorymanagementsubdomain.dataaccesslayer.inventory.InventoryType;
import com.bessam.cardealershipws.inventorymanagementsubdomain.presentationlayer.vehicle.VehicleResponseModel;
import lombok.*;
import org.springframework.hateoas.RepresentationModel;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InventoryVehicleResponseModel extends RepresentationModel<InventoryVehicleResponseModel> {

    private String inventoryId;
    private String type;
    private List<VehicleResponseModel> availableVehicles;

}
