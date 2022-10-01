package it.unical.demacs.progetto.cbeat.cbeat.controller;

import it.unical.demacs.progetto.cbeat.cbeat.HelloApplication;
import it.unical.demacs.progetto.cbeat.cbeat.handler.CartHandler;
import it.unical.demacs.progetto.cbeat.cbeat.handler.SceneHandler;
import it.unical.demacs.progetto.cbeat.cbeat.handler.StyleHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CartController implements Initializable {

    @FXML
    private ScrollPane scrollPane;

    @FXML
    private VBox VBox;

    @FXML
    private BorderPane borderPane;

    @FXML
    private Button purchaseBtn;

    @FXML
    private Button exitButton;

    public BorderPane getBorderPane() { return borderPane; }

    @FXML
    void purchase(MouseEvent event) {
        CartHandler.getInstance().insertOrders();
        SceneHandler.getInstance().hideCart();
    }

    @FXML
    void exit(MouseEvent event) {
        SceneHandler.getInstance().hideCart();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.VBox.prefWidthProperty().bind( this.scrollPane.widthProperty() );
        this.VBox.prefHeightProperty().bind( this.scrollPane.heightProperty() );

        this.VBox.setStyle("-fx-background-color: transparent");
        this.scrollPane.setStyle( "-fx-background-color: transparent" );
        this.scrollPane.setHbarPolicy( ScrollPane.ScrollBarPolicy.NEVER );

        this.exitButton.setGraphic(StyleHandler.getInstance().getIcon("mdi2c-close", 10));

        CartHandler.getInstance().setCart( this.VBox );
        CartHandler.getInstance().refreshList();

    }
}
