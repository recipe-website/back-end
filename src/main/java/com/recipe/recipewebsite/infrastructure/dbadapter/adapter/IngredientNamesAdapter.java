package com.recipe.recipewebsite.infrastructure.dbadapter.adapter;

import com.recipe.recipewebsite.core.service.ports.out.GetAllIngredientNamesDAO;
import com.recipe.recipewebsite.infrastructure.dbadapter.model.IngredientNameEntity;
import com.recipe.recipewebsite.infrastructure.dbadapter.repository.IngredientNameRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class IngredientNamesAdapter implements GetAllIngredientNamesDAO {
    private final IngredientNameRepository ingredientNameRepository;

    @Override
    public List<String> getAllIngredients() {

        return ingredientNameRepository.findAll().stream()
                .map(IngredientNameEntity::getName).toList();
    }
}
