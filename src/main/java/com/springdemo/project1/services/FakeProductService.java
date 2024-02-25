package com.springdemo.project1.services;

import com.springdemo.project1.dtos.FakeProductDTO;
import com.springdemo.project1.exceptions.ProductNotFoundException;
import com.springdemo.project1.models.Category;
import com.springdemo.project1.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service("fakeproductservice")
public class FakeProductService implements ProductService{

    private RestTemplate restTemplate;

    @Autowired
    public FakeProductService(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    private Product convertFakeProductToProduct(FakeProductDTO fakeProduct){
        Product product = new Product();
        product.setId(fakeProduct.getId());
        product.setTitle(fakeProduct.getTitle());
        product.setPrice(fakeProduct.getPrice());
        product.setDescription(fakeProduct.getDescription());
        product.setImageURL(fakeProduct.getImage());
        product.setCategory(new Category());
        product.getCategory().setName(fakeProduct.getCategory());
        return product;
    }

    @Override
    public Product getSingleProduct(Long id) throws ProductNotFoundException {
       FakeProductDTO productDTO = restTemplate.getForObject("https://fakestoreapi.com/products/" + id,
                FakeProductDTO.class);

       if(productDTO == null){
           throw new ProductNotFoundException(
                   "Product with id:" + id + " doesn't exist."
           );
       }
        return convertFakeProductToProduct(productDTO);
    }

    @Override
    public List<Product> getAllProducts() {
       FakeProductDTO[] response = restTemplate.getForObject(
               "https://fakestoreapi.com/products",FakeProductDTO[].class);

       List<Product> answer = new ArrayList<Product>();
       for(FakeProductDTO dto: response ){
           answer.add(convertFakeProductToProduct(dto));
       }
       return answer;
    }

    @Override
    public Product addNewProduct(Product product) {
        return null;
    }

    @Override
    public Product replaceProduct(Long id, Product product) throws ProductNotFoundException {
        return null;
    }

    @Override
    public boolean deleteProduct(Long id) {
        return false;
    }
}