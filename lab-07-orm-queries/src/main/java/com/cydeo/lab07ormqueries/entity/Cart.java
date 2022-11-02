package com.cydeo.lab07ormqueries.entity;

import com.cydeo.lab07ormqueries.enums.CartState;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@ToString
@Entity
public class Cart extends BaseEntity {

    @Enumerated(EnumType.STRING)
    private CartState cartState;

    @ManyToOne
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "discount_id")
    private Discount discount;

    @OneToMany(mappedBy = "cart")
    private List<CartItem> cartItemList;
}
