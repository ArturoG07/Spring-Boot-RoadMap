package com.Spring.FinalProyect.mapper;

import com.Spring.FinalProyect.dto.HighSaleDTO;
import com.Spring.FinalProyect.dto.ProductResponseDTO;
import com.Spring.FinalProyect.dto.SaleRequestDTO;
import com.Spring.FinalProyect.dto.SaleResponseDTO;
import com.Spring.FinalProyect.exception.CustomerNotFoundException;
import com.Spring.FinalProyect.exception.ProductNotFoundException;
import com.Spring.FinalProyect.model.Customer;
import com.Spring.FinalProyect.model.Product;
import com.Spring.FinalProyect.model.Sale;
import com.Spring.FinalProyect.repository.CustomerRepository;
import com.Spring.FinalProyect.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SaleMapper {
    @Autowired
    ProductMapper productMapper;
    @Autowired
    CustomerMapper customerMapper;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    CustomerRepository customerRepository;

    public SaleResponseDTO toDto(Sale sale) {
        List<ProductResponseDTO> list = new ArrayList<>();
        List<Product> products = sale.getProductList();
        for (Product product : products) {
            list.add(productMapper.toDto(product));
        }
        return new SaleResponseDTO(
                sale.getSaleCode(),
                sale.getSaleDate(),
                sale.getTotal(),
                list,
                customerMapper.toDto(sale.getCustomer())
        );
    }

    private List<Product> findProducts(List<Long> codes) {
        List<Product> products = new ArrayList<>();
        for (Long code : codes) {
            products.add(productRepository.findById(code)
                    .orElseThrow(() -> new ProductNotFoundException(code)));
        }
        return products;
    }

    private Customer findCustomer(Long code) {
        return customerRepository.findById(code)
                .orElseThrow(() -> new CustomerNotFoundException(code));
    }

    private Double calculateTotal(List<Product> products) {
        double total = 0.0;
        for (Product p : products) {
            total += p.getCost();
        }
        return total;
    }

    public void updateEntity(Sale sale, SaleRequestDTO dto) {
        List<Product> products = findProducts(dto.getProductCodes());
        sale.setSaleDate(dto.getSaleDate());
        sale.setCustomer(findCustomer(dto.getCustomerCode()));
        sale.setProductList(products);
        sale.setTotal(calculateTotal(products));
    }

    public Sale toEntity(SaleRequestDTO dto) {
        Sale sale = new Sale();
        updateEntity(sale, dto);
        return sale;
    }

    public HighSaleDTO toHighSaleDTO(SaleResponseDTO dto) {
        HighSaleDTO highSale = new HighSaleDTO();
        highSale.setSaleCode(dto.getSaleCode());
        highSale.setTotal(dto.getTotal());
        highSale.setProductsNumber(Integer.valueOf(dto.getProductList().size()));
        highSale.setCustomerFirstName(dto.getCustomer().getFirstName());
        highSale.setCustomerLastName(dto.getCustomer().getLastName());
        return highSale;
    }
}
