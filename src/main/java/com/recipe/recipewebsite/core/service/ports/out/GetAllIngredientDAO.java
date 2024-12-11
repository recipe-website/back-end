package com.recipe.recipewebsite.core.service.ports.out;

import com.recipe.recipewebsite.infrastructure.dbadapter.model.IngredientEntity;

import java.util.List;

public interface GetAllIngredientDAO {
    List<IngredientEntity> getAllIngredients();
}
