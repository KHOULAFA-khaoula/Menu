package com.example.menu.model;

public class Category {
    int id,image,music;
    String nom_category;

    public Category(int id, String nom_category, int image, int music) {
        this.id = id;
        this.nom_category = nom_category;
        this.image = image;
        this.music = music;

    }

    public Category() {
    }

    public int getId() {
        return id;
    }

    public String getNom_category() {
        return nom_category;
    }

    public int getImage() {
        return image;
    }

    public int getMusic() { return music; }
}