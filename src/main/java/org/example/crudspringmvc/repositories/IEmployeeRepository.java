package org.example.crudspringmvc.repositories;

import org.example.crudspringmvc.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEmployeeRepository extends JpaRepository<Employee,Long> {
}
