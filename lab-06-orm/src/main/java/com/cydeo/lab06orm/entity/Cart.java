package com.cydeo.lab06orm.entity;

import com.cydeo.lab06orm.enums.CartState;

import javax.persistence.*;

@Entity
public class Cart extends BaseEntity {

    @Enumerated(EnumType.STRING)
    private CartState cartState;

    @ManyToOne
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "discount_id")
    private Discount discount;
}
