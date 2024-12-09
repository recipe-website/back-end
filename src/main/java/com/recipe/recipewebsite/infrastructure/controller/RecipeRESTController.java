package com.recipe.recipewebsite.infrastructure.controller;

import com.recipe.recipewebsite.core.model.RecipeSnapshot;
import com.recipe.recipewebsite.core.service.CreateRecipeUseCase;
import com.recipe.recipewebsite.core.service.GetAllRecipesFromDBUseCase;
import com.recipe.recipewebsite.core.service.GetAllRecipesUseCase;
import com.recipe.recipewebsite.core.service.UpdateDatabseUseCase;
import com.recipe.recipewebsite.core.service.dto.RecipeInitialDTO;
import com.recipe.recipewebsite.infrastructure.dbadapter.model.RecipeEntity;
import com.recipe.recipewebsite.infrastructure.tastyAPI.response.dto.RecipeListResponseDTO;
import com.recipe.recipewebsite.infrastructure.tastyAPI.response.dto.RecipeListResult;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/recipe")
@RequiredArgsConstructor
@CrossOrigin("http://localhost:5173")
public class RecipeRESTController {
    private final CreateRecipeUseCase createRecipeUseCase;
    private final GetAllRecipesUseCase getAllRecipesUseCase;
    private final GetAllRecipesFromDBUseCase getAllRecipesFromDBUseCase;
    private final UpdateDatabseUseCase updateDatabseUseCase;
    @PostMapping(value = "/create")
    public ResponseEntity<UUID> createRecipe(@RequestBody RecipeInitialDTO recipeInitialDTO) {
        return new ResponseEntity<>(createRecipeUseCase.createRecipe(recipeInitialDTO), HttpStatus.CREATED);
    }
    @PostMapping(value = "/UpdateDatabase")
    public ResponseEntity<List<UUID>> UpdateDatabase() {
        return new ResponseEntity<>(updateDatabseUseCase.UpdateAllRecipes(), HttpStatus.CREATED);
    }

    @PostMapping(value = "testApi")
    public ResponseEntity<RecipeListResult> testApi(@RequestBody RecipeListResponseDTO recipeListResponseDTO) {
        return new ResponseEntity<>(recipeListResponseDTO.getResults().getFirst(), HttpStatus.OK);
    }

    @GetMapping(value = "allRecipes")
    public ResponseEntity<List<RecipeSnapshot>> getAllRecipes() {
        return new ResponseEntity<>(getAllRecipesUseCase.getAllRecipes(), HttpStatus.OK);
    }
    @GetMapping(value = "allRecipesFromDB")
    public ResponseEntity<List<RecipeSnapshot>> getAllRecipesFromDB() {
        return new ResponseEntity<>(getAllRecipesFromDBUseCase.getAllRecipesFromDB(), HttpStatus.OK);
    }
}