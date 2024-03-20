package com.bessam.cardealershipws.humanresourcessubdomain.mapperlayer.employee;

import com.bessam.cardealershipws.humanresourcessubdomain.dataaccesslayer.employee.Employee;
import com.bessam.cardealershipws.humanresourcessubdomain.presentationlayer.employee.EmployeeController;
import com.bessam.cardealershipws.humanresourcessubdomain.presentationlayer.employee.EmployeeResponseDTO;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EmployeeResponseMapper {

    @Mapping(expression = "java(employee.getEmployeeIdentifier().getEmployeeId())", target = "employeeId")
    EmployeeResponseDTO entityToResponseDTO(Employee employee);

    List<EmployeeResponseDTO> entityListToResponseDTOList(List<Employee> employeeList);

    @AfterMapping
    default void addLinks(EmployeeResponseDTO model, Employee employee){
        //self link
        model.add(linkTo(methodOn(EmployeeController.class).
                getEmployeeByEmployeeId(model.getEmployeeId())).
                withSelfRel());

        //all employees link
        model.add(linkTo(methodOn(EmployeeController.class).getEmployees())
                .withRel("employees"));
    }
}
