package com.recipe.recipewebsite.core.model;

import com.recipe.recipewebsite.core.model.vo.RecipeId;
import com.recipe.recipewebsite.core.service.dto.RecipeInitialDTO;
import lombok.Getter;

import java.util.UUID;
@Getter
public class Recipe {
    private RecipeId recipeId;
    private String title;
    private String description;

    private Recipe(String title, String description) {
        this.recipeId = new RecipeId(UUID.randomUUID());
        this.title = title;
        this.description = description;
    }

    public static Recipe fromInitialDTO(RecipeInitialDTO recipeInitialDTO){
        return new Recipe(recipeInitialDTO.name(), recipeInitialDTO.description());
    }

    public RecipeSnapshot toSnapshot(){
        return new RecipeSnapshot(this);
    }
}
