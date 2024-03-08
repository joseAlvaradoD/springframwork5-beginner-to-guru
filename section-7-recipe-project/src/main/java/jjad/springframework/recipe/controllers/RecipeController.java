package jjad.springframework.recipe.controllers;

import jjad.springframework.recipe.commands.RecipeCommand;
import jjad.springframework.recipe.services.RecipeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
@RequestMapping("/recipe")
public class RecipeController {

    private final RecipeService recipeService;

    public RecipeController(RecipeService recipesService) {
        this.recipeService = recipesService;
    }

    @GetMapping("/{id}/show")
    public String showById(@PathVariable String id, Model model){
        model.addAttribute("recipe", recipeService.findById(Long.parseLong(id)));
        return "recipe/show";
    }

    @GetMapping("/new")
    public String newRecipe(Model model){
        model.addAttribute("recipe", new RecipeCommand());

        return "recipe/recipeform";
    }

    @GetMapping("/{id}/update")
    public String updateRecipe(@PathVariable String id, Model model){
        model.addAttribute("recipe", recipeService.findCommandById(Long.valueOf(id)));
        return  "recipe/recipeform";
    }

    @GetMapping("/{id}/delete")
    public String deleteRecipe(@PathVariable String id){
        log.debug("deleting by id: " + id);
        recipeService.deleteById(Long.valueOf(id));
        return  "redirect:/";
    }

    @PostMapping("")
    public String saveOrUpdate(@ModelAttribute RecipeCommand command){
        RecipeCommand savedRecipe = recipeService.saveRecipeCommand(command);

        return "redirect:/recipe/"+savedRecipe.getId()+"/show";
    }

}
