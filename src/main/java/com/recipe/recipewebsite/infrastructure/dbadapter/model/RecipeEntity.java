package com.recipe.recipewebsite.infrastructure.dbadapter.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.relational.core.mapping.Table;

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

}
