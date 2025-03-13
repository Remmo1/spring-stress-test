package com.example.validator;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/jwt")
@RestController
public class JwtController {
    private final JwtService jwtService;

    public JwtController(JwtService jwtService) {
        this.jwtService = jwtService;
    }

    @PostMapping("/validate")
    public ResponseEntity<ValidationResponse> validateToken(@RequestBody JwtToken accessToken) {
        boolean isValid = jwtService.validate(accessToken.getAccessToken());
        return ResponseEntity.ok(new ValidationResponse(isValid));
    }

}
