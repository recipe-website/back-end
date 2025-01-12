package com.recipe.recipewebsite.infrastructure.dbadapter.repository;

import com.recipe.recipewebsite.infrastructure.dbadapter.model.IngredientNameEntity;
import lombok.NonNull;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IngredientNameRepository extends CrudRepository<IngredientNameEntity,Long> {
    IngredientNameEntity findFirstByName(String name);
    @NonNull
    List<IngredientNameEntity> findAll();
}
