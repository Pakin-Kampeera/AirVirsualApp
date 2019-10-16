package AirVisual.View;

import AirVisual.Controller.AllEventHandler;
import AirVisual.Controller.Main;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;

public class Notication {
    private static Pane top, center;
    private static ImageView back;
    private static Label text;
    private static Button clear;

    public void notificatonPage() {

        text = new Label("Notifications");
        text.setLayoutX(108);
        text.setLayoutY(17);
        text.setFont(new Font(18));

        clear = new Button("CLEAR");
        clear.setLayoutX(242);
        clear.setLayoutY(16);
        clear.setMnemonicParsing(false);
        clear.setStyle("-fx-background-color: transparent");

        clear.setOnMouseClicked(event -> {
            LoadPane.getBadge().setStyle("-fx-background-color: transparent");
            LoadPane.getBadge().setText("");
        });

        clear.setOnMousePressed(event -> clear.setTextFill(Paint.valueOf("#A8A5A5")));

        clear.setOnMouseReleased(event -> clear.setTextFill(Paint.valueOf("#000000")));

        back = new ImageView(new Image(getClass().getResourceAsStream("/AirVisual/assets/header/back.png")));
        back.setFitHeight(18);
        back.setFitWidth(18);
        back.setLayoutX(18);
        back.setLayoutY(21);
        back.setPickOnBounds(true);
        back.setPreserveRatio(true);

        back.setOnMouseClicked(event -> AllEventHandler.onBack());

        top = new Pane();
        top.setPrefHeight(49);
        top.setPrefWidth(311);

        center = new Pane();
        center.setPrefHeight(200);
        center.setPrefWidth(200);

        top.getChildren().addAll(back, text, clear);
        Main.borderPane.setTop(top);
        Main.borderPane.setCenter(center);
    }
}
