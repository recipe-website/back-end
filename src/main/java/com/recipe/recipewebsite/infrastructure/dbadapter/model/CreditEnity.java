package com.recipe.recipewebsite.infrastructure.dbadapter.model;

import jakarta.persistence.*;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@Table(name ="credit")
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class CreditEnity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;
    private String name;
    @ManyToMany
    private List<RecipeEntity> recipeList;
}
