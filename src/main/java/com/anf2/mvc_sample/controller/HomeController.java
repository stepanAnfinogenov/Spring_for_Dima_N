package com.anf2.mvc_sample.controller;

import com.anf2.mvc_sample.model.Employee;
import com.anf2.mvc_sample.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {
    private EmployeeRepository employeeRepository;

    @Autowired
    public HomeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @GetMapping
    public String getIndex(Model model) {
        model.addAttribute("employees", employeeRepository.findAll());
        model.addAttribute("newemployee", new Employee());

        return "index";
    }

    @PostMapping
    public String createEmployee(Employee employee) {
        employeeRepository.save(employee);

        return "redirect:/";
    }

}
