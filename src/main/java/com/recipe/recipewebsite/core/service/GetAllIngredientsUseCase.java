package com.recipe.recipewebsite.core.service;

import com.recipe.recipewebsite.core.model.vo.RecipeIngredientVO;
import com.recipe.recipewebsite.core.service.ports.out.GetAllIngredientDAO;
import com.recipe.recipewebsite.infrastructure.dbadapter.mapper.IngredientDatabaseMapper;
import com.recipe.recipewebsite.infrastructure.dbadapter.model.IngredientEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class GetAllIngredientsUseCase {
    private final GetAllIngredientDAO getAllIngredientDAO;

    public List<RecipeIngredientVO> getAllIngredients() {
        List<IngredientEntity> ingredients = getAllIngredientDAO.getAllIngredients();
        return ingredients.stream().map(IngredientDatabaseMapper::fromIngredientEntity).toList();
    }
}
