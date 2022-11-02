package com.cydeo.lab07ormqueries.repository;

import com.cydeo.lab07ormqueries.entity.Discount;
import com.cydeo.lab07ormqueries.enums.DiscountType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

@Repository
public interface DiscountRepository extends JpaRepository<Discount, BigInteger> {
    //Write a derived query to get discount by name
    Discount findByName(String name);

    //Write a derived query to get all discounts greater than discount amount
    List<Discount> findByDiscountGreaterThan(BigDecimal discount);

    //Write a derived query to get all discounts by specific discount type
    List<Discount> findByDiscountType(DiscountType discountType);

    //Write a JPQL query to get all discounts amount between range of discount amount
    @Query("select d from Discount d where d.discount between ?1 and ?2")
    List<Discount> findByDiscountBetween(BigDecimal discountStart, BigDecimal discountEnd);
}
