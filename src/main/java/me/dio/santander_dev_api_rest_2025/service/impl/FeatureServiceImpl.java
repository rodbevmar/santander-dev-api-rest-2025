package me.dio.santander_dev_api_rest_2025.service.impl;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import me.dio.santander_dev_api_rest_2025.domain.model.Feature;
import me.dio.santander_dev_api_rest_2025.domain.repository.FeatureRepository;
import me.dio.santander_dev_api_rest_2025.service.FeatureService;

@Service
public class FeatureServiceImpl implements FeatureService {

    private final FeatureRepository featureRepository;

    public FeatureServiceImpl(FeatureRepository featureRepository) {
        this.featureRepository = featureRepository;
    }

    @Override
    public Feature findById(Long id) {
        return featureRepository.findById(id)
                .orElseThrow(NoSuchElementException::new);
    }

    @Override
    public Feature create(Feature featureToCreate) {
        if (featureToCreate.getId() != null && featureRepository.existsById(featureToCreate.getId())) {
            throw new IllegalArgumentException("Feature with this ID already exists");
        }
        return featureRepository.save(featureToCreate);
    }

    @Override
    public List<Feature> findAll() {
        return featureRepository.findAll();
    }
}