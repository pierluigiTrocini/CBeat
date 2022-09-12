package it.unical.demacs.progetto.cbeat.cbeat.handler;

import it.unical.demacs.progetto.cbeat.cbeat.HelloApplication;
import it.unical.demacs.progetto.cbeat.cbeat.utility.Settings;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneHandler {
    /* Singleton */
    private static  SceneHandler instance = new SceneHandler();
    public SceneHandler(){}
    public static SceneHandler getInstance() { return instance; }

    private Scene scene;
    private Stage stage;

    private <T> T loadRootFromFXML(String resourceName) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource(resourceName));
        return fxmlLoader.load();
    }

    public void setDimension( Double width, Double height, boolean resizable ){
        this.stage.setWidth(width);
        this.stage.setHeight(height);
        this.stage.setResizable(resizable);
    }

    public void init( Stage stage ) throws IOException {
        this.stage = stage;

        createLoginScene();

        this.stage.show();
    }

    public void createLoginScene() throws IOException {
        if( this.scene == null )
            this.scene = new Scene(loadRootFromFXML("login-view.fxml"));
        else
            this.scene.setRoot(loadRootFromFXML("login-view.fxml"));

        setDimension( Settings.loginWidth, Settings.loginHeight, false );

    }


}
