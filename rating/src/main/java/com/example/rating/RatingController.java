package com.example.rating;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/rating")
@RestController
public class RatingController {
    private final RatingService ratingService;

    public RatingController(RatingService ratingService) {
        this.ratingService = ratingService;
    }

    @GetMapping
    public ResponseEntity<RatingResponse> getRating(@RequestParam String title) {
        int rating = ratingService.getRating(title);
        return ResponseEntity.ok(new RatingResponse(rating));
    }

}
