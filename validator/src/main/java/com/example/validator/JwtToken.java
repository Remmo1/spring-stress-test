package com.example.validator;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;

public class JwtToken {

    @NotNull
    private String accessToken;

    public JwtToken() {}

    public JwtToken(@JsonProperty("access_token") String accessToken) {
        this.accessToken = accessToken;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

}
