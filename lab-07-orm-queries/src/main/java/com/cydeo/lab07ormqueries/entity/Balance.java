package com.cydeo.lab07ormqueries.entity;

import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import java.math.BigDecimal;

@ToString
@Entity
public class Balance extends BaseEntity {

    private BigDecimal amount;

    @OneToOne
    private Customer customer;
}
