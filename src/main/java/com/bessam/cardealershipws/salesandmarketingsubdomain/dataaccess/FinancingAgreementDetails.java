package com.bessam.cardealershipws.salesandmarketingsubdomain.dataaccess;

import com.bessam.cardealershipws.common.Currency;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Embeddable
@NoArgsConstructor
@Getter
public class FinancingAgreementDetails {

    private Integer numberOfMonthlyPayments;
    private BigDecimal monthlyPaymentAmount;
    private BigDecimal downPaymentAmount;
    @Enumerated(EnumType.STRING)
    private Currency paymentCurrency;
}
