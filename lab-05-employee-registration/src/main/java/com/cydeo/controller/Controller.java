package com.cydeo.controller;

import com.cydeo.model.Employee;
import com.cydeo.service.EmployeeService;
import com.cydeo.springboot.DataGenerator;
import com.cydeo.springboot.StaticConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import javax.validation.executable.ValidateOnExecution;
import java.time.LocalDate;
import java.util.Comparator;

@org.springframework.stereotype.Controller
public class Controller {

    @GetMapping("/register")
    public String register(Model model) {

        model.addAttribute("employee", new Employee());
        model.addAttribute("states", StaticConstants.stateList);

        return "welcome/register";
    }

    @GetMapping
    public String home() {

        return "welcome/index";
    }

    @GetMapping("/employee/employee-list")
    public String employeeList(Model model) {

        model.addAttribute("employees", StaticConstants.employeeList);

        return "employee/employee-list";
    }

    @PostMapping("/employee/employee-list")
    public String employeeList(@ModelAttribute("employee") @Valid Employee employee, BindingResult bindingResult, @Autowired EmployeeService employeeService, Model model) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("states", StaticConstants.stateList);
            return "welcome/register";
        }

        employee.setAge(LocalDate.now().getYear() - employee.getBirthday().getYear());
        employeeService.saveEmployee(employee);

        return "redirect:/employee/employee-list";
    }
}
