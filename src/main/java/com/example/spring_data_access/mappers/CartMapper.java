package com.example.spring_data_access.mappers;

import com.example.spring_data_access.dao.ProductDaoImp;
import com.example.spring_data_access.entity.Cart;
import com.example.spring_data_access.entity.Product;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class CartMapper implements RowMapper<Cart> {
   /* private final ObjectMapper objectMapper;

    public CartMapper(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public Cart mapRow(ResultSet rs, int rowNum) throws SQLException {
        Long id = rs.getLong("id");
        String productsString = rs.getString("products");

        List<Product> products = new ArrayList<>();
        try {
            products = Arrays.asList(objectMapper.readValue(productsString, Product[].class));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new Cart(id, products);
    }
}*/
   @Autowired
   private ProductMapper productMapper;

    @Override
    public Cart mapRow(ResultSet rs, int rowNum) throws SQLException {
        Cart cart = new Cart();
        cart.setId(rs.getLong("id"));
        List<Product> products = (List<Product>) productMapper.mapRow(rs,rowNum);
        cart.setProducts(products);
        return cart;
    }
}