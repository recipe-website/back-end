package com.recipe.recipewebsite.infrastructure.dbadapter.mapper;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.recipe.recipewebsite.core.model.RecipeSnapshot;
import com.recipe.recipewebsite.core.model.vo.RecipeId;
import com.recipe.recipewebsite.infrastructure.dbadapter.model.NutritionEmbedded;
import com.recipe.recipewebsite.infrastructure.dbadapter.model.RecipeEntity;
import com.recipe.recipewebsite.infrastructure.dbadapter.repository.CreditRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class RecipeDatabaseMapper {
    public static RecipeEntity fromSnapshot(RecipeSnapshot snapshot) {
        //przerabia listę instrukcji na pojedyńczy tekst prawdopodobnie do zmiany będzie
        StringBuilder instructionsBuilder;
        instructionsBuilder = new StringBuilder();
        snapshot.getInstructionList().forEach(instructionsBuilder::append);
        String instructions = instructionsBuilder.toString();
        //===============================================================================
        ObjectMapper mapper = new ObjectMapper();
        NutritionEmbedded nutrition = mapper.convertValue(snapshot.getNutrition(),NutritionEmbedded.class);

        return new RecipeEntity(
                null,
                snapshot.getRecipeId().recipeId() ,
                snapshot.getTitle(),
                snapshot.getDescription(),
                snapshot.getCanonicalId(),
                new ArrayList<>(),
                instructions,
                snapshot.getLanguage(),
                snapshot.getNumberOfServings(),
                nutrition,
                snapshot.getTotalTimeMinutes(),
                null,
                new ArrayList<>()
        );
    }

    public static RecipeSnapshot toSnapshot(RecipeEntity entity){
//        return new RecipeSnapshot(
//                new RecipeId(entity.getRecipeId()),
//                entity.getTitle(),
//                entity.getDescription()
//        );
        return  null;
    }
}
