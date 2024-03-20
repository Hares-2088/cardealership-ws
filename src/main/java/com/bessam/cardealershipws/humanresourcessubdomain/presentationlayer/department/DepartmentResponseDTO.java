package com.bessam.cardealershipws.humanresourcessubdomain.presentationlayer.department;

import com.bessam.cardealershipws.humanresourcessubdomain.dataaccesslayer.department.Position;
import lombok.*;
import org.springframework.hateoas.RepresentationModel;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public final class DepartmentResponseDTO extends RepresentationModel<DepartmentResponseDTO> {

    private String departmentId;
    private String name;
    private Integer headCount;
    private List<Position> positions;
}

