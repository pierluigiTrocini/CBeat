package it.unical.demacs.progetto.cbeat.cbeat.controller;

import it.unical.demacs.progetto.cbeat.cbeat.model.Item;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ItemCardController {

    @FXML
    private Button addButton;

    @FXML
    private ImageView itemImage;

    @FXML
    private Label itemLabel;

    public void init(Item item){
        this.itemLabel.setText(item.name());
        this.itemImage.setImage( new Image(getClass().getResourceAsStream(item.imagePath())) );
    }

}