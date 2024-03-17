package com.springdemo.project1.controllers;

import com.springdemo.project1.exceptions.ProductNotFoundException;
import com.springdemo.project1.models.Product;
import com.springdemo.project1.utilities.AuthenticationCommons;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
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
    private AuthenticationCommons authenticationCommons;
    @Autowired
    public ProductController(@Qualifier("selfproductservice")ProductService productService, AuthenticationCommons authenticationCommons){
        this.productService = productService;
        this.authenticationCommons = authenticationCommons;
    }

    // Get all Products without Pagination and Sorting
//    @GetMapping("")
//    public ResponseEntity<List<Product>> getAllProducts(){
//        return new ResponseEntity<>(productService.getAllProducts(),
//                    HttpStatus.OK);
//        }

    // Get all Products with Pagination and Sorting
    @GetMapping("")
    public ResponseEntity<Page<Product>> getAllProducts(@RequestParam(value = "page", defaultValue = "0") int page,
                                                        @RequestParam(value = "size", defaultValue = "5") int size,
                                                        @RequestParam(value = "sortBy",defaultValue = "id") String sortBy,
                                                        @RequestParam(value = "sortOrder", defaultValue = "ASC") String sortOrder){
        return new ResponseEntity<>(productService.getAllProducts(page,size,sortBy,sortOrder),
                HttpStatus.OK);
    }

    // Code for Manual Token Validation
//    public ResponseEntity<List<Product>> getAllProducts(@RequestHeader ("AuthenticationToken") String token){
//       if(!authenticationCommons.validateToken(token)) {
//           return new ResponseEntity<>(HttpStatus.FORBIDDEN);
//       }else {
//           return new ResponseEntity<>(productService.getAllProducts(),
//                   HttpStatus.OK);
//       }
//    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getSingleProduct(@PathVariable ("id") Long id) throws ProductNotFoundException {
        return new ResponseEntity<>(productService.getSingleProduct(id),
                HttpStatus.OK);
    }

    @PostMapping()
    public Product addNewProduct
            (@RequestBody Product product){
        return productService.addNewProduct(product);
    }

    @PatchMapping("/{id}")
    public Product updateProduct(@PathVariable("id") Long id, @RequestBody Product product) throws ProductNotFoundException {
       return productService.replaceProduct(id,product);
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

