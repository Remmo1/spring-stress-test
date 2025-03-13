package com.example.bookstore;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class StoreService {

    private final BookRepository bookRepository;

    private final WebClient ratingWebClient;

    private final WebClient validateWebClient;

    public StoreService(BookRepository bookRepository, WebClient ratingWebClient, WebClient validateWebClient) {
        this.bookRepository = bookRepository;
        this.ratingWebClient = ratingWebClient;
        this.validateWebClient = validateWebClient;
    }

    public Book save(Book book, String authorization) {

        // check token
        ValidationResponse validationResponse = validateWebClient.post()
                .uri("/jwt/validate")
                .body(BodyInserters.fromValue(new JwtToken(authorization)))
                .retrieve()
                .bodyToMono(ValidationResponse.class).block();

        if (!validationResponse.isValid()) {
            return null;
        }

        // get rating
        RatingResponse ratingResponse = ratingWebClient.get()
                .uri("/rating?title=${title}".replace("${title}", book.getTitle()))
                .retrieve()
                .bodyToMono(RatingResponse.class).block();

        book.setRating(ratingResponse.getRating());

        // save book and return
        return bookRepository.saveAndFlush(book);
    }


}
