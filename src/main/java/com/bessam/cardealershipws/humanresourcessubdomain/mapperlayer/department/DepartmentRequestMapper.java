package com.bessam.cardealershipws.humanresourcessubdomain.mapperlayer.department;

import com.bessam.cardealershipws.humanresourcessubdomain.dataaccesslayer.department.Department;
import com.bessam.cardealershipws.humanresourcessubdomain.dataaccesslayer.department.DepartmentIdentifier;
import com.bessam.cardealershipws.humanresourcessubdomain.presentationlayer.department.DepartmentRequestDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring")
public interface DepartmentRequestMapper {

    @Mapping(target = "id", ignore = true)
    Department requestDTOToEntity(DepartmentRequestDTO departmentRequestDTO, DepartmentIdentifier departmentIdentifier);
}
