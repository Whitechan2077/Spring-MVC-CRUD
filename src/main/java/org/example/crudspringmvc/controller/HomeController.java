package org.example.crudspringmvc.controller;

import org.example.crudspringmvc.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class HomeController {
    @Autowired
    IEmployeeService employeeService;
    @GetMapping("")
    public String home(Model model){
        model.addAttribute("listEmployee",employeeService.getAll());
        return "index.jsp";
    }
}
