package it.unical.demacs.progetto.cbeat.cbeat.controller;

import it.unical.demacs.progetto.cbeat.cbeat.handler.AuthenticationHandler;
import it.unical.demacs.progetto.cbeat.cbeat.handler.SceneHandler;
import it.unical.demacs.progetto.cbeat.cbeat.handler.StyleHandler;
import it.unical.demacs.progetto.cbeat.cbeat.model.Employee;
import it.unical.demacs.progetto.cbeat.cbeat.utility.ActiveEmployee;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
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
    void workerLoginK(KeyEvent event) {
        if( event.getCode() == KeyCode.ENTER ){
            login();
        }
    }

    @FXML
    void workerLogin(MouseEvent event) {
        login();
    }

    private void login(){
        if(!usernameText.getText().isEmpty() &&usernameText!=null && !passwordText.getText().isEmpty()&&passwordText!=null) {
            System.out.println("Username " + usernameText.getText() + "\nPassword " + passwordText.getText());

            if (AuthenticationHandler.getInstance().accountAuth(usernameText.getText(), passwordText.getText())) {
                ActiveEmployee.getInstance().setUsername(usernameText.getText());

                SceneHandler.getInstance().createStaffHomepageScene(usernameText.getText());
            } else {
                StyleHandler.getInstance().highlightAsError(this.usernameText);
                StyleHandler.getInstance().highlightAsError(this.passwordText);
                this.errorMessage.setText("  Username o password errati  ");
            }

        }
        else{

            StyleHandler.getInstance().highlightAsError(this.usernameText);
            StyleHandler.getInstance().highlightAsError(this.passwordText);
            this.errorMessage.setText(" Username e password sono campi obbligatori  ");

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
