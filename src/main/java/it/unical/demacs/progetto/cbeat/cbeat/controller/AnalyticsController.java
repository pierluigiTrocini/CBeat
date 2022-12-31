package it.unical.demacs.progetto.cbeat.cbeat.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class AnalyticsController implements Initializable {

    @FXML
    private LineChart<?, ?> analytics;

    @FXML
    private BorderPane borderPane;

    @FXML
    private Button showGeneralChart;

    @FXML
    private Button showPersonalChart;

    @FXML
    private VBox vBox;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        // TODO Auto-generated method stub
        
    }

}
