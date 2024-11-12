package com.recipe.recipewebsite.core.service;

import com.recipe.recipewebsite.core.model.Recipe;
import com.recipe.recipewebsite.core.model.RecipeSnapshot;
import com.recipe.recipewebsite.infrastructure.tastyAPI.service.GetAllRecipesFromAPIUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

@RequiredArgsConstructor
@Service
public class GetAllRecipesUseCase {
    private final GetAllRecipesFromAPIUseCase getAllRecipesFromAPIUseCase;
    public List<RecipeSnapshot> getAllRecipes(){
        try {
            return getAllRecipesFromAPIUseCase.getAllRecipesFromAPI().getResults()
                    .stream()
                    .map(Recipe::fromRecipeListResult)
                    .map(Recipe::toSnapshot)
                    .toList();
        } catch (IOException | URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }
}
