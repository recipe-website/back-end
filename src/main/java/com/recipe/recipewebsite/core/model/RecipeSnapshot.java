package com.recipe.recipewebsite.core.model;

import com.recipe.recipewebsite.core.model.vo.RecipeId;
import lombok.Getter;

@Getter
public class RecipeSnapshot {
    private final RecipeId recipeId;
    private final String title;
    private final String description;

    public RecipeSnapshot(Recipe recipe) {
        this.recipeId = recipe.getRecipeId();
        this.title = recipe.getTitle();
        this.description = recipe.getDescription();
    }
}
