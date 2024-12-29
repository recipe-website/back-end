package com.recipe.recipewebsite.infrastructure.dbadapter.repository;

import com.recipe.recipewebsite.infrastructure.dbadapter.model.RecipeEntity;
import lombok.NonNull;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface RecipeRepository extends CrudRepository<RecipeEntity,Long> {
    RecipeEntity findFirstByCanonicalId(String canonicalId);
    RecipeEntity findFirstByRecipeId(UUID id);
    @NonNull
    List<RecipeEntity> findAll();
}
