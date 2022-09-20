package it.unical.demacs.progetto.cbeat.cbeat.handler;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
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
import java.util.Objects;

public class DatabaseHandler {
    private Connection connection;
    private static DatabaseHandler instance = null;
    private DatabaseHandler() { connect(); }

    public static DatabaseHandler getInstance(){
        if( instance == null ) instance = new DatabaseHandler();
        return instance;
    }

    public void connect(){
        try {
            connection = DriverManager.getConnection(Settings.databaseUrl);
        }catch (SQLException e){
            //TODO - Schermata di errore database
        }
    }

    public void disconnect(){
        try {
            if( connection != null && !connection.isClosed() ){
                connection.close();
            }
        }catch ( SQLException e ){
            //TODO - Schermata di errore database
        }
    }

    public void updateLocalDatabase() throws IOException, SQLException {
        for( char alphabet = 'a';  alphabet <= 'a'; alphabet++ ) {

            JsonArray array = (APIHandler.getInstance().searchFromText(String.valueOf(alphabet))).get("drinks").getAsJsonArray();
            for( int i = 0; i < array.size(); i++ ){

                //int key = array.get(i).getAsJsonObject().get("idDrink").getAsInt();
                //PreparedStatement stmt = connection.prepareStatement("INSERT INTO Drink VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

                System.out.println( Objects.requireNonNullElse( array.get(i).getAsJsonObject().get("idDrink").getAsInt(), null ) );
                System.out.println( Objects.requireNonNullElse( array.get(i).getAsJsonObject().get("strDrink").getAsString(), null ) );
                System.out.println( Objects.requireNonNullElse( array.get(i).getAsJsonObject().get("strAlcoholic").getAsString(), null ) );
                System.out.println( Objects.requireNonNullElse( array.get(i).getAsJsonObject().get("strDrinkThumb").getAsString(), null ) );
                System.out.println( Objects.requireNonNullElse( array.get(i).getAsJsonObject().get("strInstructionsIT").getAsString(), null ) );

                System.out.println( Objects.requireNonNullElse( array.get(i).getAsJsonObject().get("strIngredient1").getAsString(), null ) );
                System.out.println( Objects.requireNonNullElse( array.get(i).getAsJsonObject().get("strIngredient2").getAsString(), null ) );
                System.out.println( Objects.requireNonNullElse( array.get(i).getAsJsonObject().get("strIngredient3").getAsString(), null ) );
                System.out.println( Objects.requireNonNullElse( array.get(i).getAsJsonObject().get("strIngredient4").getAsString(), null ) );
                System.out.println( Objects.requireNonNullElse( array.get(i).getAsJsonObject().get("strIngredient5").getAsString(), null ) );
                System.out.println( Objects.requireNonNullElse( array.get(i).getAsJsonObject().get("strIngredient6").getAsString(), null ) );
                System.out.println( Objects.requireNonNullElse( array.get(i).getAsJsonObject().get("strIngredient7").getAsString(), null ) );
                System.out.println( Objects.requireNonNullElse( array.get(i).getAsJsonObject().get("strIngredient8").getAsString(), null ) );
                System.out.println( Objects.requireNonNullElse( array.get(i).getAsJsonObject().get("strIngredient9").getAsString(), null ) );
                System.out.println( Objects.requireNonNullElse( array.get(i).getAsJsonObject().get("strIngredient10").getAsString(), null ) );
                System.out.println( Objects.requireNonNullElse( array.get(i).getAsJsonObject().get("strIngredient11").getAsString(), null ) );
                System.out.println( Objects.requireNonNullElse( array.get(i).getAsJsonObject().get("strIngredient12").getAsString(), null ) );
                System.out.println( Objects.requireNonNullElse( array.get(i).getAsJsonObject().get("strIngredient13").getAsString(), null ) );
                System.out.println( Objects.requireNonNullElse( array.get(i).getAsJsonObject().get("strIngredient14").getAsString(), null ) );
                System.out.println( Objects.requireNonNullElse( array.get(i).getAsJsonObject().get("strIngredient15").getAsString(), null ) );

                System.out.println( Objects.requireNonNullElse( array.get(i).getAsJsonObject().get("strMeasure1").getAsString(), null ) );
                System.out.println( Objects.requireNonNullElse( array.get(i).getAsJsonObject().get("strMeasure2").getAsString(), null ) );
                System.out.println( Objects.requireNonNullElse( array.get(i).getAsJsonObject().get("strMeasure3").getAsString(), null ) );
                System.out.println( Objects.requireNonNullElse( array.get(i).getAsJsonObject().get("strMeasure4").getAsString(), null ) );
                System.out.println( Objects.requireNonNullElse( array.get(i).getAsJsonObject().get("strMeasure5").getAsString(), null ) );
                System.out.println( Objects.requireNonNullElse( array.get(i).getAsJsonObject().get("strMeasure6").getAsString(), null ) );
                System.out.println( Objects.requireNonNullElse( array.get(i).getAsJsonObject().get("strMeasure7").getAsString(), null ) );
                System.out.println( Objects.requireNonNullElse( array.get(i).getAsJsonObject().get("strMeasure8").getAsString(), null ) );
                System.out.println( Objects.requireNonNullElse( array.get(i).getAsJsonObject().get("strMeasure9").getAsString(), null ) );
                System.out.println( Objects.requireNonNullElse( array.get(i).getAsJsonObject().get("strMeasure10").getAsString(), null ) );
                System.out.println( Objects.requireNonNullElse( array.get(i).getAsJsonObject().get("strMeasure11").getAsString(), null ) );
                System.out.println( Objects.requireNonNullElse( array.get(i).getAsJsonObject().get("strMeasure12").getAsString(), null ) );
                System.out.println( Objects.requireNonNullElse( array.get(i).getAsJsonObject().get("strMeasure13").getAsString(), null ) );
                System.out.println( Objects.requireNonNullElse( array.get(i).getAsJsonObject().get("strMeasure14").getAsString(), null ) );
                System.out.println( Objects.requireNonNullElse( array.get(i).getAsJsonObject().get("strMeasure15").getAsString(), null ) );


                break;
            }

        }

    }
}
