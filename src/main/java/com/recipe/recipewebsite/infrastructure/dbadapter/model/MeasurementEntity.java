package com.recipe.recipewebsite.infrastructure.dbadapter.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "measurement")
@AllArgsConstructor
@NoArgsConstructor
public class MeasurementEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String quantity;
    private String unitName;
    private String unitSystem;
    @ManyToOne
    private IngredientEntity ingredient;
}
