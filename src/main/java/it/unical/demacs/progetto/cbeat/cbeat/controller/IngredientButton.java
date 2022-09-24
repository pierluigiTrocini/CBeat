package it.unical.demacs.progetto.cbeat.cbeat.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

public class IngredientButton {

    @FXML
    private Button ingredientButton;

    @FXML
    void searchByIngredient(MouseEvent event) {

    }

    public void init( String name ){ this.ingredientButton.setText( name ); }

}
