package com.recipe.recipewebsite.infrastructure.tastyAPI.response.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class RecipeListResult {
    String canonical_id;
    List<RecipeAuthor> credits;
    String description;
    List<RecipeInstruction> instructions;
    String language;
    String name;
    Integer num_servings;
    RecipeNutrition nutrition;
    List<RecipeSection> sections;
    Double total_time_minutes;
    RecipeTimeTier total_time_tier;
    String thumbnail_url;
    String original_video_url;

}
