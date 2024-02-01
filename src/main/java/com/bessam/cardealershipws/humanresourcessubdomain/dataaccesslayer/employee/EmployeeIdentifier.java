package com.bessam.cardealershipws.humanresourcessubdomain.dataaccesslayer.employee;

import jakarta.persistence.Embeddable;

import java.util.UUID;

@Embeddable
public class EmployeeIdentifier {
    private String employeeId;
    public EmployeeIdentifier(){
        this.employeeId = UUID.randomUUID().toString();
    }
}