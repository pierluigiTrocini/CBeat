package it.unical.demacs.progetto.cbeat.cbeat.controller;


import it.unical.demacs.progetto.cbeat.cbeat.handler.SceneHandler;
import javafx.fxml.FXML;

import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

import java.io.IOException;


public class MainLogin {

    @FXML
    private Button clientLoginBtn;

    @FXML
    private Button workerLoginBtn;

    @FXML
    void showClientLogin(MouseEvent event) throws IOException {
        SceneHandler.getInstance().showClientLogin();
    }

    @FXML
    void showWorkerLogin(MouseEvent event) throws IOException {
        SceneHandler.getInstance().showWorkerLogin();
    }

}
