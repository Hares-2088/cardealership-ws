package com.bessam.cardealershipws.inventorymanagementsubdomain.dataaccesslayer.vehicle;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor
public class Manufacturer {

    private String name;
    private String country;

    public Manufacturer(@NotNull String name, @NotNull String country) {
        this.name = name;
        this.country = country;
    }
}
