package jjad.springframework.recipe.controllers;

import jjad.springframework.recipe.model.Category;
import jjad.springframework.recipe.model.UnitOfMeasure;
import jjad.springframework.recipe.repositories.CategoryRepository;
import jjad.springframework.recipe.repositories.RecipeRepository;
import jjad.springframework.recipe.repositories.UnitOfMeasureRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
public class IndexController {

    private RecipeRepository recipeRepository;

    public IndexController(RecipeRepository recipeRepository){
        this.recipeRepository = recipeRepository;
    }

    @RequestMapping({"", "/", "/index"})
    public String index(Model model){
        model.addAttribute("recipes", recipeRepository.findAll());

        return "index";
    }
}
