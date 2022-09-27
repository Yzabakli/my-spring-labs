package com.cydeo.springboot;

import com.cydeo.model.Employee;
import com.github.javafaker.Faker;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Comparator;
import java.util.Random;

import static com.cydeo.springboot.StaticConstants.employeeList;
import static com.cydeo.springboot.StaticConstants.stateList;

public class DataGenerator {


    public static void createStates() {

        Faker faker = new Faker();

        while (stateList.size() != 50) {

            String state = faker.address().state();

            if (!stateList.contains(state)) {
                stateList.add(state);
            }
        }

        stateList.sort(Comparator.comparing(String::toString));
    }

    public static void createEmployee() {

        Faker faker = new Faker();

        for (int i = 0; i < 20; i++) {

            Employee employee = new Employee(faker.name().firstName(), faker.name().lastName(), faker.internet()
                    .emailAddress(), faker.internet().password(), faker.address().streetAddress(), faker.address()
                    .buildingNumber(), faker.address().city(), stateList.get(new Random().nextInt(50)), faker.address()
                    .zipCode(), faker.date().birthday().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
            employee.setAge(LocalDate.now().getYear() - employee.getBirthday().getYear());

            employeeList.add(employee);
        }


        employeeList.sort(Comparator.comparing(Employee::getFirstName));
    }
}
