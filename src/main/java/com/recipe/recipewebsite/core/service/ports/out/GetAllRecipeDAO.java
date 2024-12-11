package com.recipe.recipewebsite.core.service.ports.out;

import com.recipe.recipewebsite.core.model.RecipeSnapshot;

import java.util.List;

public interface GetAllRecipeDAO {
    List<RecipeSnapshot> getAllRecipe();
    List<RecipeSnapshot> getAllRecipesFromDBWithFilter(List<String> ingredientsFilter);
}
