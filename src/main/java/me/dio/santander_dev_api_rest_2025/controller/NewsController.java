package me.dio.santander_dev_api_rest_2025.controller;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import me.dio.santander_dev_api_rest_2025.domain.model.News;
import me.dio.santander_dev_api_rest_2025.service.NewsService;

@RestController
@RequestMapping("/news")
public class NewsController {

    private final NewsService newsService;

    public NewsController(NewsService newsService) {
        this.newsService = newsService;
    }

    @PostMapping
    public ResponseEntity<News> createNews(@RequestBody News newsToCreate) {
        var newsCreated = newsService.create(newsToCreate);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(newsCreated.getId())
                .toUri();
        return ResponseEntity.created(location).body(newsCreated);
    }

    @GetMapping("/{id}")
    public ResponseEntity<News> findById(@PathVariable Long id) {
        var news = newsService.findById(id);
        return ResponseEntity.ok(news);
    }

    @GetMapping
    public ResponseEntity<List<News>> findAll() {
        return ResponseEntity.ok(newsService.findAll());
    }
}