package com.cydeo.lab07ormqueries.repository;


import com.cydeo.lab07ormqueries.entity.CartItem;
import com.cydeo.lab07ormqueries.enums.CartState;
import com.cydeo.lab07ormqueries.enums.DiscountType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, BigInteger> {

    //Write a derived query to get count cart items
    long countBy();

    //Write a derived query to get cart items for specific cart state
    List<CartItem> findByCart_CartState(CartState cartState);

    //Write a native query to get cart items for specific cart state and product name
    @Query(value = "SELECT * FROM cart_item WHERE cart_id IN (SELECT id FROM cart WHERE cart_state = ?1) AND product_id IN (SELECT id FROM product WHERE name = ?2)", nativeQuery = true)
    List<CartItem> findByCart_CartStateAndProduct_Name(CartState cartState, String name);

    //Write a native query to get cart items for specific cart state and without discount
    @Query(value = "SELECT * FROM cart_item WHERE cart_id IN (SELECT id FROM cart WHERE cart_state = ?1 AND discount_id IS NULL)", nativeQuery = true)
    List<CartItem> findByCart_CartStateAndCart_DiscountNull(CartState cartState);

    //Write a native query to get cart items for specific cart state and with specific Discount type
    @Query(value = "SELECT * FROM cart_item WHERE cart_id IN (SELECT id FROM cart WHERE cart_state = ?1 AND discount_id IN (SELECT id FROM discount WHERE discount_type = ?2))", nativeQuery = true)
    List<CartItem> findByCart_CartStateAndCart_Discount_DiscountType(CartState cartState, DiscountType discountType);
}
