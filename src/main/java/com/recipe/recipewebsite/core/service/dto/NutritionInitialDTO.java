package com.recipe.recipewebsite.core.service.dto;

public record NutritionInitialDTO(
    Integer calories,
    Integer carbohydrates,
    Integer fat,
    Integer fiber,
    Integer protein,
    Integer sugar
) {
}
