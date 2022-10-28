package com.cydeo.lab06orm.entity;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.Set;

@Entity
public class Customer extends BaseEntity {

    private String email;
    private String firstName;
    private String lastName;
    private String userName;

    @OneToMany(mappedBy = "customer")
    private Set<Cart> cart;

    @OneToMany(mappedBy = "customer")
    private Set<Order> orders;

    @OneToOne(mappedBy = "customer")
    private Balance balance;

    @OneToMany(mappedBy = "customer")
    private Set<Address> addresses;
}
