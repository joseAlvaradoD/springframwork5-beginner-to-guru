package jjad.springframework.recipe.controllers;

import jjad.springframework.recipe.model.Recipe;
import jjad.springframework.recipe.services.RecipesService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class IndexControllerTest {

    IndexController indexController;
    @Mock
    RecipesService recipesService;
    @Mock
    Model model;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        indexController = new IndexController(recipesService);
    }

    @Test
    void index() {
        Recipe recipe = new Recipe();
        Set<Recipe> recipes = new HashSet<>();
        recipes.add(recipe);

        when(recipesService.getRecipes()).thenReturn(recipes);
        when(model.getAttribute("recipes")).thenReturn(recipes);
        String returnedValue = indexController.index(model);

        assertEquals(returnedValue, "index");
        assertEquals(((Set<Recipe>)model.getAttribute("recipes")).size(), 1);
        verify(recipesService, times(1)).getRecipes();
        verify(model, times(1)).addAttribute("recipes", recipes);
    }
}