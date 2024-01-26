package com.springdemo.project1.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
public class Category {
    private Long id;
    private String name;
}
