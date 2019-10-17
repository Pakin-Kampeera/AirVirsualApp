package AirVisual.View;

import AirVisual.Controller.AllEventHandler;
import AirVisual.Controller.Main;
import AirVisual.Controller.NotificateAlert;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;

public class Notification {
    private static Pane top;
    private static ImageView back;
    private static Label header;
    private static Button clear;
    private static VBox data;
    private static AnchorPane anchorPane;
    private static ScrollPane scrollPane;
    private static Label text;

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

        //Click to clear all notification
        clear.setOnMouseClicked(event -> {
            LoadPane.getBadge().setStyle("-fx-background-color: transparent");
            LoadPane.getBadge().setText("");

            NotificateAlert.getMessage().clear();
            NotificateAlert.setCountBadge(0);
            System.out.println(NotificateAlert.getMessage());
            notificatonPage();
        });

        //Button text color changed
        clear.setOnMouseEntered(event -> clear.setTextFill(Paint.valueOf("#A8A5A5")));

        //Button text color changed
        clear.setOnMouseExited(event -> clear.setTextFill(Paint.valueOf("#000000")));

        back = new ImageView(new Image(getClass().getResourceAsStream("/AirVisual/assets/header/back.png")));
        back.setFitHeight(18);
        back.setFitWidth(18);
        back.setLayoutX(18);
        back.setLayoutY(21);
        back.setPickOnBounds(true);
        back.setPreserveRatio(true);

        //Click to go back to main scene
        back.setOnMouseClicked(event -> AllEventHandler.onBack());

        top = new Pane();
        top.setPrefHeight(49);
        top.setPrefWidth(311);

        scrollPane = new ScrollPane();
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scrollPane.setPrefWidth(200);
        scrollPane.setPrefHeight(311);

        anchorPane = new AnchorPane();
        anchorPane.setPrefWidth(309);

        data = new VBox();
        data.setLayoutX(24);
        data.setLayoutY(20);
        data.setPrefHeight(408);
        data.setPrefWidth(263);

        showMessage();

        top.getChildren().addAll(back, header, clear);
        anchorPane.getChildren().add(data);
        scrollPane.setContent(anchorPane);
        Main.borderPane.setTop(top);
        Main.borderPane.setCenter(scrollPane);
    }

    public void showMessage() {
        for (int i = 0; i < NotificateAlert.getMessage().size(); i++) {
            text = new Label(NotificateAlert.getMessage().get(i));
            text.setAlignment(Pos.TOP_LEFT);
            text.setPrefHeight(41);
            text.setPrefWidth(278);
            text.setWrapText(true);
            data.getChildren().add(text);
        }
    }
}
