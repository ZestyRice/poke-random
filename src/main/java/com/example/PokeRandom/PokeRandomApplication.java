package com.example.PokeRandom;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@SpringBootApplication
@Controller
public class PokeRandomApplication {

	PokeAPI pokeAPI = new PokeAPI();

	public static void main(String[] args) {
		SpringApplication.run(PokeRandomApplication.class, args);
	}

	@GetMapping("/hello")
	public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
		return String.format("Hello %s!", name);
	}

	@GetMapping("/random")
	public String random(Model model) {

		Pokemon pokemon = pokeAPI.getRandomPokemon();
		model.addAttribute("name", pokemon.getName());
		model.addAttribute("sprite", pokemon.getSpriteURL());

		return "pokemon";
	}

}
