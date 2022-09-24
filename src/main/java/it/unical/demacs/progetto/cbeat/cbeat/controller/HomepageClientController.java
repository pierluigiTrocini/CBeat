package it.unical.demacs.progetto.cbeat.cbeat.controller;

import it.unical.demacs.progetto.cbeat.cbeat.HelloApplication;
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
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
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

        try{
            ResultSet set = DatabaseHandler.getInstance().queryForCards();

            while ( set.next() ){
                FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("item-card.fxml"));
                Parent pane = (Parent) fxmlLoader.load();
                ItemCardController controller = fxmlLoader.getController();
                controller.init( set.getString("strDrink").replace("\"", ""),
                        set.getString("strDrinkThumb").replace("\"", "") );

                this.itemList.getChildren().add(pane);

            }

        }catch (Exception e ){ e.printStackTrace(); }


    }

}





















