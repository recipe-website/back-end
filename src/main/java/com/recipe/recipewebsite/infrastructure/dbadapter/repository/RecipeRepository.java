package com.recipe.recipewebsite.infrastructure.dbadapter.repository;

import com.recipe.recipewebsite.infrastructure.dbadapter.model.RecipeEntity;
import lombok.NonNull;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecipeRepository extends CrudRepository<RecipeEntity,Long> {
    RecipeEntity findFirstByCanonicalId(String canonicalId);

    @NonNull
    List<RecipeEntity> findAll();
}
