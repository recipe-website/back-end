package com.recipe.recipewebsite.infrastructure.dbadapter.adapter;

import com.recipe.recipewebsite.core.service.ports.out.GetAllTiersDAO;
import com.recipe.recipewebsite.infrastructure.dbadapter.model.TierEntity;
import com.recipe.recipewebsite.infrastructure.dbadapter.repository.TierRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TierAdapter implements GetAllTiersDAO {
    private final TierRepository tierRepository;

    @Override
    public List<TierEntity> getAllTiers() {
        return tierRepository.findAll();
    }
}
