package com.recipe.recipewebsite.infrastructure.dbadapter.mapper;

import com.recipe.recipewebsite.core.model.RecipeSnapshot;
import com.recipe.recipewebsite.infrastructure.dbadapter.model.CreditEnity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CreditDatabaseMapper {
    public static CreditEnity fromName(String name){
        return new CreditEnity(null,name,new ArrayList<>());
    }

}
