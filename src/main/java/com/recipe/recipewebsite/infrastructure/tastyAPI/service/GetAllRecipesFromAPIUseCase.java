package com.recipe.recipewebsite.infrastructure.tastyAPI.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.recipe.recipewebsite.infrastructure.tastyAPI.response.dto.RecipeListResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.io.BufferedReader;
import java.io.IOException;


import java.io.*;
import java.net.*;


@RequiredArgsConstructor
@Service
public class GetAllRecipesFromAPIUseCase {
    @Value("${tastyAPi.Key}")
    private String apiKey;
    public RecipeListResponseDTO getAllRecipesFromAPI() throws IOException, URISyntaxException {

    // Set up URL and open connection
    URI uri = new URI("https", "tasty.p.rapidapi.com", "/recipes/list", "from=0&size=20&tags=under_30_minutes", null);
    URL url = uri.toURL();
    HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

    // Set up connection properties
    urlConnection.setRequestMethod("GET");
    urlConnection.setRequestProperty("X-RapidAPI-Key",apiKey );
    urlConnection.setRequestProperty("X-RapidAPI-Host", "tasty.p.rapidapi.com");

    ObjectMapper mapper = new ObjectMapper();

    BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
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
        return  mapper.readValue(content, RecipeListResponseDTO.class);
    }


}
