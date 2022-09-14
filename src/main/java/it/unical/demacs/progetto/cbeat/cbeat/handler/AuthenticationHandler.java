package it.unical.demacs.progetto.cbeat.cbeat.handler;

public class AuthenticationHandler {

    private static AuthenticationHandler instance = new AuthenticationHandler();
    public AuthenticationHandler(){}
    public static AuthenticationHandler getInstance() { return instance; }

    public boolean accountAuth( String email, String password ){
        return true;
    }


}
