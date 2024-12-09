package com.recipe.recipewebsite.infrastructure.dbadapter.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "ingredient")
@AllArgsConstructor
@NoArgsConstructor
public class IngredientEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String ingredientName;
    @OneToMany
    private List<MeasurementEntity> measurementEntityList;
    private String rawText;
    @ManyToMany
    private List<RecipeEntity> recipeList;
}
