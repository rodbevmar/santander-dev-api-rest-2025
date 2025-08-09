package me.dio.santander_dev_api_rest_2025.service.impl;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import me.dio.santander_dev_api_rest_2025.domain.model.News;
import me.dio.santander_dev_api_rest_2025.domain.repository.NewsRepository;
import me.dio.santander_dev_api_rest_2025.service.NewsService;

@Service
public class NewsServiceImpl implements NewsService {

    private final NewsRepository newsRepository;

    public NewsServiceImpl(NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }

    @Override
    public News findById(Long id) {
        return newsRepository.findById(id)
                .orElseThrow(NoSuchElementException::new);
    }

    @Override
    public News create(News newsToCreate) {
        if (newsToCreate.getId() != null && newsRepository.existsById(newsToCreate.getId())) {
            throw new IllegalArgumentException("News with this ID already exists");
        }
        return newsRepository.save(newsToCreate);
    }

    @Override
    public List<News> findAll() {
        return newsRepository.findAll();
    }
}