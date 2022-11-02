package com.cydeo.lab07ormqueries.entity;

import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.List;

@ToString
@Entity
public class Customer extends BaseEntity {

    private String email;
    private String firstName;
    private String lastName;
    private String userName;

    @ToString.Exclude
    @OneToMany(mappedBy = "customer")
    private List<Cart> cart = new java.util.ArrayList<>();

    @ToString.Exclude
    @OneToMany(mappedBy = "customer")
    private List<Order> orders = new java.util.ArrayList<>();

    @OneToOne(mappedBy = "customer")
    private Balance balance;

    @ToString.Exclude
    @OneToMany(mappedBy = "customer")
    private List<Address> addresses = new java.util.ArrayList<>();
}
