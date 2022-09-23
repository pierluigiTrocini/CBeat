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

            JsonObject jsonObject = APIHandler.getInstance().searchFromText(String.valueOf(alphabet));
            if (!jsonObject.get("drinks").isJsonNull()) {
                JsonArray array = jsonObject.getAsJsonArray("drinks");
                for (int i = 0; i < array.size(); i++) {
                    JsonObject object = array.get(i).getAsJsonObject();
                    PreparedStatement stmt = connection.prepareStatement(Settings.insertionQuery);

                    stmt.setString(1, String.valueOf(object.get("idDrink")));
                    stmt.setString(2, String.valueOf(object.get("strDrink")));
                    stmt.setString(3, String.valueOf(object.get("strAlcoholic")));
                    stmt.setString(4, String.valueOf(object.get("strDrinkThumb")));
                    stmt.setString(5, String.valueOf(object.get("strInstructionsIT")));
                    stmt.setString(6, String.valueOf(object.get("strIngredient1")));
                    stmt.setString(7, String.valueOf(object.get("strIngredient2")));
                    stmt.setString(8, String.valueOf(object.get("strIngredient3")));
                    stmt.setString(9, String.valueOf(object.get("strIngredient4")));
                    stmt.setString(10, String.valueOf(object.get("strIngredient5")));
                    stmt.setString(11, String.valueOf(object.get("strIngredient6")));
                    stmt.setString(12, String.valueOf(object.get("strIngredient7")));
                    stmt.setString(13, String.valueOf(object.get("strIngredient8")));
                    stmt.setString(14, String.valueOf(object.get("strIngredient9")));
                    stmt.setString(15, String.valueOf(object.get("strIngredient10")));
                    stmt.setString(16, String.valueOf(object.get("strIngredient11")));
                    stmt.setString(17, String.valueOf(object.get("strIngredient12")));
                    stmt.setString(18, String.valueOf(object.get("strIngredient13")));
                    stmt.setString(19, String.valueOf(object.get("strIngredient14")));
                    stmt.setString(20, String.valueOf(object.get("strIngredient15")));
                    stmt.setString(21, String.valueOf(object.get("strMeasure1")));
                    stmt.setString(22, String.valueOf(object.get("strMeasure2")));
                    stmt.setString(23, String.valueOf(object.get("strMeasure3")));
                    stmt.setString(24, String.valueOf(object.get("strMeasure4")));
                    stmt.setString(25, String.valueOf(object.get("strMeasure5")));
                    stmt.setString(26, String.valueOf(object.get("strMeasure6")));
                    stmt.setString(27, String.valueOf(object.get("strMeasure7")));
                    stmt.setString(28, String.valueOf(object.get("strMeasure8")));
                    stmt.setString(29, String.valueOf(object.get("strMeasure9")));
                    stmt.setString(30, String.valueOf(object.get("strMeasure10")));
                    stmt.setString(31, String.valueOf(object.get("strMeasure11")));
                    stmt.setString(32, String.valueOf(object.get("strMeasure12")));
                    stmt.setString(33, String.valueOf(object.get("strMeasure13")));
                    stmt.setString(34, String.valueOf(object.get("strMeasure14")));
                    stmt.setString(35, String.valueOf(object.get("strMeasure15")));

                    stmt.execute();
                }
            }
        }

        this.databaseClose();
    }
}