package it.unical.demacs.progetto.cbeat.cbeat.utility;

import org.mindrot.jbcrypt.BCrypt;

public class PasswordEncrypter
{

    public static PasswordEncrypter instance = new PasswordEncrypter();

    public PasswordEncrypter(){}

    public static PasswordEncrypter getInstance() { return instance; }


    public String EncryptPassword(String password){
        String encryptedPassword = BCrypt.hashpw(password, BCrypt.gensalt(12));
        return encryptedPassword;

    }
}
