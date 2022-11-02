package com.cydeo.lab07ormqueries.entity;

import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.math.BigDecimal;

@ToString
@Entity
@Table(name = "Orders")
public class Order extends BaseEntity {

    private BigDecimal paidPrice;
    private BigDecimal totalPrice;

    @OneToOne
    private Cart cart;

    @ManyToOne
    private Customer customer;

    @OneToOne
    private Payment payment;
}
