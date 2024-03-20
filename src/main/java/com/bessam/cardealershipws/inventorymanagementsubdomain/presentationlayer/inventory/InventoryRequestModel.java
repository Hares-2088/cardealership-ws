package com.bessam.cardealershipws.inventorymanagementsubdomain.presentationlayer.inventory;

import com.bessam.cardealershipws.inventorymanagementsubdomain.dataaccesslayer.inventory.InventoryType;
import com.bessam.cardealershipws.inventorymanagementsubdomain.dataaccesslayer.vehicle.Vehicle;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InventoryRequestModel {

    private InventoryType type;

    private List<Vehicle> vehicles;
}
