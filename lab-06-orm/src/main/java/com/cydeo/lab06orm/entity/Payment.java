package com.cydeo.lab06orm.entity;

import com.cydeo.lab06orm.enums.PaymentMethod;

import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
public class Payment extends BaseEntity {

    private BigDecimal paidPrice;
    private PaymentMethod paymentMethod;
}
