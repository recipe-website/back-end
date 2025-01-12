package com.recipe.recipewebsite.core.service;

import com.recipe.recipewebsite.core.service.ports.out.GetAllIngredientNamesDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class GetAllIngredientsUseCase {
    private final GetAllIngredientNamesDAO getAllIngredientNamesDAO;

    public List<String> getAllIngredients() {
        return getAllIngredientNamesDAO.getAllIngredients();
    }
}
