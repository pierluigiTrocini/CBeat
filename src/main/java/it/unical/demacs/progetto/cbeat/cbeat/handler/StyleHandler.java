package it.unical.demacs.progetto.cbeat.cbeat.handler;

import javafx.scene.control.TextField;
import javafx.scene.effect.BoxBlur;
import javafx.scene.layout.StackPane;
import org.kordamp.ikonli.javafx.FontIcon;

public class StyleHandler {
    private static StyleHandler instance = new StyleHandler();
    private StyleHandler() {}
    public static StyleHandler getInstance() {return instance;}

    private StackPane homepageClientStackPane;

    public void setHomepageClientStackPane(StackPane homepageClientStackPane) {
        this.homepageClientStackPane = homepageClientStackPane;
    }

    public void highlightAsError(TextField textField) {
        textField.setStyle("""
            -fx-border-color: red;
            -fx-border-width: 2px;
            """
        );
    }

    public FontIcon getIcon( String name, int size ){
        FontIcon icon = new FontIcon(name);
        icon.setIconSize(size);

        return icon;
    }

    public void setBlurEffect(){
        this.homepageClientStackPane.getChildren().get(
                this.homepageClientStackPane.getChildren().size() - 1
        ).setEffect(new BoxBlur( 15, 15,1 ));
    }

    public void removeBlurEffect(){
        this.homepageClientStackPane.getChildren().get(
                this.homepageClientStackPane.getChildren().size() - 1
        ).setEffect(null);
    }
}
