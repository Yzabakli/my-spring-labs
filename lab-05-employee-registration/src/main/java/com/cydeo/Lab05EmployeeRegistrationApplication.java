package com.cydeo;

import com.cydeo.springboot.DataGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Lab05EmployeeRegistrationApplication {

    public static void main(String[] args) {
        DataGenerator.createStates();
        DataGenerator.createEmployee();
        SpringApplication.run(Lab05EmployeeRegistrationApplication.class, args);
    }

}
