package com.Spring.FinalProyect.service;

import com.Spring.FinalProyect.dto.ProductRequestDTO;
import com.Spring.FinalProyect.dto.ProductResponseDTO;

import java.util.List;

public interface IProductService {
    public ProductResponseDTO createProduct(ProductRequestDTO dto);
    public List<ProductResponseDTO> findProducts();
    public ProductResponseDTO findProduct(Long productCode);
    public ProductResponseDTO updateProduct(Long productCode, ProductRequestDTO dto);
    public void deleteProduct(Long productCode);
    public List<ProductResponseDTO> findLowStock();
}
