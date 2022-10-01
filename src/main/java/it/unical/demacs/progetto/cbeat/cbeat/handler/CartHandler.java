package it.unical.demacs.progetto.cbeat.cbeat.handler;

import it.unical.demacs.progetto.cbeat.cbeat.HelloApplication;
import it.unical.demacs.progetto.cbeat.cbeat.controller.ItemListElementController;
import it.unical.demacs.progetto.cbeat.cbeat.model.CartElement;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class CartHandler {
    private static CartHandler instance = new CartHandler();
    public static CartHandler getInstance() { return instance; }
    public CartHandler() {}

    VBox cart;
    public void setCart(VBox cart) { this.cart = cart; }

    private ArrayList<CartElement> list = new ArrayList<>();


    public void addElement( String url, String name, String id ){
        this.list.add( new CartElement( url, name, id ) );
    }
    public void remove( CartElement element ){
        this.list.remove( element );
        this.refreshList();
    }

    public void refreshList(){
        try {
            this.cart.getChildren().clear();
            if( !list.isEmpty() ) {
                for (CartElement element : list) {
                    FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("item-list-element.fxml"));
                    Parent parent = loader.load();
                    ItemListElementController controller = loader.getController();

                    controller.init( element );
                    controller.getHBox().prefWidthProperty().bind( this.cart.widthProperty() );


                    this.cart.getChildren().add(parent);
                }
            }
        }catch (Exception e){ e.printStackTrace(); }
    }
}
