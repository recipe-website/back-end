package com.recipe.recipewebsite.infrastructure.dbadapter.repository;

import com.recipe.recipewebsite.infrastructure.dbadapter.model.TierEntity;
import lombok.NonNull;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TierRepository extends CrudRepository<TierEntity,Long> {
     TierEntity findFirstByTier(String tier);

     @NonNull
     List<TierEntity> findAll();
}
