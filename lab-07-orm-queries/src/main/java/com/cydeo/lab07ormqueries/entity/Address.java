package com.cydeo.lab07ormqueries.entity;

import lombok.ToString;

import javax.persistence.*;

@ToString
@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    private String name;
    private String street;
    private String zipCode;

    @ManyToOne
    private Customer customer;
}
