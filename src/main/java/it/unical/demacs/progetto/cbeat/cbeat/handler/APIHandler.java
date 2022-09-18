package it.unical.demacs.progetto.cbeat.cbeat.handler;

import it.unical.demacs.progetto.cbeat.cbeat.model.Item;
import it.unical.demacs.progetto.cbeat.cbeat.utility.Settings;
import org.json.JSONObject;

import java.io.IOException;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.jar.JarException;

public class APIHandler {
    /* Classe singleton */
    private static APIHandler instance = new APIHandler();
    public APIHandler() {}
    public static APIHandler getInstance() { return instance; }

    public ArrayList<Item> initHomepage() throws IOException {
        ArrayList<Item> arrayList = new ArrayList<>();

        for( char alphabet = 'a'; alphabet <= 'z'; alphabet++ ){
            readFromURL( new URL( "https://www.thecocktaildb.com/api/json/v1/" + Settings.apikey + "/search.php?s=" + alphabet) );
        }
        return arrayList;
    }

    private static JSONObject readFromURL( URL url ) throws IOException, JarException{
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.connect();

        JSONObject object;
        StringBuilder builder;

        if( connection.getResponseCode() != 200 )
            throw new RuntimeException("Serve una grafica per questo [ codice: " + connection.getResponseCode() + "]");
        else{
            builder = new StringBuilder();

            Scanner scanner = new Scanner(url.openStream());
            while (scanner.hasNext())
                builder.append(scanner.nextLine());

            scanner.close();
        }

        object = new JSONObject(builder.toString());

        if( object != null ) return object;
        else throw new RuntimeException("[Debug] in private static JSONObject readFromURL( URL url ) - problemi nella creazione del jsonobject");

    }

}
