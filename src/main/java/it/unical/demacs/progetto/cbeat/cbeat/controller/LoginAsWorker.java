package it.unical.demacs.progetto.cbeat.cbeat.controller;

import it.unical.demacs.progetto.cbeat.cbeat.handler.SceneHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginAsWorker implements Initializable {

    @FXML
    private TextField emailText;

    @FXML
    private Button goBackBtn;

    @FXML
    private Button loginBtn;

    @FXML
    private PasswordField passwordText;

    @FXML
    void backToLogin(MouseEvent event) throws IOException {
        SceneHandler.getInstance().showMainLogin();
    }

    @FXML
    void workerLogin(MouseEvent event) {
        System.out.println("Username " + emailText.getText() + "\nPassword " + passwordText.getText());
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
