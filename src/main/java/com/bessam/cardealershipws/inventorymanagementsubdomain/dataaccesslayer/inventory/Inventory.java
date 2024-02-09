package com.bessam.cardealershipws.inventorymanagementsubdomain.dataaccesslayer.inventory;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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

}
