package com.springdemo.project1.utilities;

import com.springdemo.project1.dtos.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class AuthenticationCommons {
    private RestTemplate restTemplate;


    public AuthenticationCommons(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public boolean validateToken(String token) {
        // validate the token
        ResponseEntity<UserDto> userDtoResponseEntity = restTemplate.postForEntity("http://localhost:8080/validate/" + token, null, UserDto.class);
        if(userDtoResponseEntity.getBody() == null){
            return false;
        }else{
            return true;
        }
    }
}