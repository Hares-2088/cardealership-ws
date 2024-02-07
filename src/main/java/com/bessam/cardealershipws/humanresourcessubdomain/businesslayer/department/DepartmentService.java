package com.bessam.cardealershipws.humanresourcessubdomain.businesslayer.department;

import com.bessam.cardealershipws.humanresourcessubdomain.dataaccesslayer.department.DepartmentIdentifier;
import com.bessam.cardealershipws.humanresourcessubdomain.presentationlayer.department.DepartmentRequestDTO;
import com.bessam.cardealershipws.humanresourcessubdomain.presentationlayer.department.DepartmentResponseDTO;

import java.util.List;

public interface DepartmentService {
    List<DepartmentResponseDTO> getDepartments();
    DepartmentResponseDTO getDepartmentByDepartmentId(String departmentId);
    DepartmentResponseDTO updateDepartment(String departmentId, DepartmentRequestDTO departmentRequestDTO);
    DepartmentResponseDTO addDepartment(DepartmentRequestDTO departmentRequestDTO);
    void deleteDepartment(String departmentId);

}
