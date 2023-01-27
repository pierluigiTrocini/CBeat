package it.unical.demacs.progetto.cbeat.cbeat.handler;

import it.unical.demacs.progetto.cbeat.cbeat.HelloApplication;
import it.unical.demacs.progetto.cbeat.cbeat.controller.OrderElement;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.VBox;

import java.sql.ResultSet;

public class OrderHandler {
    public static OrderHandler instance = new OrderHandler();
    private OrderHandler(){}
    public static OrderHandler getInstance() { return instance; }

    private VBox orderList;
    public void setOrderList(VBox orderList) { this.orderList = orderList; }

    public void refreshOrderList(){
        try{
            ResultSet set = DatabaseHandler.getInstance().queryOrders();
            this.orderList.getChildren().clear();

            while( set.next() ){
                FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("order-list-element.fxml"));
                Parent newOrder = loader.load();
                OrderElement controller = loader.getController();

                controller.init(
                        set.getInt(1),
                        set.getString(2).replaceAll("\"",""),
                        set.getString(3).replaceAll("\"",""),
                        set.getInt(4),
                        set.getInt(5)
                );

                controller.gethBox().prefWidthProperty().bind( this.orderList.widthProperty() );
                this.orderList.getChildren().add(newOrder);
            }


        }catch (Exception e){ e.printStackTrace(); }
    }
}
