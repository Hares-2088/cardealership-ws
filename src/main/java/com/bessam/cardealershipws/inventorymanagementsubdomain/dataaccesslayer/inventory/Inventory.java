package com.bessam.cardealershipws.inventorymanagementsubdomain.dataaccesslayer.inventory;

import com.bessam.cardealershipws.inventorymanagementsubdomain.dataaccesslayer.vehicle.Vehicle;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "inventories")
@NoArgsConstructor
@Setter
@Getter
public class Inventory {
    @Id
    private Long id;

    @Embedded
    private InventoryIdentifier inventoryIdentifier;

    @Enumerated(EnumType.STRING)
    private InventoryType type;

    @OneToMany(mappedBy = "inventory", fetch = FetchType.LAZY)
    private List<Vehicle> vehicles;

    public Inventory(Long id, InventoryType type, List<Vehicle> vehicles) {
        this.id = id;
        this.type = type;
        this.vehicles = vehicles;
    }
}
