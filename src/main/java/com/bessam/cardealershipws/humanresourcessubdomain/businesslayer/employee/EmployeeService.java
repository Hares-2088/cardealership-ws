package com.bessam.cardealershipws.humanresourcessubdomain.businesslayer.employee;

import com.bessam.cardealershipws.humanresourcessubdomain.presentationlayer.employee.EmployeeRequestDTO;
import com.bessam.cardealershipws.humanresourcessubdomain.presentationlayer.employee.EmployeeResponseDTO;

import java.util.List;

public interface EmployeeService {
    List<EmployeeResponseDTO> getEmployees();
    EmployeeResponseDTO getEmployeeByEmployeeId(String employeeIdentifier);
    EmployeeResponseDTO updateEmployee(EmployeeRequestDTO employeeRequestDTO, String employeeIdentifier);
    EmployeeResponseDTO AddEmployee(EmployeeRequestDTO employeeRequestDTO);
    void deleteEmployee(String employeeIdentifier);
}
