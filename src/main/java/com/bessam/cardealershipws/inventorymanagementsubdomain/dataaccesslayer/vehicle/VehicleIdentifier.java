package com.bessam.cardealershipws.inventorymanagementsubdomain.dataaccesslayer.vehicle;

import jakarta.persistence.Embeddable;
import lombok.Getter;

import java.util.UUID;

@Getter
@Embeddable
public class VehicleIdentifier {

    private String vehicleId;

    public VehicleIdentifier() {
        this.vehicleId = UUID.randomUUID().toString();
    }
}
