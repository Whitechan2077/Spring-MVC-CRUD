package org.example.crudspringmvc.repositories;

import org.example.crudspringmvc.entities.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDepartmentRepository extends JpaRepository<Department,Long> {
}
