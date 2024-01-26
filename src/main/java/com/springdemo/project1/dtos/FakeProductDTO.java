package com.springdemo.project1.dtos;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeProductDTO {
    private Long id;
    private String title;
    private double price;
    private String category;
    private String description;
    private String image;
}
