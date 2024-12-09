package com.recipe.recipewebsite.core.model;

import com.recipe.recipewebsite.core.model.vo.RecipeId;
import com.recipe.recipewebsite.core.model.vo.RecipeIngredientVO;
import com.recipe.recipewebsite.core.model.vo.RecipeNutritionVO;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
@Getter
public class RecipeSnapshot {
    private final RecipeId recipeId;
    private final String title;
    private final String description;
    private final String canonicalId;
    private final List<String> creditList;
    private final List<String> instructionList;
    private final String language;
    private final Integer numberOfServings;
    private final RecipeNutritionVO nutrition;
    private final Double totalTimeMinutes;
    private final String displayTier;
    private final String tier;
    private final List<RecipeIngredientVO> componentList;

    public RecipeSnapshot(Recipe recipe) {
        this.recipeId = recipe.getRecipeId();
        this.title = recipe.getTitle();
        this.description = recipe.getDescription();
        this.canonicalId = recipe.getCanonicalId();
        this.creditList = recipe.getCreditList();
        this.instructionList = recipe.getInstructionList();
        this.language = recipe.getLanguage();
        this.numberOfServings = recipe.getNumberOfServings();
        this.nutrition = recipe.getNutrition();
        this.totalTimeMinutes = recipe.getTotalTimeMinutes();
        this.displayTier = recipe.getDisplayTier();
        this.tier = recipe.getTier();
        this.componentList = recipe.getComponentList();
    }
//    public RecipeSnapshot(RecipeId recipeId,String title,String description) {
//        this.recipeId = recipeId;
//        this.title = title;
//        this.description = description;
//        this.canonicalId = "0";
//        this.creditList = new ArrayList<>();
//        this.instructionList = new ArrayList<>();
//        this.language = "us";
//        this.numberOfServings = 2;
//        this.nutrition = new RecipeNutritionVO(0,0,0,0,0,0);
//        this.totalTimeMinutes = 11.0;
//        this.displayTier = "tier";
//        this.tier = "s";
//        this.componentList = new ArrayList<>();
//    }

}
