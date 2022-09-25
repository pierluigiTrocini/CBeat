package it.unical.demacs.progetto.cbeat.cbeat.handler;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import it.unical.demacs.progetto.cbeat.cbeat.HelloApplication;
import it.unical.demacs.progetto.cbeat.cbeat.controller.ItemCardController;
import it.unical.demacs.progetto.cbeat.cbeat.utility.Settings;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.FlowPane;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class APIHandler {
    private static APIHandler instance = new APIHandler();
    public APIHandler() {}
    public static APIHandler getInstance(){ return instance; }

    private FlowPane itemList;

    public void setItemList(FlowPane itemList) { this.itemList = itemList; }

    public JsonObject searchFromText(String content ) throws IOException{
        URLConnection request = ( new URL("https://www.thecocktaildb.com/api/json/v1/" + Settings.apikey + "/search.php?f=" + content)).openConnection();   // f -> first letter
        request.connect();

        JsonParser parser = new JsonParser();
        JsonObject root = (JsonObject) parser.parse( new InputStreamReader( (InputStream) request.getContent()));
        return  root;
    }

    public void addCards( ResultSet set) {
        try {
            this.itemList.getChildren().clear();

            while ( set.next() ){
                FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("item-card.fxml"));
                Parent pane = (Parent) fxmlLoader.load();
                ItemCardController controller = fxmlLoader.getController();
                controller.init( set.getString("strDrink").replace("\"", ""),
                        set.getString("strDrinkThumb").replace("\"", "") );

                this.itemList.getChildren().add(pane);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
