package it.unical.demacs.progetto.cbeat.cbeat;

import it.unical.demacs.progetto.cbeat.cbeat.handler.SceneHandler;
import javafx.application.Application;

import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException, SQLException {
        System.setProperty("com.sun.javafx.transparentFramebuffer", "true");

        SceneHandler.getInstance().init(stage);
    //    DatabaseHandler.getInstance().updateLocalDatabase();


    }

    public static void main(String[] args) {launch();}
}