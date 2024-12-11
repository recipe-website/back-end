package com.recipe.recipewebsite.infrastructure.dbadapter.repository;

import com.recipe.recipewebsite.infrastructure.dbadapter.model.IngredientEntity;
import lombok.NonNull;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IngredientRepository extends CrudRepository<IngredientEntity,Long> {
    IngredientEntity findFirstByIngredientName(String ingredientName);

    @NonNull
    List<IngredientEntity> findAll();
}
