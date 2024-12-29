package com.recipe.recipewebsite.core.service;

import com.recipe.recipewebsite.core.model.RecipeSnapshot;
import com.recipe.recipewebsite.core.service.ports.out.GetRecipeDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@RequiredArgsConstructor
@Service
public class GetRecipeUseCase {
    private final GetRecipeDAO getRecipeDAO;
    public RecipeSnapshot getRecipe(UUID id) {
        return getRecipeDAO.getRecipe(id) ;
    }
}
