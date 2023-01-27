package it.unical.demacs.progetto.cbeat.cbeat.controller;

import it.unical.demacs.progetto.cbeat.cbeat.handler.SceneHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.sql.SQLException;

import animatefx.animation.Pulse;



public class ItemCardController {
    @FXML
    private BorderPane borderPane;
    
    @FXML
    private Pane pane;

    @FXML
    private Button addButton;

    @FXML
    private ImageView itemImage;

    @FXML
    private Label itemLabel;

    public void init( String label, String imageSrc ){
        this.itemLabel.setText(label);
        this.itemImage.setImage( new Image(imageSrc)  );

        this.borderPane.prefWidthProperty().bind(this.pane.widthProperty());
        this.borderPane.prefHeightProperty().bind(this.pane.heightProperty());
    }

    @FXML
    void showInfo(MouseEvent event) throws IOException, SQLException {
        SceneHandler.getInstance().showDrinkInfo( ( "\"" + this.itemLabel.getText() + "\"" ) );
    }

    @FXML
    void pulseCard(MouseEvent event) {
        new Pulse(this.pane).play();
    }


}