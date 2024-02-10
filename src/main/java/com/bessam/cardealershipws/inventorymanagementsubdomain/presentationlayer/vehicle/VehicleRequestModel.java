package com.bessam.cardealershipws.inventorymanagementsubdomain.presentationlayer.vehicle;

import com.bessam.cardealershipws.inventorymanagementsubdomain.dataaccesslayer.vehicle.MSRP;
import com.bessam.cardealershipws.inventorymanagementsubdomain.dataaccesslayer.vehicle.Manufacturer;
import com.bessam.cardealershipws.inventorymanagementsubdomain.dataaccesslayer.vehicle.Options;
import com.bessam.cardealershipws.inventorymanagementsubdomain.dataaccesslayer.vehicle.VehicleIdentifier;
import jakarta.persistence.Embedded;

public class VehicleRequestModel {

    private String make;

    private String model;

    private Integer year;

    private String status;

    private String type;

    private MSRP msrp;

    private Options options;

    private Manufacturer manufacturer;
}
