package com.bessam.cardealershipws.humanresourcessubdomain.businesslayer.employee;

import com.bessam.cardealershipws.humanresourcessubdomain.dataaccesslayer.employee.Employee;
import com.bessam.cardealershipws.humanresourcessubdomain.dataaccesslayer.employee.EmployeeIdentifier;
import com.bessam.cardealershipws.humanresourcessubdomain.dataaccesslayer.employee.EmployeeRepository;
import com.bessam.cardealershipws.humanresourcessubdomain.presentationlayer.employee.EmployeeRequestDTO;
import com.bessam.cardealershipws.humanresourcessubdomain.presentationlayer.employee.EmployeeResponseDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    public EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<EmployeeResponseDTO> getEmployees() {
        List<Employee> employeeList = employeeRepository.findAll();
        List<EmployeeResponseDTO> employeeResponseDTOList = new ArrayList<>();

        for(Employee employee: employeeList){
            EmployeeResponseDTO employeeResponseDTO = new EmployeeResponseDTO();
            BeanUtils.copyProperties(employee, employeeResponseDTO);

            employeeResponseDTOList.add(employeeResponseDTO);
        }
        return employeeResponseDTOList;
    }

    @Override
    public EmployeeResponseDTO getEmployeeById(EmployeeIdentifier employeeIdentifier) {

        Employee employee = employeeRepository.findEmployeeByEmployeeIdentifier(employeeIdentifier);
        EmployeeResponseDTO employeeResponseDTO = new EmployeeResponseDTO();

        BeanUtils.copyProperties(employee, employeeResponseDTO);
        return employeeResponseDTO;
    }

    @Override
    public EmployeeResponseDTO UpdateEmployee(EmployeeRequestDTO employeeRequestDTO, EmployeeIdentifier employeeIdentifier) {

        Employee foundEmployee = employeeRepository.findEmployeeByEmployeeIdentifier(employeeIdentifier);

        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeRequestDTO, employee);

        employee.setId(foundEmployee.getId());
        employee.setEmployeeIdentifier(employee.getEmployeeIdentifier());

        Employee savedEmployee = employeeRepository.save(employee);

        EmployeeResponseDTO employeeResponseDTO = new EmployeeResponseDTO();
        BeanUtils.copyProperties(savedEmployee, employeeResponseDTO);
        return employeeResponseDTO;
    }

    @Override
    public EmployeeResponseDTO AddEmployee(EmployeeRequestDTO employeeRequestDTO) {

       Employee employee = new Employee();
       BeanUtils.copyProperties(employeeRequestDTO, employee);

       employee.setEmployeeIdentifier( new EmployeeIdentifier());

       Employee savedEmployee = employeeRepository.save(employee);
       EmployeeResponseDTO employeeResponseDTO = new EmployeeResponseDTO();

       BeanUtils.copyProperties(savedEmployee, employeeResponseDTO);
        return employeeResponseDTO;
    }

    @Override
    public void deleteEmployee(EmployeeIdentifier employeeIdentifier) {
        Employee foundEmployee = employeeRepository.findEmployeeByEmployeeIdentifier(employeeIdentifier);

        employeeRepository.delete(foundEmployee);
    }
}
