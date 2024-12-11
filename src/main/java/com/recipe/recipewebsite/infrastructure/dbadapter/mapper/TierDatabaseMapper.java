package com.recipe.recipewebsite.infrastructure.dbadapter.mapper;

import com.recipe.recipewebsite.core.model.RecipeSnapshot;
import com.recipe.recipewebsite.core.model.vo.RecipeTierVO;
import com.recipe.recipewebsite.infrastructure.dbadapter.model.TierEntity;

import java.util.ArrayList;

public class TierDatabaseMapper {
    public static TierEntity fromRecipeSnapshot(RecipeSnapshot recipeSnapshot){
        return new TierEntity(null, recipeSnapshot.getTier().getDisplayTier(), recipeSnapshot.getTier().getTier(), new ArrayList<>());
    }

    public static RecipeTierVO fromTierEntity(TierEntity tierEntity){
        return new RecipeTierVO(
                tierEntity.getTier(),
                tierEntity.getDisplayTier()
        );
    }
}
