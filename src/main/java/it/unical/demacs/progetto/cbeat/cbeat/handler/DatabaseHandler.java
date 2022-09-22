package it.unical.demacs.progetto.cbeat.cbeat.handler;

import com.google.gson.*;
import it.unical.demacs.progetto.cbeat.cbeat.utility.Settings;
import org.sqlite.SQLiteException;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.*;

public class DatabaseHandler{
    private static DatabaseHandler instance = new DatabaseHandler();
    public DatabaseHandler() { this.databaseConnect(); }
    public static DatabaseHandler getInstance() { return instance; }


    private Connection connection = null;

    public void databaseConnect() {
        try {
            connection = DriverManager.getConnection(Settings.databaseUrl);
        } catch (SQLException e) { e.printStackTrace(); } //TODO serve grafica
    }

    public void databaseClose(){
        try {
            if( connection != null ) connection.close();
            connection = null;
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateLocalDatabase() throws IOException, SQLException {
        for( char alphabet = 'a';  alphabet <= 'z'; alphabet++ ) {

            System.out.println("[DEBUG] lettera: " + alphabet);
            try {
                JsonArray array = (APIHandler.getInstance().searchFromText(String.valueOf(alphabet))).get("drinks").getAsJsonArray();
                for (int i = 0; i < array.size(); i++) {
                    PreparedStatement stmt = connection.prepareStatement(Settings.insertionQuery);

                    Map<String, String> object = (new Gson()).fromJson(array.get(i).getAsJsonObject(), Map.class);

                    stmt.setString(1, object.get("idDrink"));
                    stmt.setString(2, object.get("strDrink"));
                    stmt.setString(3, object.get("strAlcoholic"));
                    stmt.setString(4, object.get("strDrinkThumb"));
                    stmt.setString(5, object.get("strInstructionsIT"));
                    stmt.setString(6, object.get("strIngredient1"));
                    stmt.setString(7, object.get("strIngredient2"));
                    stmt.setString(8, object.get("strIngredient3"));
                    stmt.setString(9, object.get("strIngredient4"));
                    stmt.setString(10, object.get("strIngredient5"));
                    stmt.setString(11, object.get("strIngredient6"));
                    stmt.setString(12, object.get("strIngredient7"));
                    stmt.setString(13, object.get("strIngredient8"));
                    stmt.setString(14, object.get("strIngredient9"));
                    stmt.setString(15, object.get("strIngredient10"));
                    stmt.setString(16, object.get("strIngredient11"));
                    stmt.setString(17, object.get("strIngredient12"));
                    stmt.setString(18, object.get("strIngredient13"));
                    stmt.setString(19, object.get("strIngredient14"));
                    stmt.setString(20, object.get("strIngredient15"));
                    stmt.setString(21, object.get("strMeasure1"));
                    stmt.setString(22, object.get("strMeasure2"));
                    stmt.setString(23, object.get("strMeasure3"));
                    stmt.setString(24, object.get("strMeasure4"));
                    stmt.setString(25, object.get("strMeasure5"));
                    stmt.setString(26, object.get("strMeasure6"));
                    stmt.setString(27, object.get("strMeasure7"));
                    stmt.setString(28, object.get("strMeasure8"));
                    stmt.setString(29, object.get("strMeasure9"));
                    stmt.setString(30, object.get("strMeasure10"));
                    stmt.setString(31, object.get("strMeasure11"));
                    stmt.setString(32, object.get("strMeasure12"));
                    stmt.setString(33, object.get("strMeasure13"));
                    stmt.setString(34, object.get("strMeasure14"));
                    stmt.setString(35, object.get("strMeasure15"));

                    stmt.execute();
                }
            }catch ( JsonIOException exception ){ exception.printStackTrace(); }
        }

        this.databaseClose();
    }


}