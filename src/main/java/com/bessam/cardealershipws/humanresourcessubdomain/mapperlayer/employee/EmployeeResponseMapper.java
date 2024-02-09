package com.bessam.cardealershipws.humanresourcessubdomain.mapperlayer.employee;

import com.bessam.cardealershipws.humanresourcessubdomain.dataaccesslayer.employee.Employee;
import com.bessam.cardealershipws.humanresourcessubdomain.presentationlayer.employee.EmployeeResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")

public interface EmployeeResponseMapper {
    @Mapping(expression = "java(employee.getEmployeeIdentifier().getId()", target = "employeeId")
    EmployeeResponseDTO entityToResponseDTO(Employee employee);

    List<EmployeeResponseDTO> entityListToResponseDTOList(List<Employee> employeeList);
}
