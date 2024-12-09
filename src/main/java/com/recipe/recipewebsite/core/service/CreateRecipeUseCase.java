package com.recipe.recipewebsite.core.service;

import com.recipe.recipewebsite.core.model.Recipe;
import com.recipe.recipewebsite.core.model.RecipeSnapshot;
import com.recipe.recipewebsite.core.service.dto.RecipeInitialDTO;
import com.recipe.recipewebsite.core.service.ports.out.CreateRecipeDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor

public class CreateRecipeUseCase {
        private final CreateRecipeDAO createRecipeDAO;

        public UUID createRecipe(RecipeInitialDTO recipeInitialDTO) {
            Recipe recipe = Recipe.fromInitialDTO(recipeInitialDTO);
            RecipeSnapshot recipeSnapshot = recipe.toSnapshot();
            if (createRecipeDAO.createRecipe(recipeSnapshot)){
                return recipeSnapshot.getRecipeId().recipeId();
            }

            return null;
        }
}
