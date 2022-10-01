package it.unical.demacs.progetto.cbeat.cbeat.controller;

import it.unical.demacs.progetto.cbeat.cbeat.HelloApplication;
import it.unical.demacs.progetto.cbeat.cbeat.handler.CartHandler;
import it.unical.demacs.progetto.cbeat.cbeat.handler.DatabaseHandler;
import it.unical.demacs.progetto.cbeat.cbeat.handler.SceneHandler;
import it.unical.demacs.progetto.cbeat.cbeat.model.CartElement;
import it.unical.demacs.progetto.cbeat.cbeat.utility.Settings;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;

import java.io.IOException;
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

    private String itemImageUrl;
    private String itemLabel;
    private String itemId;

    public BorderPane getBorderPane() { return borderPane; }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.infoVBox.prefWidthProperty().bind( this.borderPane.widthProperty() );
        this.infoVBox.prefHeightProperty().bind( this.borderPane.heightProperty() );

        this.ingredientList.prefWidthProperty().bind( this.infoVBox.prefWidthProperty() );
        this.ingredientList.prefHeightProperty().bind( this.infoVBox.prefHeightProperty() );
    }

    public void init( String drinkName ) throws SQLException, IOException {
        ResultSet set = DatabaseHandler.getInstance().queryInformations(drinkName);
        if( set != null ){
            this.itemLabel = set.getString("strDrink").replace("\"", "");
            this.itemImageUrl = set.getString("strDrinkThumb").replace("\"", "");
            this.itemId = set.getString("idDrink").replace("\"", "");


            this.drinkTitle.setText( itemLabel );
            this.drinkImage.setImage( new Image(itemImageUrl) );

            for( int i = 1; i <= Settings.ingredientSize; i++){

                if( set.getString( "strIngredient" + Integer.toString(i) ).compareTo("null") != 0  ){
                    FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("ingredient-button.fxml"));
                    Parent button = (Parent) loader.load();
                    IngredientButton controller = loader.getController();


                    controller.init( set.getString( "strIngredient" + Integer.toString(i) ).replace("\"", "") );

                    this.ingredientList.getChildren().add(button);
                }
            }
        }
        else{
            System.out.println("[ DrinkInfoController ]nessuna informazione [ farne una grafica ]");
        }
    }

    @FXML
    void addToCart(MouseEvent event) {
        CartHandler.getInstance().addElement( this.itemImageUrl, this.itemLabel, this.itemId );
        SceneHandler.getInstance().hideDrinkInfo();
    }

    @FXML
    void goBack(MouseEvent event) {
        SceneHandler.getInstance().hideDrinkInfo();
    }
}