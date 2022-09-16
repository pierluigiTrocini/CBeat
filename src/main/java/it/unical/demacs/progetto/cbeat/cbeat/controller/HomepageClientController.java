package it.unical.demacs.progetto.cbeat.cbeat.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;

import java.net.URL;
import java.util.ResourceBundle;

public class HomepageClientController implements Initializable {

    @FXML
    private FlowPane itemList;

    @FXML
    private Button searchButton;

    @FXML
    private TextField searchText;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.searchText.setPromptText("Es: long island");
    }
}