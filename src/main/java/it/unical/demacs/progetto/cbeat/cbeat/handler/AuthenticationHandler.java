package it.unical.demacs.progetto.cbeat.cbeat.handler;

public class AuthenticationHandler {

    private static AuthenticationHandler instance = new AuthenticationHandler();
    public AuthenticationHandler(){}
    public static AuthenticationHandler getInstance() { return instance; }

    public boolean accountAuth( String username, String password ){

       return  CheckUsernamePasswordCombo(username,password);

    }

    public Boolean CheckUsernamePasswordCombo(String username,String password){
        return DatabaseHandler.getInstance().CorrectUserPass(username,password);


    }


}
