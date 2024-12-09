package com.recipe.recipewebsite.infrastructure.dbadapter.model;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Instruction {
    private  String instruction;
}
