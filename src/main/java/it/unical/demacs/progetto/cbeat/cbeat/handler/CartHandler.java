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

    private VBox cart;
    public void setCart(VBox cart) { this.cart = cart; }

    private int table;
    public void setTable(int table) { this.table = table; }

    private ArrayList<CartElement> list = new ArrayList<>();
    public void clearList(){ this.list.clear(); }

    public void insertOrders() {
        if( !this.list.isEmpty() ){
            for( CartElement element: this.list ){
                try {
                    System.out.println( DatabaseHandler.getInstance().insertOrders('\"' + element.id + '\"', element.amount, this.table) );
                }catch (Exception e){ e.printStackTrace(); }
            }
        }
    }


    public void addElement( String url, String name, String id ){
        this.list.add( new CartElement( url, name, id, 1 ) );
    }
    public void remove( CartElement element ){
        this.list.remove( element );
        this.refreshList();
    }

    public void increaseAmount( CartElement element ){
        this.list.get( this.list.indexOf(element) ).amount += 1;
    }

    public void decreaseAmount( CartElement element ){
        this.list.get( this.list.indexOf(element) ).amount -= 1;
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
