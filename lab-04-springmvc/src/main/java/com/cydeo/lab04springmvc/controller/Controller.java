package com.cydeo.lab04springmvc.controller;

import com.cydeo.lab04springmvc.model.Profile;
import com.cydeo.lab04springmvc.service.ProductService;
import com.cydeo.lab04springmvc.service.impl.CartServiceImpl;
import com.cydeo.lab04springmvc.service.impl.ProductServiceImpl;
import com.github.javafaker.Faker;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;

@org.springframework.stereotype.Controller
public class Controller {

    Faker faker = new Faker();
    private final ProductService productService;

    public Controller(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping("/cart-detail")
    public String cartDetail(Model model, @RequestParam int index) {

        model.addAttribute("cartItemList", CartServiceImpl.CART_LIST.get(index).getCartItemList());
        return "cart/cart-detail";
    }

    @RequestMapping("/cart-list")
    public String cartList(Model model) {

        model.addAttribute("cartList", CartServiceImpl.CART_LIST);
        return "cart/cart-list";
    }

    @RequestMapping("/lab-list")
    public String labList(Model model) {

        model.addAttribute("firstLab", "Coupling");
        model.addAttribute("secondLab", "IOC");
        model.addAttribute("thirdLab", "DI");
        model.addAttribute("fourthLab", "Spring Boot");
        model.addAttribute("fifthLab", "Spring MVC");
        return "lab/lab-list";
    }

    @RequestMapping({"", "/login-info"})
    public String loginInfo(Model model) {

        Profile profile = new Profile();
        profile.setName(faker.name().firstName());
        profile.setSurname(faker.name().lastName());
        profile.setEmail(faker.internet().emailAddress());
        profile.setPhoneNumber(faker.phoneNumber().phoneNumber());
        profile.setCreatedDate(LocalDateTime.now());

        model.addAttribute("email", profile.getEmail());
        model.addAttribute("phoneNumber", profile.getPhoneNumber());
        model.addAttribute("loginMessage", "welcome " + profile.getName() + " " + profile.getSurname());
        return "login/login-info";
    }

    @RequestMapping("/product-list")
    public String productList(Model model) {

        model.addAttribute("productList", ProductServiceImpl.PRODUCT_LIST);
        return "product/product-list";
    }

    @RequestMapping("/product-list/{productName}")
    public String productListSearch(Model model, @RequestParam String productName) {

        model.addAttribute("productList", productService.searchProduct(productName));
        return "product/product-list";
    }

    @RequestMapping("/profile-info")
    public String profileInfo(Model model) {

        Profile profile = new Profile();
        profile.setName(faker.name().firstName());
        profile.setSurname(faker.name().lastName());
        profile.setEmail(faker.internet().emailAddress());
        profile.setPhoneNumber(faker.phoneNumber().phoneNumber());
        profile.setCreatedDate(LocalDateTime.now());

        model.addAttribute("profile", profile);
        return "profile/profile-info";
    }
}
