package com.recipe.recipewebsite.core.service;

import com.recipe.recipewebsite.core.model.RecipeSnapshot;
import com.recipe.recipewebsite.core.service.ports.out.GetAllRecipeDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@RequiredArgsConstructor
@Service
public class GetAllRecipesFromDBUseCase {
    private final GetAllRecipeDAO getAllRecipeDAO;

    public List<RecipeSnapshot> getAllRecipesFromDB(){
        return  getAllRecipeDAO.getAllRecipe();
    }
    public List<RecipeSnapshot> getAllRecipesFromDBWithFilter(List<String> ingredientsFilter){

        return getAllRecipeDAO.getAllRecipesFromDBWithFilter(ingredientsFilter);
    }
}
