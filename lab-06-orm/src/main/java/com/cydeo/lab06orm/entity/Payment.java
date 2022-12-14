package com.cydeo.lab06orm.entity;

import com.cydeo.lab06orm.enums.PaymentMethod;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.math.BigDecimal;

@Entity
public class Payment extends BaseEntity {

    private BigDecimal paidPrice;
    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;
}
