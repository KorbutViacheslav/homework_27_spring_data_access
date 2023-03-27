package com.example.spring_data_access.dao;

import com.example.spring_data_access.entity.Cart;
import com.example.spring_data_access.mappers.CartMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CartDaoImp {
    private final JdbcTemplate jdbcTemplate;
    private final CartMapper cartMapper;

    public CartDaoImp(JdbcTemplate jdbcTemplate, CartMapper cartMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.cartMapper = cartMapper;
    }

    public void add(Cart cart) {
        String sql = "INSERT INTO carts (id, products) VALUES (?, ?)";
        jdbcTemplate.update(sql, cart.getId(), cart.getProducts().toString());
    }

    public void deleteById(Long id) {
        String sql = "DELETE FROM carts WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    public Cart findById(Long id) {
        String sql = "SELECT * FROM carts WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, cartMapper);
    }
}