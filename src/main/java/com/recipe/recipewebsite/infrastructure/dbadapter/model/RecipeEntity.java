package com.recipe.recipewebsite.infrastructure.dbadapter.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.relational.core.mapping.Table;

import java.util.List;
import java.util.UUID;

@Data
@Table(name = "recipe")
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class RecipeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private UUID recipeId;
    private String title;
    private String description;
    private String canonicalId;
    @ManyToMany
    private List<CreditEnity> creditEnityList;

    private String instruction;
    private String language;
    private Integer numberOfServings;
    @Embedded
    private NutritionEmbedded nutrition;
    private Double totalTimeMinutes;
    @ManyToOne
    private TierEntity tier;
    @OneToMany
    private List<IngredientEntity> componentList;
}
