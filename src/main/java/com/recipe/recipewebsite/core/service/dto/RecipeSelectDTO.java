package com.recipe.recipewebsite.core.service.dto;

import com.recipe.recipewebsite.infrastructure.dbadapter.model.CreditEnity;
import com.recipe.recipewebsite.infrastructure.dbadapter.model.IngredientEntity;
import com.recipe.recipewebsite.infrastructure.dbadapter.model.NutritionEmbedded;
import com.recipe.recipewebsite.infrastructure.dbadapter.model.TierEntity;
import java.util.List;
import java.util.UUID;

public record RecipeSelectDTO(
        UUID recipeId,
        String title,
        String description,
        String canonicalId,
        List<CreditEnity> creditEnityList,
        String instruction,
        String language,
        Integer numberOfServings,
        NutritionEmbedded nutrition,
        Double totalTimeMinutes,
        TierEntity tier,
        List<IngredientEntity> componentList
) {
}
