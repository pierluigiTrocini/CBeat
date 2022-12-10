package it.unical.demacs.progetto.cbeat.cbeat.controller;

import it.unical.demacs.progetto.cbeat.cbeat.handler.AuthenticationHandler;
import it.unical.demacs.progetto.cbeat.cbeat.handler.SceneHandler;
import it.unical.demacs.progetto.cbeat.cbeat.handler.StyleHandler;
import it.unical.demacs.progetto.cbeat.cbeat.utility.ActiveEmployee;
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
    private TextField usernameText;

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
        System.out.println("Username " + usernameText.getText() + "\nPassword " + passwordText.getText());

        if(AuthenticationHandler.getInstance().accountAuth(usernameText.getText(), passwordText.getText())){
            //TODO - Accesso homepage
            ActiveEmployee.getInstance().setUsername(usernameText.getText());
            SceneHandler.getInstance().createStaffHomepageScene(usernameText.getText());
        }
        else{
            StyleHandler.getInstance().highlightAsError(this.usernameText);
            StyleHandler.getInstance().highlightAsError(this.passwordText);
            this.errorMessage.setText("  Username o password errati  ");
        }

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        usernameText.setPromptText("username");
        passwordText.setPromptText("password");

        this.errorMessage.setStyle("""
            -fx-text-fill: red;
            -fx-background-color: white;
            -fx-background-radius: 25px;
        """);
    }
}
