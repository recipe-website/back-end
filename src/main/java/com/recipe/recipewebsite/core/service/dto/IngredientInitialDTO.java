package com.recipe.recipewebsite.core.service.dto;

import com.recipe.recipewebsite.core.model.vo.RecipeMeasurementVO;

import java.util.List;

public record IngredientInitialDTO(
        String ingredientName,
        List<MeasurementInitialDTO> measurementList,
        String rawText
) {
}
