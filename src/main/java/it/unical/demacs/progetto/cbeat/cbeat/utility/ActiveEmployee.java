package it.unical.demacs.progetto.cbeat.cbeat.utility;

public class ActiveEmployee {
    private String username;


    public static ActiveEmployee instance = new ActiveEmployee();

    public ActiveEmployee(){}

    public static ActiveEmployee getInstance() { return instance; }

    public void setUsername(String username){
        this.username=username;
    }


    public String getUsername(){
        return username;
    }
}
