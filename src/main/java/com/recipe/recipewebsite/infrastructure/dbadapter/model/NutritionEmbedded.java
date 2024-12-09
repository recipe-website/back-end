package com.recipe.recipewebsite.infrastructure.dbadapter.model;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
//searchable by List<RecipeEnity> findNutritionEmbeddedfieldName(@Param("FieldName" ) String value);
@Data
@Embeddable
@Table(name = "nutrition")
@AllArgsConstructor
@NoArgsConstructor
public class NutritionEmbedded {
    Integer calories;
    Integer carbohydrates;
    Integer fat;
    Integer fiber;
    Integer protein;
    Integer sugar;
}
