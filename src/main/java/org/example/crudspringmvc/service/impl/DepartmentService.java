package org.example.crudspringmvc.service.impl;

import org.example.crudspringmvc.dtos.DepartmentDTO;
import org.example.crudspringmvc.dtos.EmployeeDTO;
import org.example.crudspringmvc.repositories.IDepartmentRepository;
import org.example.crudspringmvc.service.IDepartmentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class DepartmentService implements IDepartmentService {
    @Autowired
    private ModelMapper mapper;
    @Autowired
    private IDepartmentRepository repository;
    @Override
    public List<DepartmentDTO> getAll() {
        return repository.findAll()
                .stream()
                .map(department -> mapper.map(department,DepartmentDTO.class))
                .toList();
    }

    @Override
    public DepartmentDTO getById(Long id) {
        return mapper.map(repository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Not Found")), DepartmentDTO.class);
    }

    @Override
    public DepartmentDTO insert(DepartmentDTO dto) {
        return null;
    }

    @Override
    public void update(DepartmentDTO dto) {

    }

    @Override
    public void delete(Long id) {

    }
}
