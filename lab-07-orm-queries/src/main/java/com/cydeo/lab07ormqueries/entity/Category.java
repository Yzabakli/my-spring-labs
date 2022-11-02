package com.cydeo.lab07ormqueries.entity;

import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import java.util.List;

@ToString
@Entity
public class Category extends BaseEntity {

    private String name;

    @ToString.Exclude
    @ManyToMany
    @JoinTable(name = "product_category_rel",
            joinColumns = @JoinColumn(name = "p_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "c_id", referencedColumnName = "id"))
    private List<Product> products = new java.util.ArrayList<>();

    public List<Product> getProducts() {
        return products;
    }
}
