package com.kymnyth.recipeapp.services;

import com.kymnyth.recipeapp.domain.Recipe;
import com.kymnyth.recipeapp.repositories.RecipeRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class RecipeServiceImpl implements RecipeService{

    private final RecipeRepository recipeRepository;

    public RecipeServiceImpl(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    public Set<Recipe> getRecipes(){
        Set<Recipe> recipes = new HashSet<>();
        recipeRepository.findAll().iterator().forEachRemaining(recipes::add);
        return recipes;

    }

    public void setRecipes(Set<Recipe> recipes){
        recipeRepository.saveAll(recipes);
    }
}
