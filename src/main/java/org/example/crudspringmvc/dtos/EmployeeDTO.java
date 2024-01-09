package org.example.crudspringmvc.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class EmployeeDTO {
    private Long id;
    private Timestamp dob;
    private String employeeName;
    private Boolean gender;
    private DepartmentDTO department;
}
