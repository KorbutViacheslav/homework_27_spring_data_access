package com.example.spring_data_access.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cart {
    private Long id;

    @ManyToMany
    private List<Product> products = new ArrayList<>();
}
