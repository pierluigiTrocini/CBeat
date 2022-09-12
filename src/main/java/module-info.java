module it.unical.demacs.progetto.cbeat.cbeat {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.ikonli.javafx;

    requires java.net.http;

    opens it.unical.demacs.progetto.cbeat.cbeat to javafx.fxml;
    exports it.unical.demacs.progetto.cbeat.cbeat;
}