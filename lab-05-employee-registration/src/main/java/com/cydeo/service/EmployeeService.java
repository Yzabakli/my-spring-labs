package com.cydeo.service;

import com.cydeo.model.Employee;
import com.cydeo.springboot.StaticConstants;
import org.springframework.stereotype.Service;

import java.util.Comparator;

@Service
public class EmployeeService {

    public void saveEmployee(Employee employee) {
        StaticConstants.employeeList.add(employee);
        StaticConstants.employeeList.sort(Comparator.comparing(Employee::getFirstName));
    }
}
