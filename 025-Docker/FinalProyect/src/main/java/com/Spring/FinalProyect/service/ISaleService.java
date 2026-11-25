package com.Spring.FinalProyect.service;

import com.Spring.FinalProyect.dto.HighSaleDTO;
import com.Spring.FinalProyect.dto.ProductResponseDTO;
import com.Spring.FinalProyect.dto.SaleRequestDTO;
import com.Spring.FinalProyect.dto.SaleResponseDTO;

import java.time.LocalDate;
import java.util.List;

public interface ISaleService {
    public SaleResponseDTO createSale(SaleRequestDTO dto);
    public List<SaleResponseDTO> findSales();
    public SaleResponseDTO findSale(Long saleCode);
    public SaleResponseDTO updateSale(Long saleCode, SaleRequestDTO dto);
    public void deleteSale(Long saleCode);
    public List<ProductResponseDTO> findSaleProducts(Long saleCode);
    public List<SaleResponseDTO> findSalesByDate(LocalDate saleDate);
    public HighSaleDTO findHighestSale();
}
