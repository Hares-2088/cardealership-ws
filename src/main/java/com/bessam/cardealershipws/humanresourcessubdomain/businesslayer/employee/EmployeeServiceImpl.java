package com.bessam.cardealershipws.humanresourcessubdomain.businesslayer.employee;

import com.bessam.cardealershipws.humanresourcessubdomain.dataaccesslayer.employee.Employee;
import com.bessam.cardealershipws.humanresourcessubdomain.dataaccesslayer.employee.EmployeeIdentifier;
import com.bessam.cardealershipws.humanresourcessubdomain.dataaccesslayer.employee.EmployeeRepository;
import com.bessam.cardealershipws.humanresourcessubdomain.mapperlayer.employee.EmployeeRequestMapper;
import com.bessam.cardealershipws.humanresourcessubdomain.mapperlayer.employee.EmployeeResponseMapper;
import com.bessam.cardealershipws.humanresourcessubdomain.presentationlayer.employee.EmployeeRequestDTO;
import com.bessam.cardealershipws.humanresourcessubdomain.presentationlayer.employee.EmployeeResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    public EmployeeRepository employeeRepository;
    public EmployeeRequestMapper employeeRequestMapper;
    public EmployeeResponseMapper employeeResponseMapper;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository, EmployeeRequestMapper employeeRequestMapper, EmployeeResponseMapper employeeResponseMapper) {
        this.employeeRepository = employeeRepository;
        this.employeeRequestMapper = employeeRequestMapper;
        this.employeeResponseMapper = employeeResponseMapper;
    }

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<EmployeeResponseDTO> getEmployees() {
        List<Employee> employeeList = employeeRepository.findAll();

        return employeeResponseMapper.entityListToResponseDTOList(employeeList);
    }

    @Override
    public EmployeeResponseDTO getEmployeeByEmployeeId(String employeeId) {

        Employee employee = employeeRepository.findEmployeeByEmployeeIdentifier_EmployeeId(employeeId);

        return employeeResponseMapper.entityToResponseDTO(employee);
    }

    @Override
    public EmployeeResponseDTO updateEmployee(EmployeeRequestDTO employeeRequestDTO, String employeeId) {

        Employee foundEmployee = employeeRepository.findEmployeeByEmployeeIdentifier_EmployeeId(employeeId);

        Employee employee = employeeRequestMapper.requestModelToEntity(employeeRequestDTO, foundEmployee.getEmployeeIdentifier());
        employee.setId(foundEmployee.getId());
        return employeeResponseMapper.entityToResponseDTO(employeeRepository.save(employee));
    }

    @Override
    public EmployeeResponseDTO AddEmployee(EmployeeRequestDTO employeeRequestDTO) {

       Employee employee = employeeRequestMapper.requestModelToEntity(employeeRequestDTO, new EmployeeIdentifier());

        return employeeResponseMapper.entityToResponseDTO(employeeRepository.save(employee));
    }

    @Override
    public void deleteEmployee(String employeeId) {
        Employee foundEmployee = employeeRepository.findEmployeeByEmployeeIdentifier_EmployeeId(employeeId);

        employeeRepository.delete(foundEmployee);
    }
}
