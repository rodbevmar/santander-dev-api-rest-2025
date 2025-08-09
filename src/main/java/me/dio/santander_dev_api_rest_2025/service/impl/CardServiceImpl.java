package me.dio.santander_dev_api_rest_2025.service.impl;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import me.dio.santander_dev_api_rest_2025.domain.model.Card;
import me.dio.santander_dev_api_rest_2025.domain.repository.CardRepository;
import me.dio.santander_dev_api_rest_2025.service.CardService;

@Service
public class CardServiceImpl implements CardService {

    private final CardRepository cardRepository;

    public CardServiceImpl(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    @Override
    public Card findById(Long id) {
        return cardRepository.findById(id)
                .orElseThrow(NoSuchElementException::new);
    }

    @Override
    public Card create(Card cardToCreate) {
        if (cardToCreate.getId() != null && cardRepository.existsById(cardToCreate.getId())) {
            throw new IllegalArgumentException("Card with this ID already exists");
        }
        return cardRepository.save(cardToCreate);
    }

    @Override
    public List<Card> findAll() {
        return cardRepository.findAll();
    }
}