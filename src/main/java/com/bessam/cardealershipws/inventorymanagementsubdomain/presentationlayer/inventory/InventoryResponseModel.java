package com.bessam.cardealershipws.inventorymanagementsubdomain.presentationlayer.inventory;

import com.bessam.cardealershipws.inventorymanagementsubdomain.dataaccesslayer.inventory.InventoryType;

import com.bessam.cardealershipws.inventorymanagementsubdomain.dataaccesslayer.vehicle.Vehicle;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.hateoas.RepresentationModel;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class InventoryResponseModel extends RepresentationModel<InventoryResponseModel> {

    private String inventoryId;

    private InventoryType type;

}
