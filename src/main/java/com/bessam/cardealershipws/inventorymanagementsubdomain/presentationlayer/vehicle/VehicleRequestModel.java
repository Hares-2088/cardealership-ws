package com.bessam.cardealershipws.inventorymanagementsubdomain.presentationlayer.vehicle;

import com.bessam.cardealershipws.inventorymanagementsubdomain.dataaccesslayer.vehicle.Manufacturer;
import com.bessam.cardealershipws.inventorymanagementsubdomain.dataaccesslayer.vehicle.Options;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class VehicleRequestModel {
    private List<Manufacturer> manufacturers;
    private List<Options> options;
    private String make;
    private String model;
    private Integer year;
    private String status;
    private String usageType;
    private String type;
    private String inventoryId;
}
