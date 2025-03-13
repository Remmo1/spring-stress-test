package com.example.bookstore;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/store")
@RestController
public class StoreController {
    private final StoreService storeService;

    public StoreController(StoreService storeService) {
        this.storeService = storeService;
    }

    @PostMapping("/book")
    public ResponseEntity<Book> createPerson(@RequestBody Book book, @RequestHeader String authorization) {
        Book saved = storeService.save(book, authorization);
        return saved == null ? ResponseEntity.status(401).build() : ResponseEntity.ok(saved);
    }

}