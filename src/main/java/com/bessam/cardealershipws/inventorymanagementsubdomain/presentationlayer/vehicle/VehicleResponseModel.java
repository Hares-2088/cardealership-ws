package com.bessam.cardealershipws.inventorymanagementsubdomain.presentationlayer.vehicle;

import com.bessam.cardealershipws.inventorymanagementsubdomain.dataaccesslayer.vehicle.*;
import lombok.*;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.RepresentationModel;

import java.text.DecimalFormat;
import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class VehicleResponseModel extends RepresentationModel<VehicleResponseModel> {

    private String vehicleId;
    private List<Manufacturer> manufacturers;
    private MSRP msrp;
    private List<Options> options;
    private String make;
    private String model;
    private Integer year;
    private String status;
    private String type;
    private String inventoryId;

}
