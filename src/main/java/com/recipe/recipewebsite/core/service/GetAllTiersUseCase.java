package com.recipe.recipewebsite.core.service;

import com.recipe.recipewebsite.core.model.vo.RecipeTierVO;
import com.recipe.recipewebsite.core.service.ports.out.GetAllTiersDAO;
import com.recipe.recipewebsite.infrastructure.dbadapter.mapper.TierDatabaseMapper;
import com.recipe.recipewebsite.infrastructure.dbadapter.model.TierEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class GetAllTiersUseCase {
    private final GetAllTiersDAO getAllTiersDAO;

    public List<RecipeTierVO> getAllTiers() {
        List<TierEntity> tiers = getAllTiersDAO.getAllTiers();
        return tiers.stream().map(TierDatabaseMapper::fromTierEntity).toList();
    }
}
