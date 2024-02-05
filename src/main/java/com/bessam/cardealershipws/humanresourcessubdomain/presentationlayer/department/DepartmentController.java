package com.bessam.cardealershipws.humanresourcessubdomain.presentationlayer.department;

import com.bessam.cardealershipws.humanresourcessubdomain.businesslayer.department.DepartmentService;
import com.bessam.cardealershipws.humanresourcessubdomain.dataaccesslayer.department.DepartmentIdentifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/departments")
public class DepartmentController {

    DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping()
    public ResponseEntity<List<DepartmentResponseDTO>> getDepartments(){
        return ResponseEntity.status(HttpStatus.FOUND).body(departmentService.getDepartments());
    }

    @GetMapping("/{departmentIdentifier}")
    public ResponseEntity<DepartmentResponseDTO> getDepartmentById(@PathVariable DepartmentIdentifier departmentIdentifier){
        return ResponseEntity.status(HttpStatus.FOUND).body(departmentService.getDepartmentById(departmentIdentifier));
    }

    @PostMapping()
    public ResponseEntity<DepartmentResponseDTO> createDepartment(@RequestBody DepartmentRequestDTO departmentRequestDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(departmentService.addDepartment(departmentRequestDTO));
    }

    @PutMapping("/{departmentIdentifier}")
    public ResponseEntity<DepartmentResponseDTO> updateDepartment(@RequestBody DepartmentRequestDTO departmentRequestDTO,
                                                             @PathVariable DepartmentIdentifier departmentIdentifier){
        return ResponseEntity.status(HttpStatus.OK).body(departmentService.updateDepartment(departmentIdentifier, departmentRequestDTO));
    }

    @DeleteMapping("/{departmentIdentifier}")
    public ResponseEntity<DepartmentResponseDTO> deleteDepartment(@PathVariable DepartmentIdentifier departmentIdentifier){
        departmentService.deleteDepartment(departmentIdentifier);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }
}
