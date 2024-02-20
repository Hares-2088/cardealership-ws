package com.bessam.cardealershipws.salesandmarketingsubdomain.presentation;

import com.bessam.cardealershipws.common.Currency;
import com.bessam.cardealershipws.salesandmarketingsubdomain.dataaccess.FinancingAgreementDetails;
import com.bessam.cardealershipws.salesandmarketingsubdomain.dataaccess.SaleStatus;
import com.bessam.cardealershipws.salesandmarketingsubdomain.dataaccess.Warranty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SaleResponseModel {

    private String saleId;
    private String inventoryId;
    private String vehicleId;
    private String customerId;
    private String vehicleMake;
    private String vehicleModel;
    private String employeeId;
    private String customerFirstName;
    private String customerLastName;
    private String employeeFirstName;
    private String employeeLastName;
    private BigDecimal salePrice;
    private Currency currency;
    private SaleStatus saleStatus;
    private LocalDate saleOfferDate;
    private FinancingAgreementDetails financingAgreementsDetails;
    private Warranty warranty;
}
