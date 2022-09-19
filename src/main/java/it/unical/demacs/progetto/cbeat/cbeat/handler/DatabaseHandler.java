package it.unical.demacs.progetto.cbeat.cbeat.handler;

public class DatabaseHandler {
    private static DatabaseHandler instance = new DatabaseHandler();
    public DatabaseHandler() {}
    public static DatabaseHandler getInstance() { return instance; }

    
}
