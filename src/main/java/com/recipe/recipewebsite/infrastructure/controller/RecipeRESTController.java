package com.recipe.recipewebsite.infrastructure.controller;

import com.recipe.recipewebsite.core.service.CreateRecipeUseCase;
import com.recipe.recipewebsite.core.service.dto.RecipeInitialDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController(value = "/recipe")
@RequiredArgsConstructor
public class RecipeRESTController {
    private final CreateRecipeUseCase createRecipeUseCase;

    @PostMapping(value = "/create")

    public ResponseEntity<UUID> createRecipe(@RequestBody RecipeInitialDTO recipeInitialDTO) {
        return new ResponseEntity<>(createRecipeUseCase.createRecipe(recipeInitialDTO), HttpStatus.CREATED);
    }
}