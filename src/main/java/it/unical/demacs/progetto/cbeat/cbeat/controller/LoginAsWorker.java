package it.unical.demacs.progetto.cbeat.cbeat.controller;

import it.unical.demacs.progetto.cbeat.cbeat.handler.AuthenticationHandler;
import it.unical.demacs.progetto.cbeat.cbeat.handler.SceneHandler;
import it.unical.demacs.progetto.cbeat.cbeat.handler.StyleHandler;
import it.unical.demacs.progetto.cbeat.cbeat.model.Employee;
import it.unical.demacs.progetto.cbeat.cbeat.utility.ActiveEmployee;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.prefs.Preferences;

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
    private CheckBox RememberMe;

    Preferences Preferences;

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

            if (AuthenticationHandler.getInstance().accountAuth(usernameText.getText(), passwordText.getText())) {
                RefreshPreferences();
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

        Preferences = Preferences.userNodeForPackage(LoginAsWorker.class);

        if(!CheckPreferences()){
            usernameText.requestFocus();

        }



        this.errorMessage.setStyle("""
            -fx-text-fill: red;
            -fx-background-color: white;
            -fx-background-radius: 25px;
        """);
    }

    private boolean CheckPreferences(){
        if (Preferences != null) {
            if (Preferences.get("username", null)!=null && !Preferences.get("username", null).isEmpty() && Preferences!=null) {
                usernameText.setText(Preferences.get("username",null));
                passwordText.setText(Preferences.get("password",null));
                return true;
            }
        }
        return false;
    }


    private void RefreshPreferences(){
        if (RememberMe.isSelected()) {
            Preferences.put("username", usernameText.getText());
            Preferences.put("password", passwordText.getText());

        } else {
            Preferences.put("username", "");
            Preferences.put("password", "");
        }

    }
}
