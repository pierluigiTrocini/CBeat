package it.unical.demacs.progetto.cbeat.cbeat.controller;

import it.unical.demacs.progetto.cbeat.cbeat.handler.SceneHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

public class HomepageStaffController implements Initializable {

    @FXML
    private Button LogoutButton;

    @FXML
    private BorderPane borderPane;

    @FXML
    private VBox orderList;

    @FXML
    private ScrollPane orderScrollPane;

    @FXML
    private StackPane orderStackPane;

    @FXML
    private Label welcomeLabel;

    public Label getWelcomeLabel() { return welcomeLabel; }

    @FXML
    void doLogout(MouseEvent event) {
        SceneHandler.getInstance().createLoginScene();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.orderScrollPane.setHbarPolicy( ScrollPane.ScrollBarPolicy.NEVER );

        this.orderScrollPane.prefWidthProperty().bind( this.orderStackPane.widthProperty() );
        this.orderScrollPane.prefHeightProperty().bind( this.orderStackPane.heightProperty() );
        this.orderList.prefWidthProperty().bind( this.orderScrollPane.widthProperty() );
        this.orderList.prefHeightProperty().bind( this.orderScrollPane.heightProperty() );
    }
}