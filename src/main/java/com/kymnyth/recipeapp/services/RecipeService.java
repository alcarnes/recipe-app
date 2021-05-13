package com.kymnyth.recipeapp.services;

import com.kymnyth.recipeapp.domain.Recipe;
import com.kymnyth.recipeapp.repositories.RecipeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

public interface RecipeService {

    public List<Recipe> getRecipes();

    public void setRecipes(List<Recipe> recipes);
}
