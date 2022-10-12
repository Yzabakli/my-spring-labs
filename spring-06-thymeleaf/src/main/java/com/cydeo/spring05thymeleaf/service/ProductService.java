package com.cydeo.spring05thymeleaf.service;


import com.cydeo.spring05thymeleaf.model.Product;

import java.util.List;
import java.util.UUID;

public interface ProductService {
    void productCreate(Product product);

    void productUpdate(Product product);

    void productDelete(UUID id);

    List<Product> listProduct();

    Product findProductById(UUID uuid);
}
