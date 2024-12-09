package com.recipe.recipewebsite.core.model.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class RecipeNutritionVO {
    private Integer calories;
    private Integer carbohydrates;
    private Integer fat;
    private Integer fiber;
    private Integer protein;
    private Integer sugar;
}
