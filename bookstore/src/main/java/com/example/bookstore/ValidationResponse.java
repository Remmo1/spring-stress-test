package com.example.bookstore;

import jakarta.validation.constraints.NotNull;

public class ValidationResponse {

    @NotNull
    private boolean isValid;

    public ValidationResponse() {}

    public ValidationResponse(boolean isValid) {
        this.isValid = isValid;
    }

    public boolean isValid() {
        return isValid;
    }

    public void setValid(boolean valid) {
        isValid = valid;
    }
}
