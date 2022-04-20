package com.example.PokeRandom;

public class Pokemon {

    private String name;
    private String spriteURL;

    public Pokemon(String name, String spriteURL) {
        this.name = name;
        this.spriteURL = spriteURL;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpriteURL() {
        return spriteURL;
    }

    public void setSpriteURL(String spriteURL) {
        this.spriteURL = spriteURL;
    }
}
