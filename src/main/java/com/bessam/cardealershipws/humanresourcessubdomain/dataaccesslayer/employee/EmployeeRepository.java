package com.bessam.cardealershipws.humanresourcessubdomain.dataaccesslayer.employee;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    Employee findEmployeeByEmployeeIdentifier_EmployeeId(String employeeId);
}
