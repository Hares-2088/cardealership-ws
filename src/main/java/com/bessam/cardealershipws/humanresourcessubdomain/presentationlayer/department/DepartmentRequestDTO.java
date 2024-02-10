package com.bessam.cardealershipws.humanresourcessubdomain.presentationlayer.department;

import com.bessam.cardealershipws.humanresourcessubdomain.dataaccesslayer.department.Department;
import com.bessam.cardealershipws.humanresourcessubdomain.dataaccesslayer.department.DepartmentIdentifier;
import com.bessam.cardealershipws.humanresourcessubdomain.dataaccesslayer.department.Position;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class DepartmentRequestDTO{

    private String name;
    private Integer headCount;
    private List<Position> positions;
}
