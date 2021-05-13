package com.kymnyth.recipeapp.controllers;

import com.kymnyth.recipeapp.domain.Category;
import com.kymnyth.recipeapp.domain.UnitOfMeasure;
import com.kymnyth.recipeapp.repositories.CategoryRepository;
import com.kymnyth.recipeapp.repositories.RecipeRepository;
import com.kymnyth.recipeapp.repositories.UnitOfMeasureRepository;
import com.kymnyth.recipeapp.services.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
public class RecipeController {
    public final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping({"/recipes", "/recipes/index", "/recipes/index.html"})
    public String getRecipes(Model model){
        model.addAttribute("recipes", recipeService.getRecipes());
        return "index";
    }
}
