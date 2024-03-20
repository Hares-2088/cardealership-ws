package com.bessam.cardealershipws.inventorymanagementsubdomain.businesslayer.inventory;

import com.bessam.cardealershipws.inventorymanagementsubdomain.dataaccesslayer.inventory.Inventory;
import com.bessam.cardealershipws.common.InventoryIdentifier;
import com.bessam.cardealershipws.inventorymanagementsubdomain.dataaccesslayer.inventory.InventoryRepository;
import com.bessam.cardealershipws.inventorymanagementsubdomain.dataaccesslayer.vehicle.Vehicle;
import com.bessam.cardealershipws.inventorymanagementsubdomain.dataaccesslayer.vehicle.VehicleRepository;
import com.bessam.cardealershipws.inventorymanagementsubdomain.mapperlayer.inventory.InventoryRequestMapper;
import com.bessam.cardealershipws.inventorymanagementsubdomain.mapperlayer.inventory.InventoryResponseMapper;
import com.bessam.cardealershipws.inventorymanagementsubdomain.mapperlayer.inventory.InventoryVehicleResponseMapper;
import com.bessam.cardealershipws.inventorymanagementsubdomain.mapperlayer.vehicle.VehicleResponseMapper;
import com.bessam.cardealershipws.inventorymanagementsubdomain.presentationlayer.inventory.InventoryRequestModel;
import com.bessam.cardealershipws.inventorymanagementsubdomain.presentationlayer.inventory.InventoryResponseModel;
import com.bessam.cardealershipws.inventorymanagementsubdomain.presentationlayer.inventory.InventoryVehicleResponseModel;
import com.bessam.cardealershipws.inventorymanagementsubdomain.presentationlayer.vehicle.VehicleResponseModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryServiceImpl implements InventoryService{

    private InventoryRepository inventoryRepository;
    private VehicleRepository vehicleRepository;
    private InventoryRequestMapper inventoryRequestMapper;
    private InventoryResponseMapper inventoryResponseMapper;
    private InventoryVehicleResponseMapper inventoryVehicleResponseMapper;
    private final VehicleResponseMapper vehicleResponseMapper;

    public InventoryServiceImpl(InventoryRepository inventoryRepository, VehicleRepository vehicleRepository, InventoryRequestMapper inventoryRequestMapper, InventoryResponseMapper inventoryResponseMapper, InventoryVehicleResponseMapper inventoryVehicleResponseMapper, VehicleResponseMapper vehicleResponseMapper) {
        this.inventoryRepository = inventoryRepository;
        this.vehicleRepository = vehicleRepository;
        this.inventoryRequestMapper = inventoryRequestMapper;
        this.inventoryResponseMapper = inventoryResponseMapper;
        this.inventoryVehicleResponseMapper = inventoryVehicleResponseMapper;
        this.vehicleResponseMapper = vehicleResponseMapper;
    }

    @Override
    public List<InventoryResponseModel> getInventories() {
        List<Inventory> inventoryList = inventoryRepository.findAll();

        return inventoryResponseMapper.entityListToResponseModelList(inventoryList);
    }

    @Override
    public InventoryVehicleResponseModel getInventoryByInventoryId(String inventoryId) {
        Inventory inventory = inventoryRepository.findInventoryByInventoryIdentifier_InventoryId(inventoryId);
        List<Vehicle> vehicleList = vehicleRepository.findAllByInventoryIdentifier_InventoryId(inventoryId);
        List<VehicleResponseModel> vehicleResponseModelList = vehicleResponseMapper.entityListToResponseModelList(vehicleList);

        return inventoryVehicleResponseMapper.entityToResponseModel(inventory, vehicleResponseModelList);
    }

    @Override
    public InventoryResponseModel updateInventory(String inventoryId, InventoryRequestModel inventoryRequestModel) {
        Inventory foundInventory = inventoryRepository.findInventoryByInventoryIdentifier_InventoryId(inventoryId);

        Inventory inventory = inventoryRequestMapper.requestModelToEntity(inventoryRequestModel, foundInventory.getInventoryIdentifier());
        inventory.setId(foundInventory.getId());
        return inventoryResponseMapper.entityToResponseModel(inventory);
    }

    @Override
    public InventoryResponseModel addInventory(InventoryRequestModel inventoryRequestModel) {

        Inventory inventory = inventoryRequestMapper.requestModelToEntity(inventoryRequestModel, new InventoryIdentifier());

        return inventoryResponseMapper.entityToResponseModel(inventoryRepository.save(inventory));
    }

    @Override
    public void deleteInventory(String inventoryId) {
        Inventory inventory = inventoryRepository.findInventoryByInventoryIdentifier_InventoryId(inventoryId);

        inventoryRepository.delete(inventory);
    }
}
