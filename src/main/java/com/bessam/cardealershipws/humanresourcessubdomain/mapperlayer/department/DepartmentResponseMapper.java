package com.bessam.cardealershipws.humanresourcessubdomain.mapperlayer.department;

import com.bessam.cardealershipws.humanresourcessubdomain.dataaccesslayer.department.Department;
import com.bessam.cardealershipws.humanresourcessubdomain.presentationlayer.department.DepartmentResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DepartmentResponseMapper {

    @Mapping(expression = "java(department.getDepartmentIdentifier().getDepartmentId())", target = "departmentId")
    DepartmentResponseDTO entityToResponseDTO(Department department);

    List<DepartmentResponseDTO> entityListToResponseDTOList(List<Department> departmentList);
}
