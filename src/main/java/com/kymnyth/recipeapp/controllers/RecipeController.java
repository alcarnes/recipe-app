package com.kymnyth.recipeapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RecipeController {

    @RequestMapping({"/recipes", "/recipes/index", "/recipes/index.html"})
    public String getRecipes(Model model){
        return "index";
    }
}
