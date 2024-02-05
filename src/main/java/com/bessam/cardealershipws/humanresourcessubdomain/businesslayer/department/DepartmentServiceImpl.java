package com.bessam.cardealershipws.humanresourcessubdomain.businesslayer.department;

import com.bessam.cardealershipws.humanresourcessubdomain.dataaccesslayer.department.Department;
import com.bessam.cardealershipws.humanresourcessubdomain.dataaccesslayer.department.DepartmentIdentifier;
import com.bessam.cardealershipws.humanresourcessubdomain.dataaccesslayer.department.DepartmentRepository;
import com.bessam.cardealershipws.humanresourcessubdomain.presentationlayer.department.DepartmentController;
import com.bessam.cardealershipws.humanresourcessubdomain.presentationlayer.department.DepartmentRequestDTO;
import com.bessam.cardealershipws.humanresourcessubdomain.presentationlayer.department.DepartmentResponseDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class DepartmentServiceImpl implements DepartmentService{

    public DepartmentRepository departmentRepository;

    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public List<DepartmentResponseDTO> getDepartments() {

        List<Department> departmentList = departmentRepository.findAll();

        List<DepartmentResponseDTO> departmentResponseDTOList = new ArrayList<>();

        for(Department department : departmentList){
            DepartmentResponseDTO departmentResponseDTO = new DepartmentResponseDTO();
            BeanUtils.copyProperties(department, departmentResponseDTO);

            departmentResponseDTOList.add(departmentResponseDTO);
        }

        return departmentResponseDTOList;
    }

    @Override
    public DepartmentResponseDTO getDepartmentById(DepartmentIdentifier departmentIdentifier) {

        Department department = departmentRepository.findDepartmentByDepartmentIdentifier(departmentIdentifier);

        DepartmentResponseDTO departmentResponseDTO = new DepartmentResponseDTO();
        BeanUtils.copyProperties(department, departmentResponseDTO);

        return departmentResponseDTO;
    }

    @Override
    public DepartmentResponseDTO updateDepartment(DepartmentIdentifier departmentIdentifier, DepartmentRequestDTO departmentRequestDTO) {

        Department foundDepartment = departmentRepository.findDepartmentByDepartmentIdentifier(departmentIdentifier);

        Department department = new Department();
        BeanUtils.copyProperties(foundDepartment, department);

        department.setId(foundDepartment.getId());
        department.setDepartmentIdentifier(foundDepartment.getDepartmentIdentifier());

        DepartmentResponseDTO departmentResponseDTO = new DepartmentResponseDTO();
        BeanUtils.copyProperties(department, departmentResponseDTO);

        return departmentResponseDTO;
    }

    @Override
    public DepartmentResponseDTO addDepartment(DepartmentRequestDTO departmentRequestDTO) {

        Department department = new Department();
        BeanUtils.copyProperties(departmentRequestDTO, department);

        department.setDepartmentIdentifier(new DepartmentIdentifier());

        Department savedDepartment = departmentRepository.save(department);

        DepartmentResponseDTO departmentResponseDTO = new DepartmentResponseDTO();
        BeanUtils.copyProperties(savedDepartment, departmentResponseDTO);

        return departmentResponseDTO;
    }

    @Override
    public void deleteDepartment(DepartmentIdentifier departmentIdentifier) {
        Department foundDepartment = departmentRepository.findDepartmentByDepartmentIdentifier(departmentIdentifier);

        departmentRepository.delete(foundDepartment);
    }
}
