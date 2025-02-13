package com.scaler.FakeStore.Common;


import com.scaler.FakeStore.DTO.UserDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class AuthCommon {

    RestTemplate restTemplate = new RestTemplate();

    AuthCommon(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public UserDTO ValidateToken(String token){

        ResponseEntity<UserDTO> restTemplate1=restTemplate.getForEntity("http://localhost:8081/user/validate/"+token,UserDTO.class);
        if(restTemplate1.getBody()==null){
            return null;
        }
        return restTemplate1.getBody();

    }
}
