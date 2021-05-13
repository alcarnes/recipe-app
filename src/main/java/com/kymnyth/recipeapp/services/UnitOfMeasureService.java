package com.kymnyth.recipeapp.services;

import com.kymnyth.recipeapp.domain.UnitOfMeasure;
import com.kymnyth.recipeapp.repositories.UnitOfMeasureRepository;
import org.springframework.stereotype.Service;

@Service
public class UnitOfMeasureService {
    UnitOfMeasureRepository unitOfMeasureRepository;

    public UnitOfMeasureService(UnitOfMeasureRepository unitOfMeasureRepository) {
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    public UnitOfMeasure getUnitOfMeasureByDesc(String description){
        return unitOfMeasureRepository.findUnitOfMeasureByDescription(description).get();
    }
}
