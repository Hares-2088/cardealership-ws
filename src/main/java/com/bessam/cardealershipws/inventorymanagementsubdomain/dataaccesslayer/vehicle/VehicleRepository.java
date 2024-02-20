package com.bessam.cardealershipws.inventorymanagementsubdomain.dataaccesslayer.vehicle;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.*;

public interface VehicleRepository extends JpaRepository<Vehicle, Integer> {
    Vehicle findVehicleByVehicleIdentifier_VehicleId(String vehicleId);
    List<Vehicle> findAllByInventoryIdentifier_InventoryId(String inventoryId);

    List<Vehicle> findAllByInventoryIdentifier_InventoryIdAndStatusEqualsAndUsageTypeEquals(String inventory, Status status, UsageType usageType);
    List<Vehicle> findAllByInventoryIdentifier_InventoryIdAndStatusEquals(String inventoryId, Status status);
    List<Vehicle> findAllByInventoryIdentifier_InventoryIdAndUsageTypeEquals(String inventoryId, UsageType usageType);
}
