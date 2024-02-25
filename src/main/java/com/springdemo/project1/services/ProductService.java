package com.springdemo.project1.services;

import com.springdemo.project1.exceptions.ProductNotFoundException;
import com.springdemo.project1.models.Product;

import java.util.List;

public interface ProductService {
   Product getSingleProduct(Long id) throws ProductNotFoundException;
   List<Product> getAllProducts();
   Product addNewProduct(Product product);

   Product replaceProduct(Long id, Product product) throws ProductNotFoundException;

   boolean deleteProduct(Long id);
}
