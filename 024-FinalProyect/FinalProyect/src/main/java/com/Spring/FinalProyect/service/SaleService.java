package com.Spring.FinalProyect.service;

import com.Spring.FinalProyect.dto.HighSaleDTO;
import com.Spring.FinalProyect.dto.ProductResponseDTO;
import com.Spring.FinalProyect.dto.SaleRequestDTO;
import com.Spring.FinalProyect.dto.SaleResponseDTO;
import com.Spring.FinalProyect.exception.SaleNotFoundException;
import com.Spring.FinalProyect.mapper.SaleMapper;
import com.Spring.FinalProyect.model.Sale;
import com.Spring.FinalProyect.repository.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class SaleService implements ISaleService{
    @Autowired
    private SaleRepository saleRepository;
    @Autowired
    private SaleMapper saleMapper;

    @Override
    public SaleResponseDTO createSale(SaleRequestDTO dto) {
        Sale saved = saleRepository.save(saleMapper.toEntity(dto));
        return saleMapper.toDto(saved);
    }

    @Override
    public List<SaleResponseDTO> findSales() {
        List<Sale> sales = saleRepository.findAll();
        List<SaleResponseDTO> list = new ArrayList<>();
        for (Sale sale : sales) {
            list.add(saleMapper.toDto(sale));
        }
        return list;
    }

    @Override
    public SaleResponseDTO findSale(Long saleCode) {
        Sale sale = saleRepository.findById(saleCode)
                .orElseThrow(() -> new SaleNotFoundException(saleCode));
        return saleMapper.toDto(sale);
    }

    @Override
    public SaleResponseDTO updateSale(Long saleCode, SaleRequestDTO dto) {
        Sale sale = saleRepository.findById(saleCode)
                .orElseThrow(() -> new SaleNotFoundException(saleCode));
        saleMapper.updateEntity(sale, dto);
        Sale saved = saleRepository.save(sale);
        return saleMapper.toDto(saved);
    }

    @Override
    public void deleteSale(Long saleCode) {
        if (!saleRepository.existsById(saleCode)) {
            throw new SaleNotFoundException(saleCode);
        }
        saleRepository.deleteById(saleCode);
    }

    @Override
    public List<ProductResponseDTO> findSaleProducts(Long saleCode) {
        return (findSale(saleCode)).getProductList();
    }

    @Override
    public List<SaleResponseDTO> findSalesByDate(LocalDate saleDate) {
        List<SaleResponseDTO> sales = findSales();
        List<SaleResponseDTO> dateSales = new ArrayList<>();
        for (SaleResponseDTO sale : sales) {
            if (sale.getSaleDate().equals(saleDate)) {
                dateSales.add(sale);
            }
        }
        return dateSales;
    }

    @Override
    public HighSaleDTO findHighestSale() {
        return findSales().stream()
                .max(Comparator.comparing(SaleResponseDTO::getTotal))
                .map(saleMapper::toHighSaleDTO)
                .orElseThrow(() -> new SaleNotFoundException(0L));
    }
}
