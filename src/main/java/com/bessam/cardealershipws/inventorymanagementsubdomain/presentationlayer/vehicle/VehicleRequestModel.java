package com.bessam.cardealershipws.inventorymanagementsubdomain.presentationlayer.vehicle;

import com.bessam.cardealershipws.common.InventoryIdentifier;
import com.bessam.cardealershipws.inventorymanagementsubdomain.dataaccesslayer.vehicle.MSRP;
import com.bessam.cardealershipws.inventorymanagementsubdomain.dataaccesslayer.vehicle.Manufacturer;
import com.bessam.cardealershipws.inventorymanagementsubdomain.dataaccesslayer.vehicle.Options;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class VehicleRequestModel {
    private List<Manufacturer> manufacturers;
    private MSRP msrp;
    private Options options;
    private String make;
    private String model;
    private Integer year;
    private String status;
    private String usageType;
    private String type;
    private String inventoryId;
}
