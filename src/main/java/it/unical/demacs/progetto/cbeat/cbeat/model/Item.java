package it.unical.demacs.progetto.cbeat.cbeat.model;

public class Item {
    private String name;
    private String imagePath;

    public String name() { return name; }

    public String imagePath() { return imagePath; }

    public Item(String name, String imagePath) {
        this.name = name;
        this.imagePath = imagePath;
    }
}
