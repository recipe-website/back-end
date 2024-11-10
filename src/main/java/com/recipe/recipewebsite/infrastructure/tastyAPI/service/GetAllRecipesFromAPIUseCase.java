package com.recipe.recipewebsite.infrastructure.tastyAPI.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.recipe.recipewebsite.infrastructure.tastyAPI.response.dto.RecipeListResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@RequiredArgsConstructor
@Service
public class GetAllRecipesFromAPIUseCase {
    //TODO: Zastąpić plik recepies.json odpowiedzią z API

    public RecipeListResponseDTO getAllRecipesFromAPI() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        BufferedReader reader = new BufferedReader(new FileReader("recipes.json"));
        StringBuilder stringBuilder = new StringBuilder();
        String line;
        String ls = System.lineSeparator();
        while ((line = reader.readLine()) != null) {
            stringBuilder.append(line);
            stringBuilder.append(ls);
        }
// delete the last new line separator
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        reader.close();

        String content = stringBuilder.toString();
        return mapper.readValue(content,RecipeListResponseDTO.class);
    }
}
