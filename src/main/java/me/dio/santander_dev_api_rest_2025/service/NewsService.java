package me.dio.santander_dev_api_rest_2025.service;

import java.util.List;
import me.dio.santander_dev_api_rest_2025.domain.model.News;

public interface NewsService {

    News findById(Long id);

    News create(News newsToCreate);

    List<News> findAll();
}