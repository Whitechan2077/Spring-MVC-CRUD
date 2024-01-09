package org.example.crudspringmvc.controller;

import org.example.crudspringmvc.dtos.DepartmentDTO;
import org.example.crudspringmvc.dtos.EmployeeDTO;
import org.example.crudspringmvc.entities.Employee;
import org.example.crudspringmvc.service.IDepartmentService;
import org.example.crudspringmvc.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    IEmployeeService employeeService;
    @Autowired
    private IDepartmentService departmentService;
    @PostMapping("/add")
    public String addEmployee(
            Model model
            ,@RequestParam("name")String name
            ,@RequestParam("dob")String dob
            ,@RequestParam("departmentId") String departmentId
            ,@RequestParam("gender") String gender)
    {
        System.out.println(dob);
        Timestamp timestamp = Timestamp.valueOf(dob + " 00:00:00");
        DepartmentDTO departmentDTO = departmentService.getById(Long.valueOf(departmentId));
        System.out.println(departmentDTO.getDepartmentName());
        EmployeeDTO employeeDTO = EmployeeDTO.builder()
                .department(departmentDTO)
                .employeeName(name)
                .dob(timestamp)
                .gender(Boolean.valueOf(gender)).build();
        employeeService.insert(employeeDTO);
        return "redirect:/";
    }
    @GetMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable("id") Long id){
        employeeService.delete(id);
        System.out.println("123");
        return "redirect:/";
    }
    @GetMapping("/edit/{id}")
    public String fillData(Model model,@PathVariable("id") Long id){
        model.addAttribute("employee",employeeService.getById(id));
        model.addAttribute("employeeListUpdate",employeeService.getAll());
        return "index.jsp";
    }
}
