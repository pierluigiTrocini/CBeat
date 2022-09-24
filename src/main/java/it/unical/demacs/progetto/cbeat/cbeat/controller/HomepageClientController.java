package it.unical.demacs.progetto.cbeat.cbeat.controller;

import it.unical.demacs.progetto.cbeat.cbeat.HelloApplication;
import it.unical.demacs.progetto.cbeat.cbeat.handler.APIHandler;
import it.unical.demacs.progetto.cbeat.cbeat.handler.DatabaseHandler;
import it.unical.demacs.progetto.cbeat.cbeat.handler.SceneHandler;
import it.unical.demacs.progetto.cbeat.cbeat.handler.StyleHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;


import java.net.URL;

import java.util.ResourceBundle;

public class HomepageClientController implements Initializable {

    @FXML
    private FlowPane itemList;

    @FXML
    private Button searchButton;

    @FXML
    private ScrollPane scrollPane;

    @FXML
    private TextField searchText;

    @FXML
    private StackPane stackPane;


    @Override
    public void initialize(URL location, ResourceBundle resources){

        SceneHandler.getInstance().setHomepageClientStackPane( this.stackPane );
        StyleHandler.getInstance().setHomepageClientStackPane( this.stackPane );

        this.searchText.setPromptText("Es: long island");
        this.itemList.prefWidthProperty().bind( this.scrollPane.widthProperty() );
        this.itemList.prefHeightProperty().bind( this.scrollPane.heightProperty() );

        try {
            APIHandler.getInstance().addCards( this.itemList, DatabaseHandler.getInstance().queryForCards() );
        } catch (Exception e) {
            // TODO  - Grafica per comunicare l'assenza di risultati
            e.printStackTrace();
        }

    }

    @FXML
    void searchByText(MouseEvent event) {
        try {
            if( this.searchText.getText().isEmpty() )
                APIHandler.getInstance().addCards( this.itemList, DatabaseHandler.getInstance().queryForCards() );
            else
                APIHandler.getInstance().addCards(this.itemList, DatabaseHandler.getInstance().querySearch(this.searchText.getText()));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}





















