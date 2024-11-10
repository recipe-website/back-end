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
public class RecipeListResponseDTO {
    private List<RecipeListResult> results;
}
