package me.dio.santander_dev_api_rest_2025.service;

import java.util.List;
import me.dio.santander_dev_api_rest_2025.domain.model.Card;

public interface CardService {

    Card findById(Long id);

    Card create(Card cardToCreate);

    List<Card> findAll();
}
