package it.unical.demacs.progetto.cbeat.cbeat.controller;

import it.unical.demacs.progetto.cbeat.cbeat.handler.StyleHandler;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
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

    public void init(String url, String name ){
        this.itemLabel.setText( name );
        this.itemImg.setImage( new Image(url));
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
    }

    @FXML
    void increase(MouseEvent event) {
        this.amountText.setText(String.valueOf((Integer.parseInt(this.amountText.getText()) + 1 )));
    }
}
