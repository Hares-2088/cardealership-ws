package com.bessam.cardealershipws.salesandmarketingsubdomain.mapper;

import com.bessam.cardealershipws.common.CustomerIdentifier;
import com.bessam.cardealershipws.common.EmployeeIdentifier;
import com.bessam.cardealershipws.common.InventoryIdentifier;
import com.bessam.cardealershipws.common.VehicleIdentifier;
import com.bessam.cardealershipws.salesandmarketingsubdomain.dataaccess.Price;
import com.bessam.cardealershipws.salesandmarketingsubdomain.dataaccess.Sale;
import com.bessam.cardealershipws.salesandmarketingsubdomain.dataaccess.SaleIdentifier;
import com.bessam.cardealershipws.salesandmarketingsubdomain.presentation.SaleRequestModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SaleRequestMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(expression = "java(price)", target = "salePrice")
    Sale requestModelToEntity(SaleRequestModel saleRequestModel, SaleIdentifier saleIdentifier,
                              CustomerIdentifier customerIdentifier, EmployeeIdentifier employeeIdentifier,
                              InventoryIdentifier inventoryIdentifier, VehicleIdentifier vehicleIdentifier,
                              Price price);
}
