package com.springdemo.project1.services;

import com.springdemo.project1.models.Product;

import java.util.List;

public interface ProductService {
   Product getSingleProduct(Long id);
   List<Product> getAllProducts();
}
