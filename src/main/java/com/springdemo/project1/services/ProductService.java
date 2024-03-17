package com.springdemo.project1.services;

import com.springdemo.project1.exceptions.ProductNotFoundException;
import com.springdemo.project1.models.Product;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ProductService {
   Product getSingleProduct(Long id) throws ProductNotFoundException;
   Page<Product> getAllProducts(int page,int size, String sortBy, String sortOrder);
   Product addNewProduct(Product product);

   Product replaceProduct(Long id, Product product) throws ProductNotFoundException;

   boolean deleteProduct(Long id);
}
