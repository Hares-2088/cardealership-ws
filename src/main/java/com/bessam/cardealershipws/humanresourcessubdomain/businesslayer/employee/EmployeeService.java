package com.bessam.cardealershipws.humanresourcessubdomain.businesslayer.employee;

import com.bessam.cardealershipws.humanresourcessubdomain.dataaccesslayer.employee.EmployeeIdentifier;
import com.bessam.cardealershipws.humanresourcessubdomain.presentationlayer.employee.EmployeeRequestDTO;
import com.bessam.cardealershipws.humanresourcessubdomain.presentationlayer.employee.EmployeeResponseDTO;
import org.springframework.stereotype.Service;

import java.util.List;

public interface EmployeeService {
    List<EmployeeResponseDTO> getEmployees();
    EmployeeResponseDTO getEmployeeById(EmployeeIdentifier employeeIdentifier);
    EmployeeResponseDTO UpdateEmployee(EmployeeRequestDTO employeeRequestDTO, EmployeeIdentifier employeeIdentifier);
    EmployeeResponseDTO AddEmployee(EmployeeRequestDTO employeeRequestDTO);
    void deleteEmployee(EmployeeIdentifier employeeIdentifier);
}
