package com.bessam.cardealershipws.humanresourcessubdomain.dataaccesslayer.employee;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "employees")
@NoArgsConstructor
@Setter
@Getter
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Embedded
    private EmployeeIdentifier employeeIdentifier;

    @Embedded
    private Address address;

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "employee_phonenumbers", joinColumns = @JoinColumn(name = "employee_id"))
    private List<PhoneNumber> phoneNumbers;

    private String firstName;
    private String lastName;
    private String emailAddress;
    private Double salary;
    private Double commissionRate;

    public Employee(@NotNull EmployeeIdentifier employeeIdentifier, @NotNull Address address, @NotNull List<PhoneNumber> phoneNumbers, @NotNull String firstName, @NotNull String lastName, @NotNull String email, @NotNull Double salary, @NotNull Double commissionRate) {
        this.employeeIdentifier = employeeIdentifier;
        this.address = address;
        this.phoneNumbers = phoneNumbers;
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = email;
        this.salary = salary;
        this.commissionRate = commissionRate;
    }
}
