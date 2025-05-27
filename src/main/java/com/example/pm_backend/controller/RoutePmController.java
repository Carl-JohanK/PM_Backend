package com.example.pm_backend.controller;

import com.example.pm_backend.model.RecipeModel;
import com.example.pm_backend.model.ResponseObject;
import com.example.pm_backend.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/*")
@CrossOrigin(origins = "http://localhost:5173/")
public class RoutePmController {

    @Autowired
    RecipeService recipeService;

    @GetMapping("/recipe")
    public ResponseEntity<List<RecipeModel>> GetRecipes(){
        return ResponseEntity.status(200).body(recipeService.getAllRecipes());
    }

    @GetMapping("/recipe/{id}")
    public ResponseEntity<RecipeModel> GetRecipeId(@PathVariable Long id){
        RecipeModel recipe = recipeService.getRecipeId(id);

        if(recipe == null){
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(recipe);
    }

    @PostMapping("/create/recipe")
    public ResponseEntity<RecipeModel> CreateRecipe(@RequestBody RecipeModel recipe){
        if(recipe.isValid()) {
            return ResponseEntity
                    .status(201)
                    .body(recipeService.saveRecipe(recipe));
        }

        return ResponseEntity.status(400).build();
    }

    @PostMapping("/create/recipe/all")
    public ResponseEntity<RecipeModel[]> CreateAll(@RequestBody RecipeModel[] recipe){
        for (RecipeModel recipeModel : recipe) {
            recipeService.saveRecipe(recipeModel);
        }
            return ResponseEntity.status(201).body(recipe);
    }
}
