package com.Spring.Lists.controller;

import com.Spring.Lists.model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ListsController {
    @GetMapping("/products")
    public String getProducts(Model model) {
        List<Product> products = List.of(
                new Product(1L, "iPhone 15", "Apple smartphone with 128 GB of storage", 799.99),
                new Product(2L, "Samsung Galaxy S24", "Samsung smartphone with 256 GB of storage", 849.99),
                new Product(3L, "MacBook Air M3", "Apple laptop with M3 chip and 16 GB of RAM", 1299.99),
                new Product(4L, "Logitech MX Master 3S", "Ergonomic wireless mouse", 109.99),
                new Product(5L, "Sony WH-1000XM5", "Wireless headphones with noise cancellation", 299.99),
                new Product(6L, "Samsung T7 SSD", "External SSD with 1 TB of storage", 99.99),
                new Product(7L, "LG UltraGear 27GP850", "27-inch gaming monitor with 165 Hz refresh rate", 349.99),
                new Product(8L, "Keychron K2", "Wireless mechanical keyboard", 89.99),
                new Product(9L, "PlayStation 5", "Sony video game console", 549.99),
                new Product(10L, "JBL Flip 6", "Portable Bluetooth speaker with water resistance", 129.99)
        );
        model.addAttribute("productsList", products);
        return "products";
    }
}
