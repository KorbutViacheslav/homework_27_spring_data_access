package com.example.spring_data_access.dao;

import com.example.spring_data_access.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface СartDao extends JpaRepository<Cart, Long> {}
