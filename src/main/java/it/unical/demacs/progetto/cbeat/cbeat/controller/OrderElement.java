package it.unical.demacs.progetto.cbeat.cbeat.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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

    @FXML
    void orderProcess(MouseEvent event) {

    }
    @FXML
    void showInfos(MouseEvent event) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
