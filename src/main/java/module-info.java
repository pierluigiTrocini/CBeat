module it.unical.demacs.progetto.cbeat.cbeat {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.ikonli.javafx;
    requires com.google.gson;
    requires org.xerial.sqlitejdbc;
    requires java.sql;



    requires java.net.http;


    opens it.unical.demacs.progetto.cbeat.cbeat to javafx.fxml;
    exports it.unical.demacs.progetto.cbeat.cbeat;
    exports it.unical.demacs.progetto.cbeat.cbeat.controller;
    opens it.unical.demacs.progetto.cbeat.cbeat.controller to javafx.fxml;
}