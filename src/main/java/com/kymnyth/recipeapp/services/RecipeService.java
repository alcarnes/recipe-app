package com.kymnyth.recipeapp.services;

import com.kymnyth.recipeapp.domain.Recipe;
import com.kymnyth.recipeapp.repositories.RecipeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

public interface RecipeService {

    public Set<Recipe> getRecipes();

    public void setRecipes(Set<Recipe> recipes);
}
