package jjad.springframework.recipe.services;

import jjad.springframework.recipe.commands.RecipeCommand;
import jjad.springframework.recipe.model.Recipe;

import java.util.Set;

public interface RecipeService {
    Set<Recipe> getRecipes();
    Recipe findById(Long id);
    RecipeCommand saveRecipeCommand(RecipeCommand command);
}
