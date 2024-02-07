package com.bessam.cardealershipws.humanresourcessubdomain.dataaccesslayer.employee;

import jakarta.persistence.Embeddable;
import lombok.Getter;

import java.util.UUID;
@Getter
@Embeddable
public class EmployeeIdentifier {
    private String employeeId;
    public EmployeeIdentifier(){
        this.employeeId = UUID.randomUUID().toString();
    }
}