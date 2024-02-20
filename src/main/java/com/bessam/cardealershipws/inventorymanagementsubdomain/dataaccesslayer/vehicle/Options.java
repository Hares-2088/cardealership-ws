package com.bessam.cardealershipws.inventorymanagementsubdomain.dataaccesslayer.vehicle;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Embeddable
@Getter
@NoArgsConstructor
public class Options {
    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private Double price;

    public Options(String name, String description, Double price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }
}
