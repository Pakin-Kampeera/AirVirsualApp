package AirVisual.View;

import AirVisual.Controller.AllEventHandler;
import AirVisual.Controller.Main;
import AirVisual.Controller.NotificateAlert;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;

public class Notication {
    private static Pane top;
    private static ImageView back;
    private static Label header;
    private static Button clear;
    private static VBox data;
    private static Pane pane;
    private static Label text;
    private static NotificateAlert notificateAlert = new NotificateAlert();

    public void notificatonPage() {

        header = new Label("Notifications");
        header.setLayoutX(108);
        header.setLayoutY(17);
        header.setFont(new Font(18));

        clear = new Button("CLEAR");
        clear.setLayoutX(242);
        clear.setLayoutY(16);
        clear.setMnemonicParsing(false);
        clear.setStyle("-fx-background-color: transparent");

        clear.setOnMouseClicked(event -> {
            LoadPane.getBadge().setStyle("-fx-background-color: transparent");
            LoadPane.getBadge().setText("");

            data.getChildren().removeAll(text);
            text.setText("");
        });

        clear.setOnMouseEntered(event -> clear.setTextFill(Paint.valueOf("#A8A5A5")));

        clear.setOnMouseExited(event -> clear.setTextFill(Paint.valueOf("#000000")));

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

        pane = new Pane();
        pane.setPrefHeight(402);
        pane.setPrefWidth(501);

        text = new Label("Tokyo, Japan should avoid outdoor activity");
        text.setAlignment(Pos.TOP_LEFT);
        text.setPrefHeight(41);
        text.setPrefWidth(278);
        text.setWrapText(true);

        data = new VBox();
        data.setLayoutX(24);
        data.setLayoutY(20);
        data.setPrefHeight(408);
        data.setPrefWidth(263);

        top.getChildren().addAll(back, header, clear);
        data.getChildren().addAll(text);
        pane.getChildren().add(data);
        Main.borderPane.setTop(top);
        Main.borderPane.setCenter(pane);
    }
}
