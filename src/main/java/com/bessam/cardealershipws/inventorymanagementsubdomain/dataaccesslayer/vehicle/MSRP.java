package com.bessam.cardealershipws.inventorymanagementsubdomain.dataaccesslayer.vehicle;

import com.bessam.cardealershipws.common.Currency;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.text.DecimalFormat;

@Embeddable
@Getter
@NoArgsConstructor
public class MSRP {

    @Column(name="amount")
    private Double value;

    @Column(name="currency")
    private Currency currency;

    public MSRP(Double value, Currency currency) {
        this.value = value;
        this.currency = currency;
    }
}
