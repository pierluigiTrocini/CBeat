package it.unical.demacs.progetto.cbeat.cbeat.handler;

import javafx.scene.control.TextField;

public class StyleHandler {
    private static StyleHandler instance = new StyleHandler();

    public StyleHandler() {}

    public static StyleHandler getInstance() {return instance;}

    public void highlightAsError(TextField textField) {
        textField.setStyle("""
            -fx-border-color: red;
            -fx-border-width: 2px;
            """
        );
    }
}
