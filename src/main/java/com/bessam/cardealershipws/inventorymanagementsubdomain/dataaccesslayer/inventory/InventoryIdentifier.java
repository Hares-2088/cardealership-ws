package com.bessam.cardealershipws.inventorymanagementsubdomain.dataaccesslayer.inventory;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import jakarta.persistence.Embeddable;
import lombok.Getter;

import java.util.UUID;

@Embeddable
@Getter
public class InventoryIdentifier {

    private String inventoryId;

    public InventoryIdentifier() {
        this.inventoryId = UUID.randomUUID().toString();
    }
}
