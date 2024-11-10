package com.recipe.recipewebsite.core.model.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class RecipeIngredientVO {
    private final String ingredientName;
    private final List<RecipeMeasurementVO> measurementList;
    private final String rawText;
}
