package me.dio.santander_dev_api_rest_2025.controller;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import me.dio.santander_dev_api_rest_2025.domain.model.Feature;
import me.dio.santander_dev_api_rest_2025.service.FeatureService;

@RestController
@RequestMapping("/features")
public class FeatureController {

    private final FeatureService featureService;

    public FeatureController(FeatureService featureService) {
        this.featureService = featureService;
    }

    @PostMapping
    public ResponseEntity<Feature> createFeature(@RequestBody Feature featureToCreate) {
        var featureCreated = featureService.create(featureToCreate);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(featureCreated.getId())
                .toUri();
        return ResponseEntity.created(location).body(featureCreated);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Feature> findById(@PathVariable Long id) {
        var feature = featureService.findById(id);
        return ResponseEntity.ok(feature);
    }

    @GetMapping
    public ResponseEntity<List<Feature>> findAll() {
        return ResponseEntity.ok(featureService.findAll());
    }
}