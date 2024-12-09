package com.recipe.recipewebsite.core.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.recipe.recipewebsite.core.model.vo.RecipeId;
import com.recipe.recipewebsite.core.model.vo.RecipeIngredientVO;
import com.recipe.recipewebsite.core.model.vo.RecipeMeasurementVO;
import com.recipe.recipewebsite.core.model.vo.RecipeNutritionVO;
import com.recipe.recipewebsite.core.service.dto.IngredientInitialDTO;
import com.recipe.recipewebsite.core.service.dto.RecipeInitialDTO;
import com.recipe.recipewebsite.infrastructure.tastyAPI.response.dto.*;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
@Getter
public class Recipe {
    private RecipeId recipeId;
    private String title;
    private String description;
    private String canonicalId;
    private List<String> creditList;
    private List<String> instructionList;
    private String language;
    private Integer numberOfServings;
    private RecipeNutritionVO nutrition;
    private Double totalTimeMinutes;
    private String displayTier;
    private String tier;
    private List<RecipeIngredientVO> componentList;



    private Recipe(String title, String description) {
        this.recipeId = new RecipeId(UUID.randomUUID());
        this.title = title;
        this.description = description;
    }

    private Recipe(String title, String description, String canonicalId, List<String> creditList,
                   List<String> instructionList, String language, Integer numberOfServings,
                   RecipeNutritionVO nutrition, Double totalTimeMinutes, String displayTier, String tier,
                   List<RecipeIngredientVO> componentList) {
        this.recipeId =new RecipeId(UUID.randomUUID());//nie jestem pewien czy to tu powinno być
        this.title = title;
        this.description = description;
        this.canonicalId = canonicalId;
        this.creditList = creditList;
        this.instructionList = instructionList;
        this.language = language;
        this.numberOfServings = numberOfServings;
        this.nutrition = nutrition;
        this.totalTimeMinutes = totalTimeMinutes;
        this.displayTier = displayTier;
        this.tier = tier;
        this.componentList = componentList;
    }

    public static Recipe fromRecipeListResult(RecipeListResult recipeListResult) {
        List<String> creditList = recipeListResult.getCredits()
                .stream()
                .map(RecipeAuthor::getName)
                .toList();

        List<String> instructionList = recipeListResult.getInstructions()
                .stream()
                .map(RecipeInstruction::getDisplay_text)
                .toList();


        List<RecipeIngredientVO> componentsList = new ArrayList<>();
        recipeListResult.getSections()
                .forEach(section ->{
                    List<RecipeIngredientVO> components = section.getComponents()
                        .stream()
                        .map(component -> new RecipeIngredientVO(
                                component.getIngredient().getName(),
                                component.getMeasurements()
                                        .stream()
                                        .map(recipeMeasurement -> new RecipeMeasurementVO(
                                                recipeMeasurement.getQuantity(),
                                                recipeMeasurement.getUnit().getName(),
                                                recipeMeasurement.getUnit().getSystem()
                                        )).toList(),
                                component.getRaw_text()
                        ))
                        .toList();
                    componentsList.addAll(components);
                });



        return new Recipe(
                recipeListResult.getName(),
                recipeListResult.getDescription(),
                recipeListResult.getCanonical_id(),
                creditList,
                instructionList,
                recipeListResult.getLanguage(),
                recipeListResult.getNum_servings(),
                new RecipeNutritionVO(
                        recipeListResult.getNutrition().getCalories(),
                        recipeListResult.getNutrition().getCarbohydrates(),
                        recipeListResult.getNutrition().getFat(),
                        recipeListResult.getNutrition().getFiber(),
                        recipeListResult.getNutrition().getProtein(),
                        recipeListResult.getNutrition().getSugar()
                ),
                recipeListResult.getTotal_time_minutes(),
                recipeListResult.getTotal_time_tier().getDisplay_tier(),
                recipeListResult.getTotal_time_tier().getTier(),
                componentsList
        );
    }


    public static Recipe fromInitialDTO(RecipeInitialDTO recipeInitialDTO){
        ObjectMapper mapper = new ObjectMapper();
        return new Recipe(
                recipeInitialDTO.titile(),
                recipeInitialDTO.description(),
                recipeInitialDTO.canonicalId(),
                recipeInitialDTO.creditList(),
                recipeInitialDTO.instructionList(),
                recipeInitialDTO.language(),
                recipeInitialDTO.numberOfServings(),
                mapper.convertValue(recipeInitialDTO.nutrition(),RecipeNutritionVO.class),//TODO("to wywala napraw")
                recipeInitialDTO.totalTimeMinutes(),
                recipeInitialDTO.displayTier(),
                recipeInitialDTO.tier(),
                recipeInitialDTO.componentList()
                        .stream()
                        .map(component -> new RecipeIngredientVO(
                                component.ingredientName(),
                                component.measurementList()
                                        .stream()
                                        .map( measurement -> new RecipeMeasurementVO(
                                                measurement.quantity(),
                                                measurement.unitName(),
                                                measurement.unitSystem()
                                        )).toList(),
                                component.rawText()
                        )).toList()
        );
    }

    public RecipeSnapshot toSnapshot(){
        return new RecipeSnapshot(this);
    }
}
