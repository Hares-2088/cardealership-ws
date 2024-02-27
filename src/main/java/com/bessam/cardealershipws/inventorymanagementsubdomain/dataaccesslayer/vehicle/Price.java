package com.bessam.cardealershipws.inventorymanagementsubdomain.dataaccesslayer.vehicle;

import com.bessam.cardealershipws.common.Currency;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor
@Getter
public class Price {
    @Enumerated(EnumType.STRING)
    private Currency currency;

    private Double price;

    public Price(@NotNull Currency currency, @NotNull Double price) {
        this.currency = currency;
        this.price = price;
    }
}
