package com.example.spring_data_access.dao;

import com.example.spring_data_access.entity.Product;
import com.example.spring_data_access.mappers.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductDaoImp {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public ProductDaoImp(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save(Product product) {
        jdbcTemplate.update("insert into products(product_name, product_price) values (?, ?)",
                product.getName(), product.getPrice());
    }

    public void delete(Long id) {
        jdbcTemplate.update("delete from products where id = ?", id);
    }

    public Product getById(Long id) {
        return jdbcTemplate.queryForObject("select * from products where id= ?",
                new ProductMapper(), id);
    }

    public List<Product> getAllProducts() {
        return jdbcTemplate.query("select * from products",
                new ProductMapper());
    }
}