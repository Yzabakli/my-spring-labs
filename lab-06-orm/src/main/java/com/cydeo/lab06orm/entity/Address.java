package com.cydeo.lab06orm.entity;

import javax.persistence.*;

@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    private String name;
    private String street;
    private String zipCode;

    @ManyToOne
    private Customer customer;
}
