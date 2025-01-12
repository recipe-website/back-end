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
    @ManyToOne
    private IngredientNameEntity ingredientName;
    @OneToMany
    private List<MeasurementEntity> measurementEntityList;
    private String rawText;
    @ManyToOne()
    private RecipeEntity recipeList;

    public String getIngredientName() {
        return ingredientName.getName();
    }
}
