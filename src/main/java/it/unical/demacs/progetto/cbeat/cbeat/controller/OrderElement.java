package it.unical.demacs.progetto.cbeat.cbeat.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;

import java.net.URL;
import java.util.ResourceBundle;

public class OrderElement implements Initializable {

    @FXML
    private HBox hBox;

    @FXML
    private Label orderAmount;

    @FXML
    private HBox orderBox;

    @FXML
    private ImageView orderImg;

    @FXML
    private Label orderLabel;

    @FXML
    private Label orderTable;

    @FXML
    private Button processBtn;

    public HBox gethBox() { return hBox; }

    @FXML
    void orderProcess(MouseEvent event) {

    }
    @FXML
    void showInfos(MouseEvent event) {

    }

    public void init( String imgUrl, String drinkName, int drinkAmount, int drinkTable ){
        this.orderImg.setImage( new Image(imgUrl) );
        this.orderLabel.setText( drinkName );
        this.orderAmount.setText( Integer.toString(drinkAmount) );
        this.orderTable.setText( Integer.toString(drinkTable) );
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
