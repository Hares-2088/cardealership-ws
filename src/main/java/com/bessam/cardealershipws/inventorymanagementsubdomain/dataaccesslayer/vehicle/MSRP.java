package com.bessam.cardealershipws.inventorymanagementsubdomain.dataaccesslayer.vehicle;

import jakarta.persistence.Embeddable;
import lombok.NoArgsConstructor;

import java.text.DecimalFormat;

@Embeddable
@NoArgsConstructor
public class MSRP {
    private DecimalFormat value;

    private Currency currency;
}
