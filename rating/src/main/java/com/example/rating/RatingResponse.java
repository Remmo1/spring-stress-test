package com.example.rating;


import jakarta.validation.constraints.NotNull;

public class RatingResponse {

    @NotNull
    private int rating;

    public RatingResponse(int rating) {
        this.rating = rating;
    }

    public RatingResponse() {}


    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
