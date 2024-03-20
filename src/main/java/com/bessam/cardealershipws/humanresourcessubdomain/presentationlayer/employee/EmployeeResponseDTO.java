package com.bessam.cardealershipws.humanresourcessubdomain.presentationlayer.employee;

import com.bessam.cardealershipws.humanresourcessubdomain.dataaccesslayer.employee.Address;
import com.bessam.cardealershipws.humanresourcessubdomain.dataaccesslayer.employee.PhoneNumber;
import lombok.*;
import org.springframework.hateoas.RepresentationModel;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeResponseDTO extends RepresentationModel<EmployeeResponseDTO> {

    private String employeeId;
    private Address address;
    private List<PhoneNumber> phoneNumbers;
    private String firstName;
    private String lastName;
    private String emailAddress;
    private Double salary;
    private Double commissionRate;

}
