package com.springdemo.project1.controllers;

import com.springdemo.project1.exceptions.ProductNotFoundException;
import com.springdemo.project1.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.springdemo.project1.services.ProductService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping ("/products")
public class ProductController {
    private ProductService productService;
    @Autowired
    public ProductController(ProductService productService){
        this.productService = productService;
    }
    @GetMapping("")
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getSingleProduct(@PathVariable ("id") Long id) throws ProductNotFoundException {
        //throw new RuntimeException("Something went wrong");
        return new ResponseEntity<>(productService.getSingleProduct(id),
                HttpStatus.OK);
    }
//    public Product getSingleProduct(@PathVariable ("id") Long id){
//        return null;
//    }

//    public String getSingleProduct(@PathVariable ("id") Long id){
//        return "getProductAPI";
//    }


    @PostMapping()
    public Product addNewProduct(@RequestBody Product product){
        Product p = new Product();
        p.setTitle("new product");
        return new Product();
    }

    @PatchMapping("/{id}")
    public Product updateProduct(@PathVariable("id") Long id, @RequestBody Product product){
        return new Product();
    }

    @PutMapping ("/{id}")
    public Product replaceProduct(@PathVariable("id") Long id, @RequestBody Product product){
        return new Product();
    }

    @DeleteMapping("/{id}")
    public Product deleteProduct(@PathVariable("id") Long id){
        return new Product();
    }
}

