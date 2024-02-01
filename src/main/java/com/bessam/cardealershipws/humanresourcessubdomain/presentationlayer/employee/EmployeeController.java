package com.bessam.cardealershipws.humanresourcessubdomain.presentationlayer.employee;

import com.bessam.cardealershipws.humanresourcessubdomain.businesslayer.employee.EmployeeService;
import com.bessam.cardealershipws.humanresourcessubdomain.dataaccesslayer.employee.EmployeeIdentifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {

    EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping()
    public ResponseEntity<List<EmployeeResponseDTO>> getEmployees(){
        return ResponseEntity.status(HttpStatus.FOUND).body(employeeService.getEmployees());
    }

    @GetMapping("/{employeeIdentifier}")
    public ResponseEntity<EmployeeResponseDTO> getContactById(@PathVariable EmployeeIdentifier employeeIdentifier){
        return ResponseEntity.status(HttpStatus.FOUND).body(employeeService.getEmployeeById(employeeIdentifier));
    }

    @PostMapping()
    public ResponseEntity<EmployeeResponseDTO> createContact(@RequestBody EmployeeRequestDTO contactRequestDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(employeeService.AddEmployee(contactRequestDTO));
    }

    @PutMapping("/{employeeIdentifier}")
    public ResponseEntity<EmployeeResponseDTO> updateContact(@RequestBody EmployeeRequestDTO employeeRequestDTO,
                                                            @PathVariable EmployeeIdentifier employeeIdentifier){
        return ResponseEntity.status(HttpStatus.OK).body(employeeService.UpdateEmployee(employeeRequestDTO, employeeIdentifier));
    }

    @DeleteMapping("/{employeeIdentifier}")
    public ResponseEntity<EmployeeResponseDTO> deleteContact(@PathVariable EmployeeIdentifier employeeIdentifier){
        employeeService.deleteEmployee(employeeIdentifier);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }
}
