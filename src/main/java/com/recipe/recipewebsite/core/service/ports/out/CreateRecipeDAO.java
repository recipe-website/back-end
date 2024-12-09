package com.recipe.recipewebsite.core.service.ports.out;

import com.recipe.recipewebsite.core.model.RecipeSnapshot;

public interface CreateRecipeDAO {
    boolean createRecipe(RecipeSnapshot recipeSnapshot);
}
