package com.bessam.cardealershipws.inventorymanagementsubdomain.presentationlayer.vehicle;

import com.bessam.cardealershipws.common.Currency;
import com.bessam.cardealershipws.inventorymanagementsubdomain.dataaccesslayer.vehicle.*;
import lombok.*;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.RepresentationModel;

import java.text.DecimalFormat;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class VehicleResponseModel extends RepresentationModel<VehicleResponseModel> {

    private String vehicleId;
    private String inventoryId;
    private List<Manufacturer> manufacturers;
    private List<Options> options;
    private String make;
    private String model;
    private Integer year;
    private String status;
    private String usageType;
    private String currency;
    private Double price;

}
