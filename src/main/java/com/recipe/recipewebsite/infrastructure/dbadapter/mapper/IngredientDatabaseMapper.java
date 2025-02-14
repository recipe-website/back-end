package com.recipe.recipewebsite.infrastructure.dbadapter.mapper;

import com.recipe.recipewebsite.core.model.vo.RecipeIngredientVO;
import com.recipe.recipewebsite.infrastructure.dbadapter.model.IngredientEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
public class IngredientDatabaseMapper {
    public static IngredientEntity fromRecipeIngredientVO(RecipeIngredientVO recipeIngredientVO){
        return new IngredientEntity(
                null,
                null,
                new ArrayList<>(),
                recipeIngredientVO.getRawText(),
                null
        );
    }
    public static RecipeIngredientVO fromIngredientEntity(IngredientEntity ingredientEntity){
        return new RecipeIngredientVO(
                ingredientEntity.getIngredientName(), //Overrided in IngredientEntity
                ingredientEntity.getMeasurementEntityList().stream()
                        .map(MeasurementDatabaseMapper::fromMeasurementEntity).toList(),
                ingredientEntity.getRawText()
        );
    }
}
