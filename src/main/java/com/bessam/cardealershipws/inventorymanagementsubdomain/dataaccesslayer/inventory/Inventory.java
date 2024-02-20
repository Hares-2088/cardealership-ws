package com.bessam.cardealershipws.inventorymanagementsubdomain.dataaccesslayer.inventory;

import com.bessam.cardealershipws.common.InventoryIdentifier;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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


    public Inventory(InventoryType type,InventoryIdentifier inventoryIdentifier) {
        this.type = type;
        this.inventoryIdentifier = inventoryIdentifier;
    }
}
