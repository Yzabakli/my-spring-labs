package com.cydeo.lab07ormqueries.entity;

import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.math.BigDecimal;
import java.util.List;

@ToString
@Entity
public class Product extends BaseEntity {

    private String name;
    private BigDecimal price;
    private Integer quantity;
    private Integer remainingQuantity;

    @ToString.Exclude
    @ManyToMany(mappedBy = "products")
    private List<Category> categories = new java.util.ArrayList<>();
}
