package com.kymnyth.recipeapp.controllers;

import com.kymnyth.recipeapp.domain.Recipe;
import com.kymnyth.recipeapp.services.RecipeService;
import net.bytebuddy.asm.Advice;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.mock.http.server.reactive.MockServerHttpRequest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class RecipeControllerTest {

    RecipeController recipeController;
    @Mock
    RecipeService recipeService;
    @Mock
    Model model;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        recipeController = new RecipeController(recipeService);
    }

    @Test
    void testMockMVC() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(recipeController).build();
        mockMvc.perform(MockMvcRequestBuilders.get("/recipes"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("index"));
    }

    @Test
    void getRecipes() {
        //given
        HashSet<Recipe> recipeData = new HashSet<>();
        Recipe recipe1 = new Recipe();
        recipe1.setId(123L);
        recipeData.add(recipe1);
        Recipe recipe2 = new Recipe();
        recipe2.setId(345L);
        recipeData.add(recipe2);
        ArgumentCaptor<Set<Recipe>> argCaptor = ArgumentCaptor.forClass(Set.class);
        //when
        when(recipeService.getRecipes()).thenReturn(recipeData);
        String viewName = recipeController.getRecipes(model);

        //then
        assertEquals("index", viewName);
        verify(recipeService, times(1)).getRecipes();
        verify(model, times(1)).addAttribute(eq("recipes"),argCaptor.capture());
        Set<Recipe> setInController = argCaptor.getValue();
        assertEquals(2, setInController.size());
    }
}