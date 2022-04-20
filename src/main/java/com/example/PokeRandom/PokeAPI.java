package com.example.PokeRandom;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.springframework.web.client.RestTemplate;
import org.thymeleaf.util.StringUtils;

public class PokeAPI {

    private static final String POKE_API_URL = "https://pokeapi.co/api/v2/pokemon/";
    private static final int POKEMON_NUMBER = 905;
    private static final String JSON_NAME = "name";
    private static final String JSON_SPRITES = "sprites";
    private static final String JSON_FRONT_SPRITE = "front_default";

    public Pokemon getRandomPokemon() {

        RestTemplate restTemplate = new RestTemplate();
        String url = POKE_API_URL + getRandomNumber(1, POKEMON_NUMBER) + "/";
        String result = restTemplate.getForObject(url, String.class);

        JsonObject jsonObject = new Gson().fromJson(result, JsonObject.class);
        String name = jsonObject.get(JSON_NAME).getAsString();
        JsonObject sprites = jsonObject.get(JSON_SPRITES).getAsJsonObject();
        String sprite = sprites.get(JSON_FRONT_SPRITE).getAsString();

        return new Pokemon(StringUtils.capitalize(name), sprite);
    }

    public int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

}
