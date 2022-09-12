package it.unical.demacs.progetto.cbeat.cbeat;

import it.unical.demacs.progetto.cbeat.cbeat.handler.SceneHandler;
import javafx.application.Application;

import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        SceneHandler.getInstance().init(stage);
    }

    public static void main(String[] args) {launch();}
}