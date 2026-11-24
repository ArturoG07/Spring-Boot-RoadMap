package com.Spring.FinalProyect.controller;

import com.Spring.FinalProyect.dto.HighSaleDTO;
import com.Spring.FinalProyect.dto.ProductResponseDTO;
import com.Spring.FinalProyect.dto.SaleRequestDTO;
import com.Spring.FinalProyect.dto.SaleResponseDTO;
import com.Spring.FinalProyect.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
public class SaleController {
    @Autowired
    private SaleService saleService;

    @PostMapping("/sales")
    public SaleResponseDTO createSale(@RequestBody SaleRequestDTO dto) {
        return saleService.createSale(dto);
    }

    @GetMapping("/sales")
    public List<SaleResponseDTO> getSales() {
        return saleService.findSales();
    }

    @GetMapping("/sales/{saleCode}")
    public SaleResponseDTO getSale(@PathVariable Long saleCode) {
        return saleService.findSale(saleCode);
    }

    @PutMapping("/sales/{saleCode}")
    public SaleResponseDTO updateSale(@PathVariable Long saleCode,
                                      @RequestBody SaleRequestDTO dto) {
        return saleService.updateSale(saleCode, dto);
    }

    @DeleteMapping("/sales/{saleCode}")
    public void deleteSale(@PathVariable Long saleCode) {
        saleService.deleteSale(saleCode);
    }

    @GetMapping("/sales/{saleCode}/products")
    public List<ProductResponseDTO> getSaleProducts(@PathVariable Long saleCode) {
        return saleService.findSaleProducts(saleCode);
    }

    @GetMapping("/sales/summary")
    public List<SaleResponseDTO> getSalesByDate(@RequestParam LocalDate saleDate) {
        return saleService.findSalesByDate(saleDate);
    }

    @GetMapping("/sales/highest")
    public HighSaleDTO getHighSale() {
        return saleService.findHighestSale();
    }


}
