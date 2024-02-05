package com.bessam.cardealershipws.humanresourcessubdomain.presentationlayer.department;

import com.bessam.cardealershipws.humanresourcessubdomain.dataaccesslayer.department.DepartmentIdentifier;
import com.bessam.cardealershipws.humanresourcessubdomain.dataaccesslayer.department.Position;

import java.util.List;

public class DepartmentResponseDTO {

    private DepartmentIdentifier departmentIdentifier;
    private String name;
    private Integer headCount;
    private List<Position> positions;
}

