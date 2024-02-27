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
public class SaleRequestModel {

    private String inventoryId;
    private String vehicleId;
    private String employeeId;
    private BigDecimal salePrice;
    private SaleStatus saleStatus;
    private Currency currency;
    private LocalDate saleOfferDate;
    private FinancingAgreementDetails financingAgreementDetails;
    private Warranty warranty;
}
