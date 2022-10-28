package com.cydeo.lab06orm.entity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class CartItem extends BaseEntity {

    private Integer quantity;

    @ManyToOne
    private Cart cart;

    @ManyToOne
    private Product product;
}
