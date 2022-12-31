package it.unical.demacs.progetto.cbeat.cbeat.controller;

import it.unical.demacs.progetto.cbeat.cbeat.handler.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;
import java.net.URL;

import java.util.ResourceBundle;

public class HomepageClientController implements Initializable {

    @FXML
    private BorderPane borderPane;

    @FXML
    private FlowPane itemList;

    @FXML
    private Button searchButton;

    @FXML
    private ScrollPane scrollPane;

    @FXML
    private TextField searchText;

    @FXML
    private StackPane stackPane;

    @FXML
    private Button alcoholicBtn;

    @FXML
    private Button cartBtn;

    @FXML
    private Button notAlcoholicBtn;

    @FXML
    private Button randomBtn;

    public BorderPane getBorderPane() { return borderPane; }

    @Override
    public void initialize(URL location, ResourceBundle resources){
        this.searchButton.setPrefWidth(75);

        this.scrollPane.setHbarPolicy( ScrollPane.ScrollBarPolicy.NEVER );

        SceneHandler.getInstance().setHomepageClientStackPane( this.stackPane );
        StyleHandler.getInstance().setHomepageClientStackPane( this.stackPane );
        APIHandler.getInstance().setItemList( this.itemList );


        this.scrollPane.prefWidthProperty().bind( this.borderPane.widthProperty() );
        this.scrollPane.prefHeightProperty().bind( this.borderPane.heightProperty() );
        this.itemList.prefWidthProperty().bind( this.scrollPane.widthProperty() );
        this.itemList.prefHeightProperty().bind( this.scrollPane.heightProperty() );

        this.cartBtn.setGraphic( StyleHandler.getInstance().getIcon("mdi2c-cart-variant", 35) );

        try {
            APIHandler.getInstance().addCards( DatabaseHandler.getInstance().queryForCards() );
        } catch (Exception e) {
            // TODO  - Grafica per comunicare l'assenza di risultati
            e.printStackTrace();
        }

        this.searchText.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                try {
                    if (newValue.isEmpty())
                        APIHandler.getInstance().addCards(DatabaseHandler.getInstance().queryForCards());
                    if (oldValue != newValue && !oldValue.isEmpty() && !newValue.isEmpty() && ( newValue.length() > oldValue.length() ) )
                        APIHandler.getInstance().addCards(DatabaseHandler.getInstance().querySearch(searchText.getText()));
                }catch ( Exception e ){ e.printStackTrace(); }
            }
        });

    }

    @FXML
    void searchByText(MouseEvent event) {
        try {
            if( this.searchText.getText().isEmpty() )
                APIHandler.getInstance().addCards( DatabaseHandler.getInstance().queryForCards() );
            else
                APIHandler.getInstance().addCards( DatabaseHandler.getInstance().querySearch(this.searchText.getText()));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    void selectRandom(MouseEvent event) {

    }

    @FXML
    void showCart(MouseEvent event) {
        try {
            SceneHandler.getInstance().showCart();
        }catch (Exception e) { e.printStackTrace(); }
    }

    @FXML
    void showOnlyAlcoholic(MouseEvent event) {
        try{
            APIHandler.getInstance().addCards( DatabaseHandler.getInstance().showOnly(true) );
        }catch (Exception e){ e.printStackTrace(); }
    }

    @FXML
    void showOnlyNotAlcoholic(MouseEvent event) {
        try{
            APIHandler.getInstance().addCards( DatabaseHandler.getInstance().showOnly( false ) );
        }catch (Exception e){ e.printStackTrace(); }
    }

}





















