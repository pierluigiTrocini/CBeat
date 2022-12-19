package it.unical.demacs.progetto.cbeat.cbeat.controller;

import it.unical.demacs.progetto.cbeat.cbeat.handler.CartHandler;
import it.unical.demacs.progetto.cbeat.cbeat.handler.StyleHandler;
import it.unical.demacs.progetto.cbeat.cbeat.model.CartElement;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;

import java.net.URL;
import java.util.ResourceBundle;

public class ItemListElementController implements Initializable {
    @FXML
    private HBox hBox;

    @FXML
    private Button amountAdd;

    @FXML
    private Button amountSub;

    @FXML
    private TextField amountText;

    @FXML
    private ImageView itemImg;

    @FXML
    private Label itemLabel;

    @FXML
    private Button removeButton;

    public HBox getHBox() { return hBox; }

    private CartElement info;

    public void init( CartElement element ){
        this.info = element;

        this.itemLabel.setText( this.info.name );
        this.itemImg.setImage( new Image( this.info.imageUrl ) );
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.amountAdd.setGraphic( StyleHandler.getInstance().getIcon( "mdi2c-cart-plus", 20 ) );
        this.amountSub.setGraphic( StyleHandler.getInstance().getIcon( "mdi2c-cart-minus", 20 ) );

        this.amountText.setEditable(false);
        this.amountText.setStyle( "-fx-background-color: transparent" );
        this.amountText.setText("1");

        this.amountText.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if( Integer.parseInt( newValue ) < 1 )
                    amountText.setText("1");
            }
        });
    }

    @FXML
    void decrease(MouseEvent event) {
        this.amountText.setText(String.valueOf(( Integer.parseInt(this.amountText.getText()) - 1 )));
        CartHandler.getInstance().decreaseAmount( this.info );
    }

    @FXML
    void increase(MouseEvent event) {
        this.amountText.setText(String.valueOf((Integer.parseInt(this.amountText.getText()) + 1 )));
        CartHandler.getInstance().increaseAmount( this.info );
    }

    @FXML
    void remove(MouseEvent event) {
        CartHandler.getInstance().remove( this.info );
    }
}
