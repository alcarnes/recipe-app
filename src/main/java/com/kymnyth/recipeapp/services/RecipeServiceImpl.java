package com.kymnyth.recipeapp.services;

import com.kymnyth.recipeapp.domain.Recipe;
import com.kymnyth.recipeapp.repositories.RecipeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeServiceImpl implements RecipeService{

    private final RecipeRepository recipeRepository;

    public RecipeServiceImpl(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    public List<Recipe> getRecipes(){
        return (List<Recipe>) recipeRepository.findAll();

    }

    public void setRecipes(List<Recipe> recipes){
        recipeRepository.saveAll(recipes);
    }
}
