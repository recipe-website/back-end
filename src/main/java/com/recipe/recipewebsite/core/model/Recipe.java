package com.recipe.recipewebsite.core.model;


import com.recipe.recipewebsite.core.model.vo.*;
import com.recipe.recipewebsite.core.service.dto.RecipeInitialDTO;
import com.recipe.recipewebsite.core.service.dto.RecipeSelectDTO;
import com.recipe.recipewebsite.infrastructure.dbadapter.mapper.IngredientDatabaseMapper;
import com.recipe.recipewebsite.infrastructure.dbadapter.mapper.TierDatabaseMapper;
import com.recipe.recipewebsite.infrastructure.tastyAPI.response.dto.*;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
@Getter
public class Recipe {
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
    private final Integer difficulty;
    private final RecipeTierVO tier;
    private final List<RecipeIngredientVO> componentList;
    private final String thumbnailUrl;
    private final String originalVideoUrl;



    private Recipe(RecipeId recipeId, String title, String description, String canonicalId, List<String> creditList,
                   List<String> instructionList, String language, Integer numberOfServings,
                   RecipeNutritionVO nutrition, Double totalTimeMinutes, Integer difficulty, RecipeTierVO tier,
                   List<RecipeIngredientVO> componentList, String thumbnailUrl, String originalVideoUrl) {
        this.recipeId = recipeId;
        this.title = title;
        this.description = description;
        this.canonicalId = canonicalId;
        this.creditList = creditList;
        this.instructionList = instructionList;
        this.language = language;
        this.numberOfServings = numberOfServings;
        this.nutrition = nutrition;
        this.totalTimeMinutes = totalTimeMinutes;
        this.difficulty = difficulty;
        this.tier = tier;
        this.componentList = componentList;
        this.thumbnailUrl = thumbnailUrl;
        this.originalVideoUrl = originalVideoUrl;
    }

    private Recipe(String title, String description, String canonicalId, List<String> creditList,
                   List<String> instructionList, String language, Integer numberOfServings,
                   RecipeNutritionVO nutrition, Double totalTimeMinutes, Integer difficulty, RecipeTierVO tier,
                   List<RecipeIngredientVO> componentList, String thumbnailUrl, String originalVideoUrl) {

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
        this.difficulty = difficulty;
        this.tier = tier;
        this.componentList = componentList;
        this.thumbnailUrl = thumbnailUrl;
        this.originalVideoUrl = originalVideoUrl;
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
                //sprawdzanie czy tier jest nullem ponieważ APi response zawiera czasmi null total_time_tier i wtedy wyrzuca cały program
                if (recipeListResult.getTotal_time_tier() == null){
                    recipeListResult.setTotal_time_tier(new RecipeTimeTier("0","0"));
                }


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
                calculateDifficulty(componentsList.size(), recipeListResult.getTotal_time_minutes()),
                new RecipeTierVO( recipeListResult.getTotal_time_tier().getTier(),
                recipeListResult.getTotal_time_tier().getDisplay_tier()),
                componentsList,
                recipeListResult.getThumbnail_url(),
                recipeListResult.getOriginal_video_url()
        );
    }


    public static Recipe fromInitialDTO(RecipeInitialDTO recipeInitialDTO){
        return new Recipe(
                recipeInitialDTO.titile(),
                recipeInitialDTO.description(),
                recipeInitialDTO.canonicalId(),
                recipeInitialDTO.creditList(),
                recipeInitialDTO.instructionList(),
                recipeInitialDTO.language(),
                recipeInitialDTO.numberOfServings(),
                new RecipeNutritionVO(
                        recipeInitialDTO.nutrition().calories(),
                        recipeInitialDTO.nutrition().carbohydrates(),
                        recipeInitialDTO.nutrition().fat(),
                        recipeInitialDTO.nutrition().fiber(),
                        recipeInitialDTO.nutrition().protein(),
                        recipeInitialDTO.nutrition().sugar()
                ),
                recipeInitialDTO.totalTimeMinutes(),
                calculateDifficulty(recipeInitialDTO.componentList().size(),
                        recipeInitialDTO.totalTimeMinutes()),
                new RecipeTierVO(recipeInitialDTO.tier(),recipeInitialDTO.displayTier()),
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
                        )).toList(),
                recipeInitialDTO.thumbnailUrl(),
                recipeInitialDTO.originalVideoUrl()

        );
    }

    public static Recipe fromSelectDTO(RecipeSelectDTO recipeSelectDTO){
        return new Recipe(
                new RecipeId(recipeSelectDTO.recipeId()),
                recipeSelectDTO.title(),
                recipeSelectDTO.description(),
                recipeSelectDTO.canonicalId(),
                null, //todo: poprawic
                List.of(recipeSelectDTO.instruction()),
                recipeSelectDTO.language(),
                recipeSelectDTO.numberOfServings(),
                new RecipeNutritionVO(
                        recipeSelectDTO.nutrition().getCalories(),
                        recipeSelectDTO.nutrition().getCarbohydrates(),
                        recipeSelectDTO.nutrition().getFat(),
                        recipeSelectDTO.nutrition().getFiber(),
                        recipeSelectDTO.nutrition().getProtein(),
                        recipeSelectDTO.nutrition().getSugar()
                ),
                recipeSelectDTO.totalTimeMinutes(),
                calculateDifficulty(recipeSelectDTO.componentList().size(), recipeSelectDTO.totalTimeMinutes()),
                TierDatabaseMapper.fromTierEntity(recipeSelectDTO.tier()),
                recipeSelectDTO.componentList().stream().map(IngredientDatabaseMapper::fromIngredientEntity).toList(),
                recipeSelectDTO.thumbnailUrl(),
                recipeSelectDTO.originalVideoUrl()
                );
    }

    public RecipeSnapshot toSnapshot(){
        return new RecipeSnapshot(this);
    }

    private static Integer calculateDifficulty(Integer firstArg, Double secondArg){
        return (int) Math.floor(1.0
                + Math.floor(firstArg/6.0)
                + secondArg/15.0);
    }
}
