package com.cydeo.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
@NoArgsConstructor
public class Employee {

    @NotBlank
    @Size(max = 12, min = 2)
    @Pattern(regexp = "[a-zA-Z]")
    private String firstName;
    @NotBlank
    @Size(max = 12, min = 2)
    @Pattern(regexp = "[a-zA-Z]")
    private String lastName;
    @Pattern(regexp = "[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\\\.[a-zA-Z0-9-.]+")
    private String email;
    @Pattern(regexp = "(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{4,}")
    private String password;
    @NotBlank
    private String address;
    @NotBlank
    private String address2;
    @NotBlank
    private String city;
    private String state;
    @NotBlank
    private String zip;
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthday;
    private int age;

    public Employee(String firstName, String lastName, String email, String password, String address, String address2, String city, String state, String zip, LocalDate birthday) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.address = address;
        this.address2 = address2;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.birthday = birthday;
    }
}
