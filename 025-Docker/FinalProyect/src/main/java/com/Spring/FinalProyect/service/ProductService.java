package com.Spring.FinalProyect.service;

import com.Spring.FinalProyect.dto.ProductRequestDTO;
import com.Spring.FinalProyect.dto.ProductResponseDTO;
import com.Spring.FinalProyect.exception.ProductNotFoundException;
import com.Spring.FinalProyect.mapper.ProductMapper;
import com.Spring.FinalProyect.model.Product;
import com.Spring.FinalProyect.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService implements IProductService{

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductMapper productMapper;

    @Override
    public ProductResponseDTO createProduct(ProductRequestDTO dto) {
        Product saved = productRepository.save(productMapper.toEntity(dto));
        return productMapper.toDto(saved);
    }

    @Override
    public List<ProductResponseDTO> findProducts() {
        List<Product> products = productRepository.findAll();
        List<ProductResponseDTO> list = new ArrayList<>();
        for (Product product : products) {
            list.add(productMapper.toDto(product));
        }
        return list;
    }

    @Override
    public ProductResponseDTO findProduct(Long productCode) {
        Product product = productRepository.findById(productCode)
                .orElseThrow(() -> new ProductNotFoundException(productCode));
        return productMapper.toDto(product);
    }

    @Override
    public ProductResponseDTO updateProduct(Long productCode, ProductRequestDTO dto) {
        Product product = productRepository.findById(productCode)
                .orElseThrow(() -> new ProductNotFoundException(productCode));
        productMapper.updateEntity(product, dto);
        Product saved = productRepository.save(product);
        return productMapper.toDto(saved);
    }

    @Override
    public void deleteProduct(Long productCode) {
        if (!productRepository.existsById(productCode)) {
            throw new ProductNotFoundException(productCode);
        }
        productRepository.deleteById(productCode);
    }

    @Override
    public List<ProductResponseDTO> findLowStock() {
        List<ProductResponseDTO> products = findProducts();
        List<ProductResponseDTO> lowStock = new ArrayList<>();
        for (ProductResponseDTO product: products) {
            if(product.getAvailableQuantity() < 5) {
                lowStock.add(product);
            }
        }
        return lowStock;
    }
}
