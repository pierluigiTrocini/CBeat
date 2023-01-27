package it.unical.demacs.progetto.cbeat.cbeat.controller;

import it.unical.demacs.progetto.cbeat.cbeat.handler.SceneHandler;
import it.unical.demacs.progetto.cbeat.cbeat.handler.StyleHandler;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginAsClient implements Initializable {
    @FXML
    private Button goBackBtn;

    @FXML
    private Button loginBtn;

    @FXML
    private TextField tableTextArea;

    @FXML
    private Label welcomeLabel;

    @FXML
    private Label errorMessage;

    
    
    @FXML
    void backToLogin(MouseEvent event) throws IOException {
        SceneHandler.getInstance().showMainLogin();
    }
    
    @FXML
    void loginAsClientK(KeyEvent event) {
        if( event.getCode() == KeyCode.ENTER ){
            login();
        }
    }


    @FXML
    void loginAsClient(MouseEvent event) {
        login();
    }

    private void login(){
        if( this.tableTextArea.getText().isEmpty() ){
            this.errorMessage.setVisible(true);
            this.tableTextArea.setStyle(""" 
                -fx-border-color: red;
                -fx-background-color: white;""");
        }
        else {
            SceneHandler.getInstance().createClientHomepageScene(this.tableTextArea.getText());
        }
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.errorMessage.setVisible(false);

        this.goBackBtn.setGraphic(StyleHandler.getInstance().getIcon("mdi2k-keyboard-backspace", 25));

        this.tableTextArea.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if( !oldValue.equals(newValue) ){ errorMessage.setVisible(false); }
            }
        });

        this.tableTextArea.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("\\d"))
                    tableTextArea.setText(newValue.replaceAll("[^\\d||.]", ""));
                if (!tableTextArea.getText().matches("\\d{0,2}"))
                    tableTextArea.setText(tableTextArea.getText().substring(0, 2));
            }
        });
        this.tableTextArea.setAlignment(Pos.CENTER);

    }
}