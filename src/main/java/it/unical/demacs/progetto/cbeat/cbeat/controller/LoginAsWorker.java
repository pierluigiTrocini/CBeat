package it.unical.demacs.progetto.cbeat.cbeat.controller;

import it.unical.demacs.progetto.cbeat.cbeat.handler.AuthenticationHandler;
import it.unical.demacs.progetto.cbeat.cbeat.handler.SceneHandler;
import it.unical.demacs.progetto.cbeat.cbeat.handler.StyleHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
    private Label errorMessage;

    @FXML
    void backToLogin(MouseEvent event) throws IOException {
        SceneHandler.getInstance().showMainLogin();
    }

    @FXML
    void workerLogin(MouseEvent event) {
        System.out.println("Username " + emailText.getText() + "\nPassword " + passwordText.getText());

        if(AuthenticationHandler.getInstance().accountAuth(emailText.getText(), passwordText.getText())){
            //TODO - Accesso homepage
        }
        else{
            StyleHandler.getInstance().highlightAsError(this.emailText);
            StyleHandler.getInstance().highlightAsError(this.passwordText);
            this.errorMessage.setText("  Username o password errati  ");
        }

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        emailText.setPromptText("email");
        passwordText.setPromptText("password");

        this.errorMessage.setStyle("""
            -fx-text-fill: red;
            -fx-background-color: white;
            -fx-background-radius: 25px;
        """);
    }
}
