package com.recipe.recipewebsite.infrastructure.dbadapter.adapter;

import com.recipe.recipewebsite.core.model.Recipe;
import com.recipe.recipewebsite.core.model.RecipeSnapshot;
import com.recipe.recipewebsite.core.model.vo.RecipeIngredientVO;
import com.recipe.recipewebsite.core.model.vo.RecipeMeasurementVO;
import com.recipe.recipewebsite.core.service.dto.FiltersDTO;
import com.recipe.recipewebsite.core.service.ports.out.CreateRecipeDAO;
import com.recipe.recipewebsite.core.service.ports.out.GetAllRecipeDAO;
import com.recipe.recipewebsite.core.service.ports.out.GetRecipeDAO;
import com.recipe.recipewebsite.infrastructure.dbadapter.mapper.*;
import com.recipe.recipewebsite.infrastructure.dbadapter.model.*;
import com.recipe.recipewebsite.infrastructure.dbadapter.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RecipeAdapter implements CreateRecipeDAO , GetAllRecipeDAO, GetRecipeDAO {

    private final RecipeRepository recipeRepository;
    private final CreditRepository creditRepository;
    private final IngredientRepository ingredientRepository;
    private final MeasurmentRepository measurmentRepository;
    private final TierRepository tierRepository;
    private final IngredientNameRepository ingredientNameRepository;
    @Override
    public boolean createRecipe(RecipeSnapshot recipeSnapshot) {

        RecipeEntity  recipeEntity  = recipeRepository.findFirstByCanonicalId(recipeSnapshot.getCanonicalId());
        if (recipeEntity != null){
            System.out.println("recipe with " +recipeSnapshot.getCanonicalId() + " already exists in the database");
            return false;
        }
        recipeEntity = RecipeDatabaseMapper.fromSnapshot(recipeSnapshot);
        recipeRepository.save(recipeEntity);
        //optional hibernete pobiera optional isEmpty isNotEmpty jest pusty optional
        //prawdopodnie da się to zrobić prościej ↓
        for(String name : recipeSnapshot.getCreditList()){
            CreditEnity creditEnity = creditRepository.findFirstByName(name);
            if (creditEnity == null){
                creditEnity = CreditDatabaseMapper.fromName(name);
            }
            creditRepository.save(creditEnity);
            recipeEntity.getCreditEnityList().add(creditEnity);
            creditEnity.getRecipeList().add(recipeEntity);
        }
        TierEntity tierEntity = tierRepository.findFirstByTier(recipeSnapshot.getTier().getTier());
        if (tierEntity == null){
            tierEntity = TierDatabaseMapper.fromRecipeSnapshot(recipeSnapshot);
        }
        tierRepository.save(tierEntity);
        recipeEntity.setTier(tierEntity);
        tierEntity.getRecipeList().add(recipeEntity);

        for (RecipeIngredientVO ingredientVo : recipeSnapshot.getComponentList()){
            IngredientEntity ingredientEntity = IngredientDatabaseMapper.fromRecipeIngredientVO(ingredientVo);
            ingredientRepository.save(ingredientEntity);
            IngredientNameEntity ingredientNameEntity = ingredientNameRepository.findFirstByName(ingredientVo.getIngredientName());
            if (ingredientNameEntity == null){
                ingredientNameEntity = new IngredientNameEntity(null,ingredientVo.getIngredientName(),new ArrayList<>());
            }
            ingredientNameRepository.save(ingredientNameEntity);
            ingredientEntity.setIngredientName(ingredientNameEntity);
            ingredientNameEntity.getIngredients().add(ingredientEntity);
            recipeEntity.getComponentList().add(ingredientEntity);
            ingredientEntity.setRecipeList(recipeEntity);
            for (RecipeMeasurementVO measurementV0: ingredientVo.getMeasurementList()){
                MeasurementEntity measurementEntity = MeasurementDatabaseMapper.fromRecipeMeasurementVo(measurementV0);
                measurmentRepository.save(measurementEntity);
                //=======================================
                measurementEntity.setIngredient(ingredientEntity);
                ingredientEntity.getMeasurementEntityList().add(measurementEntity);
            }
        }

        //↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑
        return true;
    }

    @Override
    public List<RecipeSnapshot> getAllRecipe() {
        List<RecipeEntity> recipes = recipeRepository.findAll();
        return recipes.stream()
                .map(RecipeDatabaseMapper::fromEntity)
                .map(Recipe::fromSelectDTO)
                .map(Recipe::toSnapshot)
                .toList();
    }
    @Override
    public RecipeSnapshot getRecipe(UUID id) {
        RecipeEntity recipe = recipeRepository.findFirstByRecipeId(id);
        return new RecipeSnapshot(
                Recipe.fromSelectDTO(
                        RecipeDatabaseMapper.fromEntity(recipe)
                )
        );


    }

    @Override
    public List<RecipeSnapshot> getAllRecipesFromDBWithFilter(FiltersDTO filtersDTO) {
        System.out.println(filtersDTO);
        List<RecipeEntity> recipeEntities = recipeRepository.findAll();
        List<RecipeEntity> recipeEntitiesresult = new ArrayList<>();
        if (filtersDTO.getIngredients() != null){

            for (RecipeEntity recipeEntity : recipeEntities){
                for(IngredientEntity ingredientEntity: recipeEntity.getComponentList()){
                    if (filtersDTO.getIngredients().contains(ingredientEntity.getIngredientName())){//getIngredientName() ovverided in IngredientEntity
                        recipeEntitiesresult.add(recipeEntity);
                        break;
                    }
                }
            }
        } else{//temp
            recipeEntitiesresult = recipeEntities;
        }
        List<Recipe> recipeList = recipeEntitiesresult.stream()
                .map(RecipeDatabaseMapper::fromEntity)
                .map(Recipe::fromSelectDTO).toList();
        if(Objects.nonNull(filtersDTO.getDifficulty())){
            recipeList = recipeList
                    .stream()
                    .filter(recipe -> Objects.equals(filtersDTO.getDifficulty(), recipe.getDifficulty()))
                    .toList();
        }
        if(Objects.nonNull(filtersDTO.getMinTime())){
            recipeList = recipeList
                    .stream()
                    .filter(recipe -> filtersDTO.getMinTime() < recipe.getTotalTimeMinutes())
                    .toList();
        }
        if(Objects.nonNull(filtersDTO.getMaxTime())){
            recipeList = recipeList
                    .stream()
                    .filter(recipe -> filtersDTO.getMaxTime() > recipe.getTotalTimeMinutes())
                    .toList();
        }
        return recipeList
                .stream()
                .map(Recipe::toSnapshot)
                .toList();
    }
}
