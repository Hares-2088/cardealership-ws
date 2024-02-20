package com.bessam.cardealershipws.salesandmarketingsubdomain.business;

import com.bessam.cardealershipws.salesandmarketingsubdomain.presentation.SaleRequestModel;
import com.bessam.cardealershipws.salesandmarketingsubdomain.presentation.SaleResponseModel;

import java.util.List;

public interface SaleService {

    List<SaleResponseModel> getAllPurchases(String customerId, String saleId);
    SaleResponseModel getCustomerPurchaseBySaleId(String customerId, String saleId);
    SaleResponseModel addSale(SaleRequestModel saleRequestModel);
    void deleteSale(String saleId, String inventoryId, String vehicleId, String customerId,String employeeId);
    SaleResponseModel updateSale(SaleRequestModel saleRequestModel, String saleId);
}
