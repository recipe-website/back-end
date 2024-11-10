package com.recipe.recipewebsite.infrastructure.tastyAPI.response.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class RecipeListResult {
    String canonical_id;
    List<RecipeAuthor> credits;
    String description;
    List<RecipeInstruction> instructions;
    String language;
    String name;
    Integer num_servings;
    RecipeNutrition nutrition;
    List<RecipeComponent> components;
    Double total_time_minutes;
    RecipeTimeTier total_time_tier;
}
