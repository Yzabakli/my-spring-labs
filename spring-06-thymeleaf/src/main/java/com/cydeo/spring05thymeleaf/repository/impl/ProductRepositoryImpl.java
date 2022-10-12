package com.cydeo.spring05thymeleaf.repository.impl;

import com.cydeo.spring05thymeleaf.model.Product;
import com.cydeo.spring05thymeleaf.repository.ProductRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class ProductRepositoryImpl implements ProductRepository {
    public static List<Product> PRODUCT_LIST = new ArrayList<>();

    @Override
    public void save(Product product) {
        product.setId(UUID.randomUUID());
        PRODUCT_LIST.add(product);
    }

    @Override
    public void update(Product product) {
        Product p = findProductById(product.getId());
        PRODUCT_LIST.remove(p);
        PRODUCT_LIST.add(product);
    }

    @Override
    public void delete(UUID id) {
        PRODUCT_LIST.remove(findProductById(id));
    }

    @Override
    public Product findProductById(UUID productId) {
        return PRODUCT_LIST.stream().filter(product -> product.getId().
                toString().equals(productId.toString())).findFirst().orElseThrow();
    }

    @Override
    public List<Product> findAll() {
        return PRODUCT_LIST;
    }
}
