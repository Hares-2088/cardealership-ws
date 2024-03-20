package com.bessam.cardealershipws.humanresourcessubdomain.mapperlayer.department;



import com.bessam.cardealershipws.humanresourcessubdomain.dataaccesslayer.department.Department;
import com.bessam.cardealershipws.humanresourcessubdomain.presentationlayer.department.DepartmentController;
import com.bessam.cardealershipws.humanresourcessubdomain.presentationlayer.department.DepartmentResponseDTO;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.hateoas.Link;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Mapper(componentModel = "spring")
public interface DepartmentResponseMapper {

    @Mapping(expression = "java(department.getDepartmentIdentifier().getDepartmentId())", target = "departmentId")
    DepartmentResponseDTO entityToResponseDTO(Department department);

    List<DepartmentResponseDTO> entityListToResponseDTOList(List<Department> departmentList);

    @AfterMapping
    default void addLinks (@MappingTarget DepartmentResponseDTO departmentResponseDTO, Department department) {
        Link selfLink = linkTo(methodOn(DepartmentController.class).
                getDepartmentByDepartmentId(departmentResponseDTO.getDepartmentId())).withSelfRel();
        departmentResponseDTO.add(selfLink);
    }
}
