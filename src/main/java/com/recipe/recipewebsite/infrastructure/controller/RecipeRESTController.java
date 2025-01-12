package com.recipe.recipewebsite.infrastructure.controller;

import com.recipe.recipewebsite.core.model.RecipeSnapshot;
import com.recipe.recipewebsite.core.model.vo.RecipeTierVO;
import com.recipe.recipewebsite.core.service.*;
import com.recipe.recipewebsite.core.service.dto.FiltersDTO;
import com.recipe.recipewebsite.core.service.dto.RecipeInitialDTO;
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
@CrossOrigin("{http://localhost:5173, http://localhost:5174}")
public class RecipeRESTController {
    private final CreateRecipeUseCase createRecipeUseCase;
    private final GetAllRecipesUseCase getAllRecipesUseCase;
    private final GetAllRecipesFromDBUseCase getAllRecipesFromDBUseCase;
    private final UpdateDatabseUseCase updateDatabseUseCase;
    private final GetAllIngredientsUseCase getAllIngredientsUseCase;
    private final GetAllTiersUseCase getAllTiersUseCase;
    private final GetRecipeUseCase getRecipeUseCase;

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
    public ResponseEntity<List<RecipeSnapshot>> getAllRecipesFromDBWithFilters(
            @RequestParam(required = false) Integer difficulty,
            @RequestParam(required = false) Integer minTime,
            @RequestParam(required = false) Integer maxTime,
            @RequestParam(required = false) List<String> ingredients
    ) {
        FiltersDTO filtersDTO = new FiltersDTO(difficulty, minTime, maxTime, ingredients);
        System.out.println("FiltersDTO is present:");
        System.out.println("Difficulty: " + filtersDTO.getDifficulty());
        System.out.println("Min Time: " + filtersDTO.getMinTime());
        System.out.println("Max Time: " + filtersDTO.getMaxTime());
        System.out.println("Ingredients: " + filtersDTO.getIngredients());
        if ((filtersDTO.getDifficulty() == null || filtersDTO.getDifficulty() == 0) &&
                (filtersDTO.getMinTime() == null|| filtersDTO.getMinTime() == 0 )&&
                ( filtersDTO.getMaxTime() == null || filtersDTO.getMaxTime() == 0) &&
                (filtersDTO.getIngredients() == null || filtersDTO.getIngredients().isEmpty())) {
            return new ResponseEntity<>(getAllRecipesFromDBUseCase.getAllRecipesFromDB(), HttpStatus.OK);
        }
        return new ResponseEntity<>(getAllRecipesFromDBUseCase.getAllRecipesFromDBWithFilter(filtersDTO), HttpStatus.OK);
    }

    @GetMapping(value = "allIngredients")
    public  ResponseEntity<List<String>> getAllIngredients() {
        return new ResponseEntity<>(getAllIngredientsUseCase.getAllIngredients(),HttpStatus.OK);
    }

    @GetMapping(value = "allTiers")
    public  ResponseEntity<List<RecipeTierVO>> getAllTiers() {
        return new ResponseEntity<>(getAllTiersUseCase.getAllTiers(),HttpStatus.OK);
    }

    @GetMapping(value = "recipebyId/{id}")
    public ResponseEntity<RecipeSnapshot> getRecipe(@PathVariable(value= "id") String id) {
        System.out.println(id);
        UUID uuid = UUID.fromString(id);
        return new ResponseEntity<>(getRecipeUseCase.getRecipe(uuid),HttpStatus.OK);
    }

}