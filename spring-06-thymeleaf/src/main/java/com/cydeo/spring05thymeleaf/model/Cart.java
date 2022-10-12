package com.cydeo.spring05thymeleaf.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cart {
    private BigDecimal cartTotalAmount;
    private List<CartItem> cartItemList;

}
