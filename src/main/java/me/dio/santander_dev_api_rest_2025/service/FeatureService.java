package me.dio.santander_dev_api_rest_2025.service;

import java.util.List;
import me.dio.santander_dev_api_rest_2025.domain.model.Feature;

public interface FeatureService {

    Feature findById(Long id);

    Feature create(Feature featureToCreate);

    List<Feature> findAll();
}