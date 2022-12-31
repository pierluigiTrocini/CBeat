package it.unical.demacs.progetto.cbeat.cbeat.controller;

import it.unical.demacs.progetto.cbeat.cbeat.handler.APIHandler;
import it.unical.demacs.progetto.cbeat.cbeat.handler.DatabaseHandler;
import it.unical.demacs.progetto.cbeat.cbeat.handler.SceneHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

import java.sql.SQLException;

public class IngredientButton {

    @FXML
    private Button ingredientButton;

    @FXML
    void searchByIngredient(MouseEvent event) throws SQLException {
        SceneHandler.getInstance().hide();
        APIHandler.getInstance().addCards(DatabaseHandler.getInstance().searchByIngredient( this.ingredientButton.getText() ));
    }

    public void init( String name ){ this.ingredientButton.setText( name ); }

}
