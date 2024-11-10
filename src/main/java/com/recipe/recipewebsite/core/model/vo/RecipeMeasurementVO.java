package com.recipe.recipewebsite.core.model.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class RecipeMeasurementVO {
    private final String quantity;
    private final String unitName;
    private final String unitSystem;
}
