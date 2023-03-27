package com.example.spring_data_access.dao;

import com.example.spring_data_access.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProductDao extends JpaRepository<Product, Long> {
    List<Product> findByPriceLessThan(BigDecimal maxPrice);
}
