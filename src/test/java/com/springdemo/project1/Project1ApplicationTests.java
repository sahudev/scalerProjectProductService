package com.springdemo.project1;

import com.springdemo.project1.models.Product;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.springdemo.project1.repositories.ProductRepository;

import java.util.List;

//@SpringBootTest
class Project1ApplicationTests {
//
//	ProductRepository productRepository;
//
//	@Autowired
//	public Project1ApplicationTests(ProductRepository productRepository){
//		this.productRepository = productRepository;
//	}
	@Test
	void contextLoads() {
	}
//
//	@Test
//	@Transactional
//	void testQueries(){
//		List<Product> products = productRepository.somethingsomething();
//	}
}