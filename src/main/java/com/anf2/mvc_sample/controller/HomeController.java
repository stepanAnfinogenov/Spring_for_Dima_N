package com.anf2.mvc_sample.controller;

import com.anf2.mvc_sample.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    private EmployeeRepository employeeRepository;

    @Autowired
    public HomeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @RequestMapping("/")
    public String getIndex(Model model) {
        model.addAttribute("employees", employeeRepository.findAll());

        return "index";
    }
}
