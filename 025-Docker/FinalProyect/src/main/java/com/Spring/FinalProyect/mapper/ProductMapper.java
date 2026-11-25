package com.Spring.FinalProyect.mapper;

import com.Spring.FinalProyect.dto.ProductRequestDTO;
import com.Spring.FinalProyect.dto.ProductResponseDTO;
import com.Spring.FinalProyect.model.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {
    public ProductResponseDTO toDto(Product product) {
        return new ProductResponseDTO(
                product.getProductCode(),
                product.getName(),
                product.getBrand(),
                product.getCost(),
                product.getAvailableQuantity()
        );
    }
    public Product toEntity(ProductRequestDTO dto) {
        Product product = new Product();
        product.setName(dto.getName());
        product.setBrand(dto.getBrand());
        product.setCost(dto.getCost());
        product.setAvailableQuantity(dto.getAvailableQuantity());
        return product;
    }
    public void updateEntity(Product product, ProductRequestDTO dto) {
        product.setName(dto.getName());
        product.setBrand(dto.getBrand());
        product.setCost(dto.getCost());
        product.setAvailableQuantity(dto.getAvailableQuantity());
    }
}
