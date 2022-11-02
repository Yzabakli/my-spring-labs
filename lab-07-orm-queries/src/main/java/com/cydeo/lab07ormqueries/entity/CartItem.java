package com.cydeo.lab07ormqueries.entity;

import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@ToString
@Entity
public class CartItem extends BaseEntity {

    private Integer quantity;

    @ManyToOne
    private Cart cart;

    @ManyToOne
    private Product product;
}
