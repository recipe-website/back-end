package com.recipe.recipewebsite.core.service.ports.out;

import com.recipe.recipewebsite.core.model.RecipeSnapshot;
import com.recipe.recipewebsite.core.service.dto.FiltersDTO;

import java.util.List;

public interface GetAllRecipeDAO {
    List<RecipeSnapshot> getAllRecipe();
    List<RecipeSnapshot> getAllRecipesFromDBWithFilter(FiltersDTO filtersDTO);
}
