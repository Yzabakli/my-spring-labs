package com.cydeo.spring05thymeleaf.service.impl;

import com.cydeo.spring05thymeleaf.model.Cart;
import com.cydeo.spring05thymeleaf.model.CartItem;
import com.cydeo.spring05thymeleaf.model.Product;
import com.cydeo.spring05thymeleaf.service.CartService;
import com.cydeo.spring05thymeleaf.service.ProductService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.UUID;

@Service
public class CartServiceImpl implements CartService {
    public static Cart CART = new Cart(BigDecimal.ZERO, new ArrayList<>());

    private final ProductService productService;

    public CartServiceImpl(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public void addToCart(UUID productId, Integer quantity) {

        Product product = productService.findProductById(productId);

        product.setRemainingQuantity(product.getRemainingQuantity() - 1);

        if (CART.getCartItemList().stream().anyMatch(cartItem -> cartItem.getProduct().getId().equals(productId))) {

            CartItem cartItem2 = CART.getCartItemList()
                    .stream()
                    .filter(cartItem -> cartItem.getProduct().getId().equals(productId))
                    .findFirst()
                    .orElseThrow();
            cartItem2.setQuantity(cartItem2.getQuantity() + quantity);
            cartItem2.setTotalAmount(cartItem2.getTotalAmount()
                    .add(product.getPrice().multiply(BigDecimal.valueOf(quantity))));

            CART.setCartTotalAmount(CART.getCartTotalAmount().add(product.getPrice()));

            return;
        }

        CartItem cartItem = new CartItem();

        cartItem.setProduct(product);
        cartItem.setQuantity(quantity);
        cartItem.setTotalAmount(product.getPrice().multiply(BigDecimal.valueOf(quantity)));

        CART.setCartTotalAmount(CART.getCartTotalAmount().add(cartItem.getTotalAmount()));

        CART.getCartItemList().add(cartItem);

    }

    @Override
    public void deleteFromCart(UUID productId) {

        CartItem cartItem = CART.getCartItemList()
                .stream()
                .filter(cartItem1 -> cartItem1.getProduct().getId().equals(productId))
                .findFirst()
                .orElseThrow();

        CART.setCartTotalAmount(CART.getCartTotalAmount().subtract(cartItem.getTotalAmount()));

        Product product = productService.findProductById(productId);

        product.setRemainingQuantity(product.getRemainingQuantity() + cartItem.getQuantity());

        CART.getCartItemList().remove(cartItem);
    }
}
