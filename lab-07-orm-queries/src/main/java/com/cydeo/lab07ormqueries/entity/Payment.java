package com.cydeo.lab07ormqueries.entity;

import com.cydeo.lab07ormqueries.enums.PaymentMethod;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.math.BigDecimal;

@ToString
@Entity
public class Payment extends BaseEntity {

    private BigDecimal paidPrice;
    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;
}
