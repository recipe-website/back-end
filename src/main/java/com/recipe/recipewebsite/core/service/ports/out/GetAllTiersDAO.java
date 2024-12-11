package com.recipe.recipewebsite.core.service.ports.out;

import com.recipe.recipewebsite.infrastructure.dbadapter.model.TierEntity;

import java.util.List;

public interface GetAllTiersDAO {
    List<TierEntity> getAllTiers();
}
