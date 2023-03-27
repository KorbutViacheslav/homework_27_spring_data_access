package com.example.spring_data_access.dao;

import com.example.spring_data_access.entity.Product;
import com.example.spring_data_access.mappers.ProductMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductDaoImp {
    private final JdbcTemplate jdbcTemplate;

    public ProductDaoImp(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void add(Product product) {
        String sql = "INSERT INTO products (id, name, cost) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, product.getId(), product.getName(), product.getPrice());
    }

    public void delete(Long id) {
        String sql = "DELETE FROM products WHERE id=?";
        jdbcTemplate.update(sql, id);
    }

    public Product findById(Long id) {
        String sql = "SELECT * FROM products WHERE id=?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new ProductMapper());
    }

    public List<Product> findAll() {
        String sql = "SELECT * FROM products";
        return jdbcTemplate.query(sql, new ProductMapper());
    }

    public List<Product> findAvailableProducts() {
        String sql = "SELECT * FROM products WHERE available=true";
        return jdbcTemplate.query(sql, new ProductMapper());
    }
}
