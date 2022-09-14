package it.unical.demacs.progetto.cbeat.cbeat.controller;

import it.unical.demacs.progetto.cbeat.cbeat.handler.SceneHandler;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

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
    void backToLogin(MouseEvent event) throws IOException {
        SceneHandler.getInstance().showMainLogin();
    }

    @FXML
    void loginAsClient(MouseEvent event) {
        System.out.println("è stato inserito il tavolo" + this.tableTextArea.getText());
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.tableTextArea.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if( !Pattern.matches( "\\d{0,2}", tableTextArea.getText() )){
                    tableTextArea.setText(
                            tableTextArea.getText().substring(0, 2) //TODO escludere i caratteri dall'input
                    );
                }
            }
        });
        this.tableTextArea.setAlignment(Pos.CENTER);

    }
}