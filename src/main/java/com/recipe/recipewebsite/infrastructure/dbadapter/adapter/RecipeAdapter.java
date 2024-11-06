package com.recipe.recipewebsite.infrastructure.dbadapter.adapter;

import com.recipe.recipewebsite.core.model.RecipeSnapshot;
import com.recipe.recipewebsite.core.service.ports.out.CreateRecipeDAO;
import com.recipe.recipewebsite.infrastructure.dbadapter.mapper.RecipeDatabaseMapper;
import com.recipe.recipewebsite.infrastructure.dbadapter.model.RecipeEntity;
import com.recipe.recipewebsite.infrastructure.dbadapter.repository.RecipeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RecipeAdapter implements CreateRecipeDAO{

    private final RecipeRepository recipeRepository;

    @Override
    public void createRecipe(RecipeSnapshot recipeSnapshot) {
        RecipeEntity recipeEntity = RecipeDatabaseMapper.fromSnapshot(recipeSnapshot);
        recipeRepository.save(recipeEntity);
    }
}
