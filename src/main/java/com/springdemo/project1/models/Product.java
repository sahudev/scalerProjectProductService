package com.springdemo.project1.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Entity
public class Product extends BaseModel implements Serializable {
    private String title;
    private Double price;
    @ManyToOne
    private Category category;
    private String description;
    private String imageURL;
    private int numberOfSales;
}
// Product  :  Category
// 1        -> 1
// m        <- 1
// many     : 1