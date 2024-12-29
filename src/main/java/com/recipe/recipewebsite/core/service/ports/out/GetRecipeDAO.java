package com.recipe.recipewebsite.core.service.ports.out;

import com.recipe.recipewebsite.core.model.RecipeSnapshot;

import java.util.UUID;

public interface GetRecipeDAO {
    RecipeSnapshot getRecipe (UUID id);
}
