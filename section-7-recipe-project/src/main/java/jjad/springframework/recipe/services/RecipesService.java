package jjad.springframework.recipe.services;

import jjad.springframework.recipe.model.Recipe;

import java.util.Set;

public interface RecipesService {
    Set<Recipe> getRecipes();
}
