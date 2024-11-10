package com.recipe.recipewebsite.infrastructure.tastyAPI.response.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class RecipeNutrition {
    Integer calories;
    Integer carbohydrates;
    Integer fat;
    Integer fiber;
    Integer protein;
    Integer sugar;
}
