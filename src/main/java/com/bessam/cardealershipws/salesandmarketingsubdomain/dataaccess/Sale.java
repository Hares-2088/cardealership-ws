package com.bessam.cardealershipws.salesandmarketingsubdomain.dataaccess;

import com.bessam.cardealershipws.common.CustomerIdentifier;
import com.bessam.cardealershipws.common.EmployeeIdentifier;
import com.bessam.cardealershipws.common.InventoryIdentifier;
import com.bessam.cardealershipws.common.VehicleIdentifier;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "sales")
@NoArgsConstructor
@Data
public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    SaleIdentifier saleIdentifier;
    @Embedded
    InventoryIdentifier inventoryIdentifier;
    @Embedded
    VehicleIdentifier vehicleIdentifier;
    @Embedded
    CustomerIdentifier customerIdentifier;
    @Embedded
    EmployeeIdentifier employeeIdentifier;

    @Embedded
    Price salePrice;

    @Enumerated(EnumType.STRING)
    private SaleStatus saleStatus;

    @Embedded
    FinancingAgreementDetails financingAgreementsDetails;

    @Embedded
    Warranty warranty;

    private LocalDate saleOfferDate;

    public Sale(@NotNull InventoryIdentifier inventoryIdentifier, @NotNull VehicleIdentifier vehicleIdentifier,
                @NotNull CustomerIdentifier customerIdentifier, @NotNull EmployeeIdentifier employeeIdentifier,
                @NotNull Price salePrice, @NotNull SaleStatus saleStatus, @NotNull FinancingAgreementDetails financingAgreementsDetails,
                @NotNull Warranty warranty, @NotNull LocalDate saleOfferDate) {
        this.saleIdentifier = new SaleIdentifier();
        this.inventoryIdentifier = inventoryIdentifier;
        this.vehicleIdentifier = vehicleIdentifier;
        this.customerIdentifier = customerIdentifier;
        this.employeeIdentifier = employeeIdentifier;
        this.salePrice = salePrice;
        this.saleStatus = saleStatus;
        this.financingAgreementsDetails = financingAgreementsDetails;
        this.warranty = warranty;
        this.saleOfferDate = saleOfferDate;
    }
}
