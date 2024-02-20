package com.bessam.cardealershipws.salesandmarketingsubdomain.presentation;

import com.bessam.cardealershipws.salesandmarketingsubdomain.business.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/customers/{customerId}/purchases")
public class CustomerPurchaseController {

    private final SaleService saleService;

    @Autowired
    public CustomerPurchaseController(SaleService saleService) {
        this.saleService = saleService;
    }

    @GetMapping("{saleId}")
    public ResponseEntity<SaleResponseModel> getCustomerPurchaseBySaleId(@PathVariable String customerId, @PathVariable String saleId) {
        return ResponseEntity.ok().body(saleService.getCustomerPurchaseBySaleId(customerId, saleId));
    }


}
