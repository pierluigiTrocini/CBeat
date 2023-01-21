package it.unical.demacs.progetto.cbeat.cbeat.controller;

import it.unical.demacs.progetto.cbeat.cbeat.HelloApplication;
import it.unical.demacs.progetto.cbeat.cbeat.handler.OrderHandler;
import it.unical.demacs.progetto.cbeat.cbeat.handler.SceneHandler;
import it.unical.demacs.progetto.cbeat.cbeat.handler.StaffSceneHandler;
import it.unical.demacs.progetto.cbeat.cbeat.handler.StaffStyleHandler;
import it.unical.demacs.progetto.cbeat.cbeat.utility.ActiveEmployee;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class HomepageStaffController implements Initializable {

    @FXML
    private Button LogoutButton;

    @FXML
    private AnchorPane AnalyticsPane;

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
        ButtonType Confirm = new ButtonType("Si", ButtonBar.ButtonData.OK_DONE);
        ButtonType Cancel = new ButtonType("Annulla", ButtonBar.ButtonData.CANCEL_CLOSE);
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION,"Sei sicuro di voler effettuare il logout?",Confirm,Cancel);
        alert.setTitle("Logout");


        alert.showAndWait().filter(Confirm::equals).ifPresent(b -> {
                    ActiveEmployee.getInstance().setUsername(null);
                    SceneHandler.getInstance().createLoginScene();
                });

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.orderScrollPane.setHbarPolicy( ScrollPane.ScrollBarPolicy.NEVER );

        this.orderScrollPane.prefWidthProperty().bind( this.orderStackPane.widthProperty() );
        this.orderScrollPane.prefHeightProperty().bind( this.orderStackPane.heightProperty() );
        this.orderList.prefWidthProperty().bind( this.orderScrollPane.widthProperty() );
        this.orderList.prefHeightProperty().bind( this.orderScrollPane.heightProperty() );

       FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("analytics-view.fxml"));
        try {
            Node node=loader.load();
            this.AnalyticsPane.getChildren().add(node);
        } catch (IOException e) {
            e.printStackTrace();
        }

        StaffSceneHandler.getInstance().setHomepageStaffStackPane(this.orderStackPane);
        StaffStyleHandler.getInstance().setHomepageStaffStackPane(this.orderStackPane);

        OrderHandler.getInstance().setOrderList( this.orderList );
        OrderHandler.getInstance().refreshOrderList();
    }
}