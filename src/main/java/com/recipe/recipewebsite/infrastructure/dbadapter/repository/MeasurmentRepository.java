package com.recipe.recipewebsite.infrastructure.dbadapter.repository;

import com.recipe.recipewebsite.infrastructure.dbadapter.model.MeasurementEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MeasurmentRepository extends CrudRepository<MeasurementEntity,Long> {
    //    TODO("dokńczyć zwracanie tego dziadowstwa oraz testowanie czy to ścierwo działa ")
//    MeasurementEntity findFirstByQuantityAndAndUnitNameAndUnitSystem(String quantity, String unitName,String unitSystem);
}
