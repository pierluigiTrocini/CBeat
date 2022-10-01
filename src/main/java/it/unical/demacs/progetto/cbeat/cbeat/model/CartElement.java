package it.unical.demacs.progetto.cbeat.cbeat.model;

public class CartElement{
    public String imageUrl;
    public String name;
    public String id;
    public int amount;

    public CartElement(String imageUrl, String name, String id, int amount) {
        this.imageUrl = imageUrl;
        this.name = name;
        this.id = id;
        this.amount = amount;
    }
}
