package com.recipe.recipewebsite.infrastructure.dbadapter.mapper;

import com.recipe.recipewebsite.core.model.vo.RecipeMeasurementVO;
import com.recipe.recipewebsite.infrastructure.dbadapter.model.MeasurementEntity;

public class MeasurementDatabaseMapper {
    public static MeasurementEntity fromRecipeMeasurementVo(RecipeMeasurementVO measurementVO){
        return new MeasurementEntity(
                null,
                measurementVO.getQuantity(),
                measurementVO.getUnitName(),
                measurementVO.getUnitSystem(),
                null
        );
    }
}
