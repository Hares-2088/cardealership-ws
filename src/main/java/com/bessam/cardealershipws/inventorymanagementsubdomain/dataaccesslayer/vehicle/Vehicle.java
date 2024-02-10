package com.bessam.cardealershipws.inventorymanagementsubdomain.dataaccesslayer.vehicle;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "vehicles")
@NoArgsConstructor
@Setter
@Getter
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private VehicleIdentifier vehicleIdentifier;

    private String make;

    private String model;

    private Integer year;

    private String status;

    private String type;

    @Embedded
    private MSRP msrp;

    @Embedded
    private Options options;

    @Embedded
    private Manufacturer manufacturer;

    public Vehicle(Long id, VehicleIdentifier vehicleIdentifier, String make, String model, Integer year, String status, String type, MSRP msrp, Options options, Manufacturer manufacturer) {
        this.id = id;
        this.vehicleIdentifier = new VehicleIdentifier();
        this.make = make;
        this.model = model;
        this.year = year;
        this.status = status;
        this.type = type;
        this.msrp = msrp;
        this.options = options;
        this.manufacturer = manufacturer;
    }
}
