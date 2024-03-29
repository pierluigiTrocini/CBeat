package it.unical.demacs.progetto.cbeat.cbeat.controller;

import java.net.URL;
import java.sql.SQLException;
import java.util.Map;
import java.util.ResourceBundle;

import it.unical.demacs.progetto.cbeat.cbeat.handler.DatabaseHandler;
import it.unical.demacs.progetto.cbeat.cbeat.utility.ActiveEmployee;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class AnalyticsController implements Initializable {

    @FXML
    private LineChart<String, Integer> analytics;

    @FXML
    private BorderPane borderPane;

    @FXML
    private Button showGeneralChart;

    @FXML
    private Button showPersonalChart;

    @FXML
    private VBox vBox;

    @FXML
    private CategoryAxis xAxis;

    @FXML
    private NumberAxis yAxis;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.analytics.setAnimated(false);
        try {
            ShowPersonalChart();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void RefreshGeneralChart(ActionEvent event) throws SQLException {
        ShowGeneralChart();

    }


    @FXML
    void RefreshPersonalChart(ActionEvent event) throws SQLException {
        ShowPersonalChart();

    }

    private void ShowPersonalChart() throws SQLException {
        Map<String,Integer> map = DatabaseHandler.getInstance().RetrievePersonalAnalytics(ActiveEmployee.getInstance().getUsername());
        analytics.getData().clear();
        xAxis.setLabel("Data");
        yAxis.setLabel("Ordini processati");

        analytics.setTitle("Statistiche di "+ActiveEmployee.getInstance().getUsername());
        XYChart.Series<String, Integer> series=new XYChart.Series<String, Integer>();
        series.setName("Statistiche individuali");

        map.forEach((key,value)-> series.getData().add(new XYChart.Data<String, Integer>(key,value)
        ));
        analytics.getData().add(series);

    }

    private void ShowGeneralChart() throws SQLException {

        Map<String,Integer> map = DatabaseHandler.getInstance().RetrieveGeneralAnalytics();
        analytics.getData().clear();


        analytics.setTitle("Statistiche del Personale");
        xAxis.setLabel("Impiegato");
        yAxis.setLabel("Ordini processati");

        XYChart.Series<String, Integer> series= new XYChart.Series<String, Integer>();

        series.setName("Statistiche personali");

        map.forEach((key,value)-> series.getData().add(new XYChart.Data<String, Integer>(key,value)
        ));
        analytics.getData().add(series);

    }



}
