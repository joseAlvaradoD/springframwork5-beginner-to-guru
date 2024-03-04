package jjad.springframework.recipe.controllers;

import jjad.springframework.recipe.services.RecipesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
public class IndexController {

    private RecipesService recipesService;

    public IndexController(RecipesService recipesService){
        this.recipesService = recipesService;
    }

    @RequestMapping({"", "/", "/index"})
    public String index(Model model){
        log.debug("Executing index");
        model.addAttribute("recipes", recipesService.getRecipes());
        log.debug("Added recipes to model object");
        return "index";
    }
}
