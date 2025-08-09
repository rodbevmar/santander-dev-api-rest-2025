package me.dio.santander_dev_api_rest_2025.controller;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import me.dio.santander_dev_api_rest_2025.domain.model.Card;
import me.dio.santander_dev_api_rest_2025.service.CardService;

@RestController
@RequestMapping("/cards")
public class CardController {

    private final CardService cardService;

    public CardController(CardService cardService) {
        this.cardService = cardService;
    }

    @PostMapping
    public ResponseEntity<Card> createCard(@RequestBody Card cardToCreate) {
        var cardCreated = cardService.create(cardToCreate);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(cardCreated.getId())
                .toUri();
        return ResponseEntity.created(location).body(cardCreated);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Card> findById(@PathVariable Long id) {
        var card = cardService.findById(id);
        return ResponseEntity.ok(card);
    }

    @GetMapping
    public ResponseEntity<List<Card>> findAll() {
        return ResponseEntity.ok(cardService.findAll());
    }
}