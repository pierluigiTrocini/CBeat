package it.unical.demacs.progetto.cbeat.cbeat.controller;

import it.unical.demacs.progetto.cbeat.cbeat.handler.SceneHandler;
import it.unical.demacs.progetto.cbeat.cbeat.handler.StyleHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;

import java.net.URL;
import java.util.ResourceBundle;

public class CartController implements Initializable {

    @FXML
    private BorderPane borderPane;

    @FXML
    private Button purchaseBtn;

    @FXML
    private Button exitButton;

    public BorderPane getBorderPane() { return borderPane; }

    @FXML
    void purchase(MouseEvent event) {

    }

    @FXML
    void exit(MouseEvent event) {
        SceneHandler.getInstance().hideCart();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.exitButton.setGraphic(StyleHandler.getInstance().getIcon("mdi2c-close", 10));
    }
}
