package com.recipe.recipewebsite.infrastructure.dbadapter.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.relational.core.mapping.Table;

import java.util.List;

@Data
@Table(name = "tier")
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class TierEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String displayTier;
    private String tier;
    @OneToMany
    private List<RecipeEntity> recipeList;
}
