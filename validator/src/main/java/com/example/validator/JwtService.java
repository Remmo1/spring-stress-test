package com.example.validator;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class JwtService {

    private final Random random = new Random();
    private final double probabiltyOfTokenExpiration = 0.05;

    public boolean validate(String accessToken) {
        if (accessToken == null) {
            return false;
        }
        return !(random.nextDouble() < probabiltyOfTokenExpiration);
    }

}
