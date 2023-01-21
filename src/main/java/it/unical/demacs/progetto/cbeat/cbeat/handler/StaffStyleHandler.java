package it.unical.demacs.progetto.cbeat.cbeat.handler;

import javafx.scene.effect.BoxBlur;
import javafx.scene.layout.StackPane;

public class StaffStyleHandler {
    private static StaffStyleHandler instance = new StaffStyleHandler();
    public StaffStyleHandler() {}
    public static StaffStyleHandler getInstance() {return instance;}
    
    private StackPane homepageStaffStackPane;

    public void setHomepageStaffStackPane( StackPane homepageStaffStackPane ){
        this.homepageStaffStackPane = homepageStaffStackPane;
    }

    
    public void setBlurEffect(){
        this.homepageStaffStackPane.getChildren().get(
                this.homepageStaffStackPane.getChildren().size() - 1
        ).setEffect(new BoxBlur( 15, 15,1 ));
    }

    public void removeBlurEffect(){
        this.homepageStaffStackPane.getChildren().get(
                this.homepageStaffStackPane.getChildren().size() - 1
        ).setEffect(null);
    }



}
