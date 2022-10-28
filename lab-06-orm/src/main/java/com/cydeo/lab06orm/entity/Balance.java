package com.cydeo.lab06orm.entity;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import java.math.BigDecimal;

@Entity
public class Balance extends BaseEntity {

    private BigDecimal amount;

    @OneToOne
    private Customer customer;
}
