package com.cydeo.lab07ormqueries.repository;

import com.cydeo.lab07ormqueries.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, BigInteger> {

    //Write a derived query to get top 3 product order by price desc
    List<Product> findTop3ByOrderByPriceDesc();

    //Write a derived query to get product by specific name
    Product findByName(String name);

    //Write a derived query to get product by specific category
    Product findByCategories_Name(String name);

    //Write a derived query to get count by price greater than specific amount
    long countByPriceGreaterThan(BigDecimal price);

    //Write a derived query to get all product by quantity greater than or equal specific count
    List<Product> findByQuantityGreaterThanEqual(Integer quantity);

    //Write a native query to get all product by price greater than specific amount and quantity lower than specific count
    @Query(value = "SELECT * FROM product WHERE price > ?1 AND quantity < ?2", nativeQuery = true)
    List<Product> findByPriceGreaterThan(BigDecimal price, Integer quantity);

    //Write a native query to get all product by specific categoryId
    @Query(value = "SELECT * FROM product WHERE id IN (SELECT p_id FROM product_category_rel WHERE c_id = ?1)", nativeQuery = true)
    List<Product> findByCategories_Id(BigInteger id);

    //Write a native query to get all product by specific categoryId and price greater than specific amount
    @Query(value = "SELECT * FROM product WHERE id IN (SELECT p_id FROM product_category_rel WHERE c_id = ?1) AND price > ?2", nativeQuery = true)
    List<Product> findByCategories_IdAAndPriceGreaterThan(BigInteger id, BigDecimal price);
}
