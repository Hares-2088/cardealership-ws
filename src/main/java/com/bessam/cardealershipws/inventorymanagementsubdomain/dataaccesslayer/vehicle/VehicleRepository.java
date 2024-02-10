package com.bessam.cardealershipws.inventorymanagementsubdomain.dataaccesslayer.vehicle;

import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<Vehicle, Integer> {
    Vehicle findVehicleByVehicleIdentifier_VehicleId(String vehicleId);

}
