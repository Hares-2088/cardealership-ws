package com.bessam.cardealershipws.salesandmarketingsubdomain.business;

import com.bessam.cardealershipws.salesandmarketingsubdomain.presentation.SaleRequestModel;
import com.bessam.cardealershipws.salesandmarketingsubdomain.presentation.SaleResponseModel;

import java.util.List;

public interface SaleService {

    List<SaleResponseModel> getAllPurchases(String customerId);
    SaleResponseModel getCustomerPurchaseBySaleId(String customerId, String saleId);
    SaleResponseModel addCustomerPurchase(String customerId, SaleRequestModel saleRequestModel);
    SaleResponseModel updateSale(SaleRequestModel saleRequestModel, String saleId, String customerId);

    void deleteSale(String saleId, String customerId);
}
