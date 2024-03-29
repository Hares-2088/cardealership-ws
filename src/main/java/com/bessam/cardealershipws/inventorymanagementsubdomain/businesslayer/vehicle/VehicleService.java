package com.bessam.cardealershipws.inventorymanagementsubdomain.businesslayer.vehicle;


import com.bessam.cardealershipws.inventorymanagementsubdomain.presentationlayer.vehicle.VehicleRequestModel;
import com.bessam.cardealershipws.inventorymanagementsubdomain.presentationlayer.vehicle.VehicleResponseModel;

import java.util.List;
import java.util.Map;

public interface VehicleService {
    List<VehicleResponseModel> getVehicles(String vehicleId, Map<String,String> queryParams);
    VehicleResponseModel getVehicleByVehicleId(String vehicleId);
    VehicleResponseModel updateVehicle(String vehicleId, VehicleRequestModel vehicleRequestModel);
    VehicleResponseModel addVehicle(VehicleRequestModel vehicleRequestModel);
    void deleteVehicle(String vehicleId);
}
