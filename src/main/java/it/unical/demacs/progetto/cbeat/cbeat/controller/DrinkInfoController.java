package it.unical.demacs.progetto.cbeat.cbeat.controller;

import it.unical.demacs.progetto.cbeat.cbeat.handler.DatabaseHandler;
import it.unical.demacs.progetto.cbeat.cbeat.handler.SceneHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DrinkInfoController implements Initializable {

    @FXML
    private FlowPane ingredientList;

    @FXML
    private Button backButton;

    @FXML
    private BorderPane borderPane;

    @FXML
    private ImageView drinkImage;

    @FXML
    private Label drinkTitle;

    @FXML
    private VBox infoVBox;

    @FXML
    private Button purchaseButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.infoVBox.prefWidthProperty().bind( this.borderPane.widthProperty() );
        this.infoVBox.prefHeightProperty().bind( this.borderPane.heightProperty() );

        this.ingredientList.prefWidthProperty().bind( this.infoVBox.prefWidthProperty() );
        this.ingredientList.prefHeightProperty().bind( this.infoVBox.prefHeightProperty() );
    }

    public void init( String drinkName ) throws SQLException {
        ResultSet set = DatabaseHandler.getInstance().queryInformations(drinkName);
        if( set != null ){

            this.drinkTitle.setText( set.getString("strDrink").replace("\"", "") );
            this.drinkImage.setImage( new Image( set.getString("strDrinkThumb").replace("\"", "") ));

            //TODO - lista ingredienti

        }
        else{
            System.out.println("[ DrinkInfoController ]nessuna informazione [ farne una grafica ]");
        }



    }

    @FXML
    void addToCart(MouseEvent event) {

    }

    @FXML
    void goBack(MouseEvent event) {
        SceneHandler.getInstance().hideDrinkInfo();
    }
}