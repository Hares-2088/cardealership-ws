package com.bessam.cardealershipws.inventorymanagementsubdomain.dataaccesslayer.vehicle;

import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;
import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor
public class Price {
    @Enumerated(EnumType.STRING)
    private Currency currency;

    private Double price;

    public Price(@NotNull Currency currency, @NotNull Double price) {
        this.currency = currency;
        this.price = price;
    }
}
