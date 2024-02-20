package com.bessam.cardealershipws.salesandmarketingsubdomain.presentation;

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
    private String vehicleMake;
    private String vehicleModel;
    private String customerId;
    private String customerFirstName;
    private String customerLastName;
    private String employeeId;
    private String employeeFirstName;
    private String employeeLastName;
    private BigDecimal currency;
    private SaleStatus saleStatus;
    private LocalDate saleOfferDate;
    private FinancingAgreementDetails financingAgreementDetails;
    private Warranty warranty;
}
