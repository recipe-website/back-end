package com.recipe.recipewebsite.infrastructure.dbadapter.adapter;

import com.recipe.recipewebsite.core.service.ports.out.GetAllIngredientDAO;
import com.recipe.recipewebsite.infrastructure.dbadapter.model.IngredientEntity;
import com.recipe.recipewebsite.infrastructure.dbadapter.repository.IngredientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class IngredientAdapter implements GetAllIngredientDAO {
    private final IngredientRepository ingredientRepository;

    @Override
    public List<IngredientEntity> getAllIngredients() {
        return ingredientRepository.findAll();
    }
}
