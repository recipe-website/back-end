package com.recipe.recipewebsite.core.model;

import com.recipe.recipewebsite.core.model.vo.RecipeId;
import com.recipe.recipewebsite.core.model.vo.RecipeIngredientVO;
import com.recipe.recipewebsite.core.model.vo.RecipeNutritionVO;
import com.recipe.recipewebsite.core.model.vo.RecipeTierVO;
import lombok.Getter;
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
    private final RecipeTierVO tier;
    private final List<RecipeIngredientVO> componentList;
    private final String thumbnailUrl;
    private final String originalVideoUrl;

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
        this.tier = recipe.getTier();
        this.componentList = recipe.getComponentList();
        this.thumbnailUrl = recipe.getThumbnailUrl();
        this.originalVideoUrl = recipe.getOriginalVideoUrl();
    }
}
