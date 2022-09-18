package it.unical.demacs.progetto.cbeat.cbeat.controller;

import it.unical.demacs.progetto.cbeat.cbeat.HelloApplication;
import it.unical.demacs.progetto.cbeat.cbeat.model.Item;
import it.unical.demacs.progetto.cbeat.cbeat.utility.Settings;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
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

    @Override
    public void initialize(URL location, ResourceBundle resources){
        this.searchText.setPromptText("Es: long island");
        this.itemList.prefWidthProperty().bind( this.scrollPane.widthProperty() );
        this.itemList.prefHeightProperty().bind( this.scrollPane.heightProperty() );

        try {

            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("item-card.fxml"));
            Parent pane = (Parent) fxmlLoader.load();
            ItemCardController controller = fxmlLoader.getController();

            controller.init( "margarita", "image.jpg" );

            this.itemList.getChildren().add(pane);


        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}





















