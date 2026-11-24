package com.Spring.FinalProyect.controller;

import com.Spring.FinalProyect.dto.ProductRequestDTO;
import com.Spring.FinalProyect.dto.ProductResponseDTO;
import com.Spring.FinalProyect.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping("/products")
    public ProductResponseDTO createProduct(@RequestBody ProductRequestDTO dto) {
        return productService.createProduct(dto);
    }

    @GetMapping("/products")
    public List<ProductResponseDTO> getProducts() {
        return productService.findProducts();
    }

    @GetMapping("/products/{productCode}")
    public ProductResponseDTO getProduct(@PathVariable Long productCode) {
        return productService.findProduct(productCode);
    }

    @PutMapping("/products/{productCode}")
    public ProductResponseDTO updateProduct(@PathVariable Long productCode,
                                            @RequestBody ProductRequestDTO dto) {
        return productService.updateProduct(productCode, dto);
    }

    @DeleteMapping("/products/{productCode}")
    public void deleteProduct(@PathVariable Long productCode) {
        productService.deleteProduct(productCode);
    }

    @GetMapping("/products/low-stock")
    public List<ProductResponseDTO> getLowStock() {
        return productService.findLowStock();
    }
}
