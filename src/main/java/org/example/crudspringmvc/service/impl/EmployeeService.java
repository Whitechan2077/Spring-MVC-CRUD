package org.example.crudspringmvc.service.impl;

import org.example.crudspringmvc.dtos.EmployeeDTO;
import org.example.crudspringmvc.entities.Employee;
import org.example.crudspringmvc.repositories.IEmployeeRepository;
import org.example.crudspringmvc.service.IEmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class EmployeeService implements IEmployeeService {
    @Autowired
    private ModelMapper mapper;
    @Autowired
    private IEmployeeRepository repository;
    @Override
    public List<EmployeeDTO> getAll() {
        return repository.findAll().stream().map(employee -> mapper.map(employee,EmployeeDTO.class)).toList();
    }

    @Override
    public EmployeeDTO getById(Long id) {
        return mapper.map(repository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Not Found")),EmployeeDTO.class);
    }

    @Override
    public EmployeeDTO insert(EmployeeDTO dto) {
        Employee employee = mapper.map(dto, Employee.class);
        return mapper.map(repository.save(employee), EmployeeDTO.class);
    }

    @Override
    public void update(EmployeeDTO dto) {
        Employee employee = mapper.map(dto, Employee.class);
        mapper.map(repository.save(employee), EmployeeDTO.class);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
