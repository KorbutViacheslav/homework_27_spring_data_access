package com.example.spring_data_access;

import com.example.spring_data_access.config.JdbcConfig;
import com.example.spring_data_access.dao.CartDaoImp;
import com.example.spring_data_access.dao.ProductDaoImp;
import com.example.spring_data_access.entity.Cart;
import com.example.spring_data_access.entity.Product;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.math.BigDecimal;
import java.util.ArrayList;


public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JdbcConfig.class);

        CartDaoImp cartDao = context.getBean(CartDaoImp.class);
        ProductDaoImp productDao = context.getBean(ProductDaoImp.class);

        Product beer = new Product(1L, "Beer", new BigDecimal(5));
        Product cola = new Product(2L, "Cola", new BigDecimal(3));
        Product water = new Product(3L, "Water", new BigDecimal(1));
        productDao.save(beer);
        productDao.save(cola);
        productDao.save(water);
        productDao.delete(1L);

        Cart cart1 = new Cart(1L, new ArrayList<>());
        Cart cart2 = new Cart(2L, new ArrayList<>());
        cartDao.save(cart1);
        cartDao.save(cart2);
        cartDao.add(1L, 2L);
        cartDao.add(2L, 2L);
        cartDao.add(2L, 3L);
        cartDao.delete(2L, 2L);

    }
}