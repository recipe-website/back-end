package com.recipe.recipewebsite.infrastructure.dbadapter.mapper;

import com.recipe.recipewebsite.core.model.RecipeSnapshot;
import com.recipe.recipewebsite.infrastructure.dbadapter.model.RecipeEntity;

public class RecipeDatabaseMapper {
    public static RecipeEntity fromSnapshot(RecipeSnapshot snapshot) {
        return new RecipeEntity(null, snapshot.getRecipeId().recipeId() , snapshot.getTitle(), snapshot.getDescription());
    }
}
