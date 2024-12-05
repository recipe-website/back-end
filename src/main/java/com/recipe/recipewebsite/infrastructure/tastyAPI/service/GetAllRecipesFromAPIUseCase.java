package com.recipe.recipewebsite.infrastructure.tastyAPI.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.recipe.recipewebsite.infrastructure.tastyAPI.response.dto.RecipeListResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.io.IOException;


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
    return  mapper.readValue(urlConnection.getInputStream(), RecipeListResponseDTO.class);
    }


}
