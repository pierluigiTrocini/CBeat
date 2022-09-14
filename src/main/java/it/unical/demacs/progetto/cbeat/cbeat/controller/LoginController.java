package it.unical.demacs.progetto.cbeat.cbeat.controller;

import it.unical.demacs.progetto.cbeat.cbeat.HelloApplication;
import it.unical.demacs.progetto.cbeat.cbeat.handler.SceneHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    @FXML
    private BorderPane borderPane;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        SceneHandler.getInstance().setLoginBorderPane(this.borderPane);
        try {
            SceneHandler.getInstance().showMainLogin();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
