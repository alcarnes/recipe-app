package com.kymnyth.recipeapp.repositories;

import com.kymnyth.recipeapp.domain.UnitOfMeasure;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class UnitOfMeasureRepositoryIT {

    @Autowired
    UnitOfMeasureRepository unitOfMeasureRepository;


    @Test
    void findByDescriptionTeaspoon() throws Exception {
        Optional<UnitOfMeasure> uomOptional = unitOfMeasureRepository.findUnitOfMeasureByDescription("Teaspoon");
        assertEquals("Teaspoon", uomOptional.get().getDescription());
    }

    @Test
    void findByDescriptionCup() throws Exception {
        Optional<UnitOfMeasure> uomOptional = unitOfMeasureRepository.findUnitOfMeasureByDescription("Cup");
        assertEquals("Cup", uomOptional.get().getDescription());
    }
}