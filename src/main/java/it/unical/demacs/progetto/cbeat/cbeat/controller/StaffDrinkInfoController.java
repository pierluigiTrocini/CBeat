package it.unical.demacs.progetto.cbeat.cbeat.controller;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import animatefx.animation.FadeIn;
import it.unical.demacs.progetto.cbeat.cbeat.handler.DatabaseHandler;
import it.unical.demacs.progetto.cbeat.cbeat.handler.StaffSceneHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

public class StaffDrinkInfoController implements Initializable {

    @FXML
    private Button backButton;

    @FXML
    private BorderPane borderPane;

    @FXML
    private ImageView drinkImage;

    @FXML
    private HBox hbox;

    @FXML
    private Text ingredientText;

    @FXML
    private Text instructionText;

    @FXML
    private BorderPane textBorderPane;

    
    public BorderPane getBorderPane(){ return this.borderPane; }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        this.textBorderPane.prefWidthProperty().bind( this.hbox.widthProperty() );
        this.textBorderPane.prefHeightProperty().bind( this.hbox.widthProperty() ); 
        
        this.instructionText.setWrappingWidth(800);
        this.ingredientText.setWrappingWidth(800);
        
        new FadeIn(this.borderPane).play();
    }
    
    public void init( String idDrink ) throws SQLException{
        ResultSet set = DatabaseHandler.getInstance().staffDrinkInfo("\"" + idDrink + "\"" );
        if( set != null ){
            //immagini
            this.drinkImage.setImage( new Image(set.getString("strDrinkThumb").replace("\"", "")) );

            //istruzioni
            this.instructionText.setText(set.getString("strInstructionsIT")
                            .replace("\\r","")
                            .replace("\\n", " ")
                            .replace("\"", ""));

            //ingredienti
            String ingredient = "";
            for( int i = 1; i <= 15; i++ ){
                String ing = set.getString("strIngredient" + Integer.toString(i)).replace("\"","");
                String mes = set.getString("strMeasure" + Integer.toString(i)).replace("\"", "");

                if( ing.compareTo("null") != 0 )
                    ingredient += ing + "   " + "( " + mes + " )  ";
            }
            this.ingredientText.setText(ingredient);

        }
    }
    
    @FXML
    void goBack(MouseEvent event) {
        StaffSceneHandler.getInstance().hide();
    }
}