package com.cydeo.spring05thymeleaf.service;


import java.util.UUID;

public interface CartService {
    void addToCart(UUID productId, Integer quantity);

    void deleteFromCart(UUID productId);
}
