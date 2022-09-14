package it.unical.demacs.progetto.cbeat.cbeat.handler;

import java.util.regex.Pattern;

public class AuthenticationHandler {

    private static AuthenticationHandler instance = new AuthenticationHandler();
    public AuthenticationHandler(){}
    public static AuthenticationHandler getInstance() { return instance; }

}
