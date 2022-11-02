package com.cydeo.lab07ormqueries.repository;

import com.cydeo.lab07ormqueries.entity.Order;
import com.cydeo.lab07ormqueries.enums.PaymentMethod;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;


@Repository
public interface OrderRepository extends JpaRepository<Order, BigInteger> {
    //Write a derived query to get top 5 orders by order by total price desc
    List<Order> findTop5ByOrderByTotalPriceDesc();

    //Write a derived query to get all orders by specific customer email
    //Write a derived query to get all orders by customer email
    List<Order> findByCustomer_Email(String email);

    //Write a derived query to get all orders by specific payment method
    //Write a derived query to get all orders by specific payment method
    List<Order> findByPayment_PaymentMethod(PaymentMethod paymentMethod);

    //Write a derived query to check is there any orders by customer email
    boolean existsByCustomer_Email(String email);


    //Write a native query to get all orders by specific product name
    // TODO: 02/11/2022

    //Write a native query to get all orders by specific categoryId
    // TODO: 02/11/2022

    //Write a derived query to get all orders by totalPrice and paidPrice are equals
    @Query("SELECT o FROM Order o WHERE o.totalPrice = o.paidPrice")
    List<Order> findByTotalPriceAndPaidPriceEquals();

    //Write a derived query to get all orders by totalPrice and paidPrice are not equals and discount is not null
    @Query("SELECT o FROM Order o WHERE o.totalPrice <> o.paidPrice AND o.cart.discount IS NOT NULL")
    List<Order> findByTotalPriceAndPaidPriceNotEqualsAndCart_DiscountNotNull();
}
