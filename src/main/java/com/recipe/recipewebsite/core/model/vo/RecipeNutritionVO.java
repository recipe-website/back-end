package com.recipe.recipewebsite.core.model.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class RecipeNutritionVO {
    private Integer calories;
    private Integer carbohydrates;
    private Integer fat;
    private Integer fiber;
    private Integer protein;
    private Integer sugar;
}
