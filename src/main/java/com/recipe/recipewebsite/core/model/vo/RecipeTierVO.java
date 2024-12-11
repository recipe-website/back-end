package com.recipe.recipewebsite.core.model.vo;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class RecipeTierVO {
    private final String tier;
    private final String displayTier;
}
