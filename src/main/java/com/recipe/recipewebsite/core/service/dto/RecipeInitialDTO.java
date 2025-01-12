package com.recipe.recipewebsite.core.service.dto;

import java.util.List;
public record RecipeInitialDTO(
        String titile,
        String description,
        String canonicalId,
        List<String> creditList,
        List<String> instructionList,
        String language,
        Integer numberOfServings,
        NutritionInitialDTO nutrition,
        Double totalTimeMinutes,
        String displayTier,
        String tier,
        List<IngredientInitialDTO> componentList,// zamienic
        String thumbnailUrl,
        String originalVideoUrl
) { }
