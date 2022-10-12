package com.cydeo.spring05thymeleaf.controller;

import com.cydeo.spring05thymeleaf.service.CartService;
import com.cydeo.spring05thymeleaf.service.impl.CartServiceImpl;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.UUID;

@org.springframework.stereotype.Controller
@RequestMapping("/cart")
public class CartController {

    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping("")
    public String showCart(Model model) {

        model.addAttribute("cart", CartServiceImpl.CART);

        return "cart/show-cart";
    }

    @RequestMapping("/cart-item/delete/{id}")
    public String deleteCartItem(@PathVariable String id) {

        cartService.deleteFromCart(UUID.fromString(id));

        return "redirect:/cart";
    }

    @RequestMapping("/cart-item/add/{id}")
    public String addCartItem(@PathVariable UUID id) {

        cartService.addToCart(id, 1);

        return "redirect:/product/list";
    }
}
