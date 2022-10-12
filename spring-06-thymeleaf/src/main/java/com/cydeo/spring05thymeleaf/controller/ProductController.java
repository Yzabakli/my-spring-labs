package com.cydeo.spring05thymeleaf.controller;

import com.cydeo.spring05thymeleaf.model.Product;
import com.cydeo.spring05thymeleaf.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@Controller
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/create")
    public String createProduct(Model model) {

        model.addAttribute("product", new Product());

        return "product/create-product";
    }

    @PostMapping("/create")
    public String productCreateConfirmation(@Valid Product product, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {

            return "product/create-product";
        }
        productService.productCreate(product);

        return "redirect:/product/list";
    }

    @GetMapping("/update/{id}")
    public String updateProduct(Model model, @PathVariable("id") String id) {

        model.addAttribute("product", productService.findProductById(UUID.fromString(id)));

        return "product/update-product";
    }

    @PostMapping("/update/{id}")
    public String updateProduct(@Valid Product product, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {

            return "product/update-product";
        }
        productService.productUpdate(product);

        return "redirect:/product/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable String id) {

        productService.productDelete(UUID.fromString(id));

        return "redirect:/product/list";
    }

    @GetMapping("/list")
    public String listProducts(Model model) {

        model.addAttribute("productList", productService.listProduct());

        return "product/list";
    }
}
