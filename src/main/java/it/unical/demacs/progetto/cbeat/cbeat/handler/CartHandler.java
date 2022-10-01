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

    private ArrayList<CartElement> list = new ArrayList<>();

    public void addElement( String url, String name, String id ){
        this.list.add( new CartElement( url, name, id ) );
    }

    public void refreshList(VBox vBox){
        try {
            if( !list.isEmpty() ) {
                for (CartElement element : list) {
                    FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("item-list-element.fxml"));
                    Parent parent = loader.load();
                    ItemListElementController controller = loader.getController();

                    controller.init(element.imageUrl(), element.name());
                    controller.getHBox().prefWidthProperty().bind( vBox.widthProperty() );


                    vBox.getChildren().add(parent);
                }
            }
        }catch (Exception e){ e.printStackTrace(); }
    }
}
