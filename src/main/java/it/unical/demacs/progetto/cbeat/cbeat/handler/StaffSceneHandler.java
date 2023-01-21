package it.unical.demacs.progetto.cbeat.cbeat.handler;

import java.io.IOException;
import java.sql.SQLException;

import animatefx.animation.FadeOut;
import it.unical.demacs.progetto.cbeat.cbeat.HelloApplication;
import it.unical.demacs.progetto.cbeat.cbeat.controller.StaffDrinkInfoController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.StackPane;

public class StaffSceneHandler {
    private static  StaffSceneHandler instance = new StaffSceneHandler();
    private StaffSceneHandler(){}
    public static StaffSceneHandler getInstance() { return instance; }
    
    private StackPane homepageStaffStackPane;

    public void setHomepageStaffStackPane(StackPane homepageStaffStackPane){
        this.homepageStaffStackPane = homepageStaffStackPane;
    }

    public void showStaffDrinkInfo( String drinkId ) throws IOException, SQLException{
        FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("drink-info-staff.fxml"));
        Parent pane = (Parent) loader.load();
        StaffDrinkInfoController controller = loader.getController();

        StaffStyleHandler.getInstance().setBlurEffect();
        controller.init( drinkId );

        controller.getBorderPane().prefHeightProperty().bind( this.homepageStaffStackPane.heightProperty() );
        controller.getBorderPane().prefWidthProperty().bind( this.homepageStaffStackPane.widthProperty() );   

        this.homepageStaffStackPane.getChildren().add(pane);
    }

    public void hide(){
        FadeOut fadeOut = new FadeOut(
            this.homepageStaffStackPane.getChildren().get(
                this.homepageStaffStackPane.getChildren().size() - 1
            )
        );

        fadeOut.setOnFinished(e -> {
                this.homepageStaffStackPane.getChildren().remove(
                    this.homepageStaffStackPane.getChildren().size() - 1
                );
                StaffStyleHandler.getInstance().removeBlurEffect();
            }
        );

        fadeOut.setSpeed(3.0).play();
    }
}

