package com.recipe.recipewebsite.core.service;

import com.recipe.recipewebsite.core.model.Recipe;
import com.recipe.recipewebsite.core.model.RecipeSnapshot;
import com.recipe.recipewebsite.core.service.ports.out.CreateRecipeDAO;
import com.recipe.recipewebsite.infrastructure.tastyAPI.service.GetAllRecipesFromAPIUseCase;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.swing.plaf.LabelUI;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class UpdateDatabseUseCase {
    private final GetAllRecipesFromAPIUseCase getAllRecipesFromAPIUseCase;
    private final CreateRecipeDAO createRecipeDAO;
        public List<UUID> UpdateAllRecipes(){
            List<RecipeSnapshot> recipesFromTastyApi = new ArrayList<>();
            List<UUID> recipesAdded = new ArrayList<>();
            try {
                recipesFromTastyApi = getAllRecipesFromAPIUseCase.getAllRecipesFromAPI().getResults()
                        .stream()
                        .map(Recipe::fromRecipeListResult)
                        .map(Recipe::toSnapshot)
                        .toList();
            } catch (IOException | URISyntaxException e) {
                throw new RuntimeException(e);
            }
            for (RecipeSnapshot recipeSnapshot : recipesFromTastyApi){
                createRecipeDAO.createRecipe(recipeSnapshot);
                recipesAdded.add(recipeSnapshot.getRecipeId().recipeId());
            }
            return recipesAdded;
        }
}
