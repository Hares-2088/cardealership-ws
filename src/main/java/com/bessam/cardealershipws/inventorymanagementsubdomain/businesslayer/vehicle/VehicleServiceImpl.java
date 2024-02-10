package com.bessam.cardealershipws.inventorymanagementsubdomain.businesslayer.vehicle;

import com.bessam.cardealershipws.inventorymanagementsubdomain.presentationlayer.vehicle.VehicleRequestModel;
import com.bessam.cardealershipws.inventorymanagementsubdomain.presentationlayer.vehicle.VehicleResponseModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleServiceImpl implements VehicleService{
    @Override
    public List<VehicleResponseModel> getVehicles() {
        return null;
    }

    @Override
    public VehicleResponseModel getVehicleByVehicleId(String vehicleId) {
        return null;
    }

    @Override
    public VehicleResponseModel updateVehicle(String vehicleId, VehicleRequestModel vehicleRequestModel) {
        return null;
    }

    @Override
    public VehicleResponseModel addVehicle(VehicleRequestModel vehicleRequestModel) {
        return null;
    }

    @Override
    public void deleteVehicle(String vehicleId) {

    }
}
