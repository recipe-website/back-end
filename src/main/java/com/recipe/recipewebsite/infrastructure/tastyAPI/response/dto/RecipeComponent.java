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
public class RecipeComponent {
    RecipeIngredient ingredient;
    List<RecipeMeasurement> measurements;
    String raw_text;
}
