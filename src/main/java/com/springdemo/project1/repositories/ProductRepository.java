package com.springdemo.project1.repositories;

import com.springdemo.project1.models.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
//public interface ProductRepository extends JpaRepository<Product,Long> {
public interface ProductRepository extends PagingAndSortingRepository<Product,Long> {

    Optional<Product> findById(Long id);

    Product save(Product product);

    @Query("select p from Product p where p.id = 52")
    List<Product> somethingsomething();

    // paging and sorting
    Page<Product> findAll(Pageable pageable);
}