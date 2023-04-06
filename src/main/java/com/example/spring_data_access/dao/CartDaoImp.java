package com.example.spring_data_access.dao;

import com.example.spring_data_access.entity.Cart;
import com.example.spring_data_access.entity.Product;
import com.example.spring_data_access.mappers.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CartDaoImp {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public CartDaoImp(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void add(Long cartId, Long productId) {
        String sql = "insert into carts_products(cart_id, product_id) values (?, ?)";
        jdbcTemplate.update(sql, cartId, productId);
    }

    public void delete(Long cartId, Long productId) {
        String sql = "delete from carts_products where cart_id = ? AND product_id = ?";
        jdbcTemplate.update(sql, cartId, productId);
    }

    public Cart getById(Long id) {
        String sql = "select * from carts, carts_products" +
                     " where carts.id = carts_products.cart_id AND carts.id = ?";
        List<Product> products = jdbcTemplate.query(sql, new ProductMapper(), new Object[]{id});
        Cart cart = new Cart();
        cart.setProducts(products);
        return cart;
    }

    public void save(Cart cart) {
        jdbcTemplate.update("insert into carts (id) VALUES (?)", cart.getId());
    }
}
