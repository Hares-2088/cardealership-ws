package com.bessam.cardealershipws.humanresourcessubdomain.presentationlayer.department;

import com.bessam.cardealershipws.humanresourcessubdomain.dataaccesslayer.department.Position;
import lombok.*;

import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentRequestDTO{

    private String name;
    private Integer headCount;
    private List<Position> positions;
}
