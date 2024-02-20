package com.bessam.cardealershipws.salesandmarketingsubdomain.dataaccess;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SaleRepository extends JpaRepository<Sale,Integer> {

    List<Sale> findSalesByCustomerIdentifier_CustomerId(String customerId);

    Sale findSaleByCustomerIdentifier_CustomerIdAndSaleIdentifier_SaleId(String customerId, String saleId);
}
