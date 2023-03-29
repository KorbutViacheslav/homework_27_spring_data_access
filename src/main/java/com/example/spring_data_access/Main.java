package com.example.spring_data_access;

import com.example.spring_data_access.config.JdbcConfig;
import com.example.spring_data_access.dao.CartDaoImp;
import com.example.spring_data_access.dao.ProductDaoImp;
import com.example.spring_data_access.entity.Product;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JdbcConfig.class);
        ProductDaoImp productDaoImp=context.getBean(ProductDaoImp.class);
        CartDaoImp cartDaoImp=context.getBean(CartDaoImp.class);
        Product cola=new Product(1L,"Cola",new BigDecimal(2));
        Product beer=new Product(2L,"Beer",new BigDecimal(5));
        productDaoImp.add(cola);
        productDaoImp.add(beer);
        System.out.println(productDaoImp.findAll());
    }
}
