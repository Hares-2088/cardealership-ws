package com.bessam.cardealershipws.humanresourcessubdomain.presentationlayer.employee;

import com.bessam.cardealershipws.humanresourcessubdomain.dataaccesslayer.employee.Address;
import com.bessam.cardealershipws.humanresourcessubdomain.dataaccesslayer.employee.EmployeeIdentifier;
import com.bessam.cardealershipws.humanresourcessubdomain.dataaccesslayer.employee.PhoneNumber;
import jakarta.persistence.*;

import java.util.List;

public class EmployeeRequestDTO {
    private Address address;
    private List<PhoneNumber> phoneNumbers;
    private String firstName;
    private String lastName;
    private String email;
    private Double salary;
    private Double commissionRate;
}
