package com.recipe.recipewebsite.core.service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FiltersDTO{
    Integer difficulty;
    Integer minTime;
    Integer maxTime;
    List<String> ingredients;
}
