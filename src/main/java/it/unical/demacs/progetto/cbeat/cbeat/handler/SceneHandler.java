package it.unical.demacs.progetto.cbeat.cbeat.handler;

import it.unical.demacs.progetto.cbeat.cbeat.HelloApplication;
import it.unical.demacs.progetto.cbeat.cbeat.controller.CartController;
import it.unical.demacs.progetto.cbeat.cbeat.controller.DrinkInfoController;
import it.unical.demacs.progetto.cbeat.cbeat.controller.HomepageClientController;
import it.unical.demacs.progetto.cbeat.cbeat.controller.HomepageStaffController;
import it.unical.demacs.progetto.cbeat.cbeat.utility.Settings;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class SceneHandler {
    /* Singleton */
    private static  SceneHandler instance = new SceneHandler();
    public SceneHandler(){}
    public static SceneHandler getInstance() { return instance; }

    private Scene scene;
    private Stage stage;

    private BorderPane loginBorderPane;
    private StackPane homepageClientStackPane;

    public void init( Stage stage ) throws IOException {
        this.stage = stage;

        createLoginScene();

        this.stage.show();
    }

    public void setLoginBorderPane(BorderPane loginBorderPane) {
        this.loginBorderPane = loginBorderPane;
    }

    public void setHomepageClientStackPane(StackPane homepageClientStackPane) {
        this.homepageClientStackPane = homepageClientStackPane;
    }

    private <T> T loadRootFromFXML(String resourceName) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource(resourceName));
        return fxmlLoader.load();
    }

    public void mainSettings(String title, Double width, Double height, boolean resizable ){
        this.stage.setTitle(title);

        this.stage.setWidth(width);
        this.stage.setHeight(height);
        this.stage.setResizable(resizable);
    }

    public void createLoginScene() {
        try {
            if (this.scene == null)
                this.scene = new Scene(loadRootFromFXML("login-view.fxml"));
            else
                this.scene.setRoot(loadRootFromFXML("login-view.fxml"));

            this.stage.setScene(scene);
            mainSettings( Settings.loginTitle ,Settings.loginWidth, Settings.loginHeight, true);


        }catch (IOException exception){
            System.out.println("Impossibile aprire il file fxml");
        }
    }


    public void createClientHomepageScene( String table ){
        try {
            FXMLLoader loader = new FXMLLoader( HelloApplication.class.getResource( "homepage-client.fxml" ) );
            Parent parent = loader.load();
            HomepageClientController controller = loader.getController();

            if (this.scene == null)
                this.scene = new Scene(parent);
            else
                this.scene.setRoot(parent);

            controller.getBorderPane().prefHeightProperty().bind( this.scene.heightProperty() );
            controller.getBorderPane().prefWidthProperty().bind( this.scene.widthProperty() );

            this.stage.setScene(scene);
            mainSettings( Settings.clientTitle + table , Settings.homepageInitialWidth, Settings.homepageInitialHeight, true );
            CartHandler.getInstance().setTable(Integer.parseInt(table));


        }catch (IOException exception){ exception.printStackTrace(); }


    }

    public void showMainLogin() throws IOException {
        VBox vBox = FXMLLoader.load(HelloApplication.class.getResource("login-main.fxml"));
        this.loginBorderPane.setLeft(vBox);
    }

    public void showClientLogin() throws IOException {
        Pane pane = FXMLLoader.load(HelloApplication.class.getResource("login-as-client.fxml"));
        this.loginBorderPane.setLeft(pane);
    }

    public void showWorkerLogin() throws IOException {
        Pane pane = FXMLLoader.load(HelloApplication.class.getResource("login-as-worker.fxml"));
        this.loginBorderPane.setLeft(pane);
    }

    public void showDrinkInfo( String drinkName ) throws IOException, SQLException {

        FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("drink-info.fxml"));
        Parent pane = (Parent) loader.load();
        DrinkInfoController controller = loader.getController();

        StyleHandler.getInstance().setBlurEffect();
        controller.init( drinkName );

        controller.getBorderPane().prefHeightProperty().bind( this.homepageClientStackPane.heightProperty() );
        controller.getBorderPane().prefWidthProperty().bind( this.homepageClientStackPane.widthProperty() );

        this.homepageClientStackPane.getChildren().add(pane);
    }

    public void showCart() throws IOException {
        FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("cart-view.fxml"));
        Parent pane = (Parent) loader.load();
        CartController controller = loader.getController();

        controller.getBorderPane().prefWidthProperty().bind( this.homepageClientStackPane.widthProperty() );
        controller.getBorderPane().prefHeightProperty().bind( this.homepageClientStackPane.heightProperty() );

        this.homepageClientStackPane.getChildren().add(pane);
    }

    public void hideDrinkInfo() {
        this.homepageClientStackPane.getChildren().remove(
                this.homepageClientStackPane.getChildren().size() -1
        );
        StyleHandler.getInstance().removeBlurEffect();
    }

    public void hideCart(){
        this.homepageClientStackPane.getChildren().remove(
                this.homepageClientStackPane.getChildren().size() -1
        );
    }

    //Sezione staff
    public void createStaffHomepageScene( String user ){
        try {
            FXMLLoader loader = new FXMLLoader( HelloApplication.class.getResource( "homepage-staff.fxml" ) );
            Parent parent = loader.load();
            HomepageStaffController controller = loader.getController();

            if (this.scene == null)
                this.scene = new Scene(parent);
            else
                this.scene.setRoot(parent);

            this.stage.setScene(scene);
            mainSettings( Settings.staffTitle + user , Settings.homepageInitialWidth, Settings.homepageInitialHeight, true );
            controller.getWelcomeLabel().setText(Settings.welcomeStaff + " " + user);



        }catch (IOException exception){ exception.printStackTrace(); }


    }






}
