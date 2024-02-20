package com.bessam.cardealershipws.humanresourcessubdomain.presentationlayer.employee;

import com.bessam.cardealershipws.humanresourcessubdomain.dataaccesslayer.employee.Address;
import com.bessam.cardealershipws.humanresourcessubdomain.dataaccesslayer.employee.PhoneNumber;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeResponseDTO {

    private String employeeId;
    private Address address;
    private List<PhoneNumber> phoneNumbers;
    private String firstName;
    private String lastName;
    private String emailAddress;
    private Double salary;
    private Double commissionRate;

}
