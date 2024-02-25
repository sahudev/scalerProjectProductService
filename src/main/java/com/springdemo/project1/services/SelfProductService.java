package com.springdemo.project1.services;

import com.springdemo.project1.exceptions.ProductNotFoundException;
import com.springdemo.project1.models.Category;
import com.springdemo.project1.models.Product;
import com.springdemo.project1.repositories.CategoryRepository;
import com.springdemo.project1.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service ("selfproductservice")
public class SelfProductService implements ProductService{

    private CategoryRepository categoryRepository;
    private ProductRepository productRepository;

    @Autowired
    public SelfProductService(
            ProductRepository productRepository,
            CategoryRepository categoryRepository){
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Product getSingleProduct(Long id) throws ProductNotFoundException {
        Optional<Product> productOptional = productRepository.findById(id);
        if(productOptional.isEmpty()) {
            throw new ProductNotFoundException("Product with id:" + id + " does not exist");
        }
        Product product = productOptional.get();
        return product;
    }

    @Override
    public List<Product> getAllProducts() {
        return null;
    }

    @Override
    public Product addNewProduct(Product product) {
        Category category = product.getCategory();
        if(category.getId() ==null){
            categoryRepository.save(category);
        }
        return productRepository.save(product);
    }

    @Override
    public Product replaceProduct(Long id, Product product) throws ProductNotFoundException {
        // fetch the product using id
        Optional<Product> productOptional = productRepository.findById(id);
        if(productOptional.isEmpty()){
            throw new ProductNotFoundException("Product id:" + id + " is not found");
        }
        // update the changed field
        Product oldProduct = productOptional.get();
        if(product.getTitle() !=null){
            oldProduct.setTitle(product.getTitle());
        }
        if (product.getDescription() !=null){
            oldProduct.setDescription(product.getDescription());
        }
        if (product.getPrice() !=null){
            oldProduct.setPrice(product.getPrice());
        }
        // run the save query
        return productRepository.save(oldProduct);
    }

    @Override
    public boolean deleteProduct(Long id) {
        return false;
    }
}
