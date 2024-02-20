package com.bessam.cardealershipws.inventorymanagementsubdomain.dataaccesslayer.vehicle;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
public class Manufacturer {

    @Column(name="name")
    private String name;

    @Column(name="country")
    private String country;

    public Manufacturer(String name, String country) {
        this.name = name;
        this.country = country;
    }
}
