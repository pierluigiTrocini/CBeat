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
        
        new FadeIn(this.borderPane).play();
    }
    
    public void init( Integer idDrink ) throws SQLException{
        ResultSet set = DatabaseHandler.getInstance().staffDrinkInfo("\"" + Integer.toString(idDrink) + "\"" );
        if( set != null ){
            System.out.println(set.getString("strIstructionsIT"));
        }
    }
    
    @FXML
    void goBack(MouseEvent event) {
        StaffSceneHandler.getInstance().hide();
    }
}