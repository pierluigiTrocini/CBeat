package it.unical.demacs.progetto.cbeat.cbeat.handler;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import it.unical.demacs.progetto.cbeat.cbeat.utility.Settings;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class APIHandler {
    private static APIHandler instance = new APIHandler();
    public APIHandler() {}
    public static APIHandler getInstance(){ return instance; }

    public JsonObject searchFromText( String content ) throws IOException{
        URLConnection request = ( new URL("https://www.thecocktaildb.com/api/json/v1/" + Settings.apikey + "/search.php?f=" + content)).openConnection();   // f -> first letter
        request.connect();

        JsonParser parser = new JsonParser();
        JsonElement root = parser.parse( new InputStreamReader( (InputStream) request.getContent()));
        return  root.getAsJsonObject();
    }
}
