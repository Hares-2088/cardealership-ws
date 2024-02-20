package com.bessam.cardealershipws.inventorymanagementsubdomain.dataaccesslayer.vehicle;

import com.bessam.cardealershipws.common.InventoryIdentifier;
import com.bessam.cardealershipws.common.VehicleIdentifier;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "vehicles")
@NoArgsConstructor
@Setter
@Getter
@Data
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Embedded
    private VehicleIdentifier vehicleIdentifier;

    @Embedded
    private InventoryIdentifier inventoryIdentifier;

    @Enumerated(EnumType.STRING)
    @Column(name="status")
    private Status status;

    @Enumerated(EnumType.STRING)
    @Column(name="type")
    private UsageType usageType;


    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name="vehicles_manufacturer", joinColumns = @JoinColumn(name = "vehicle_id"))
    private List<Manufacturer> manufacturers;

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name="vehicle_options", joinColumns = @JoinColumn(name = "vehicle_id"))
    private List<Options> options;

    @Column(name="make")
    private String make;

    @Column(name="model")
    private String model;

    @Column(name="year")
    private Integer year;

    @Embedded
    private MSRP msrp;

    public Vehicle(InventoryIdentifier inventoryIdentifier, @NotNull List<Manufacturer> manufacturers, @NotNull  MSRP msrp, @NotNull  List<Options> options, @NotNull  String make, @NotNull  String model, @NotNull  Integer year, @NotNull  Status status, @NotNull  UsageType type) {
        if (inventoryIdentifier == null) {
            throw new IllegalArgumentException("InventoryIdentifier must not be null");
        }

        this.inventoryIdentifier = inventoryIdentifier;
        this.vehicleIdentifier = new VehicleIdentifier();
        this.manufacturers = manufacturers;
        this.msrp = msrp;
        this.options = options;
        this.make = make;
        this.model = model;
        this.year = year;
        this.status = status;
        this.usageType = type;
    }
}
