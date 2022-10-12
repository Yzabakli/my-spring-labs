package com.cydeo.spring05thymeleaf.service.impl;


import com.cydeo.spring05thymeleaf.model.Product;
import com.cydeo.spring05thymeleaf.repository.ProductRepository;
import com.cydeo.spring05thymeleaf.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public boolean productCreate(Product product) {

        productRepository.save(product);

        return productRepository.findAll().contains(product);
    }

    @Override
    public void productUpdate(Product product) {

        productRepository.update(product);
    }

    @Override
    public void productDelete(UUID id) {

        productRepository.delete(id);
    }

    @Override
    public List<Product> listProduct() {

        return productRepository.findAll();
    }

    @Override
    public Product findProductById(UUID uuid) {

        return productRepository.findProductById(uuid);
    }

}
