package com.cydeo.spring05thymeleaf.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
public class Product {

    private UUID id;

    @NotNull
    @Positive
    private Integer remainingQuantity;

    private Integer quantity;

    @NotNull
    @Positive
    private BigDecimal price;

    @NotBlank
    private String name;

    @NotBlank
    private String image;
}
