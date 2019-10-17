package AirVisual.View;

import AirVisual.Controller.AllEventHandler;
import AirVisual.Controller.Draw.DrawButtonPane;
import AirVisual.Controller.Draw.DrawNewPane;
import AirVisual.Controller.NotificateAlert;
import AirVisual.Controller.FetchData;
import AirVisual.Controller.Main;
import javafx.geometry.Pos;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;

import java.io.IOException;
import java.text.ParseException;

public class LoadPane {
    private static DrawButtonPane buttonPane;
    private static FetchData fetchData;
    private static Pane buttonAreaPane, top, bottom;
    private static AnchorPane anchorPane;
    private static ScrollPane scrollPane;
    private static ImageView search, logo, notification, menu;
    private static Label badge, text;
    private static ImageView air, earth, user, list, cart;
    private NotificateAlert notificateAlert = new NotificateAlert();
    public static VBox vBox;

    public void loadHeader() {
        buttonAreaPane = new Pane();
        fetchData = new FetchData();
        buttonPane = new DrawButtonPane();

        top = new Pane();
        top.setPrefHeight(49);
        top.setPrefWidth(311);

        text = new Label("My Air");
        text.setLayoutX(23);
        text.setLayoutY(35);
        text.setFont(new Font(10));
        text.setTextFill(Paint.valueOf("#48739A"));

        air = new ImageView(new Image(getClass().getResourceAsStream("/AirVisual/assets/bottom/chat.png")));
        air.setFitHeight(30);
        air.setFitWidth(30);
        air.setLayoutX(22);
        air.setLayoutY(5);

        earth = new ImageView(new Image(getClass().getResourceAsStream("/AirVisual/assets/bottom/world.png")));
        earth.setFitHeight(30);
        earth.setFitWidth(30);
        earth.setLayoutX(78);
        earth.setLayoutY(5);

        user = new ImageView(new Image(getClass().getResourceAsStream("/AirVisual/assets/bottom/user.png")));
        user.setFitHeight(40);
        user.setFitWidth(40);
        user.setLayoutX(136);
        user.setLayoutY(5);

        list = new ImageView(new Image(getClass().getResourceAsStream("/AirVisual/assets/bottom/list.png")));
        list.setFitHeight(30);
        list.setFitWidth(30);
        list.setLayoutX(201);
        list.setLayoutY(5);

        cart = new ImageView(new Image(getClass().getResourceAsStream("/AirVisual/assets/bottom/cart.png")));
        cart.setFitHeight(30);
        cart.setFitWidth(30);
        cart.setLayoutX(254);
        cart.setLayoutY(5);

        bottom = new Pane();
        bottom.setPrefHeight(49);
        bottom.setPrefWidth(311);

        search = new ImageView(new Image(getClass().getResourceAsStream("/AirVisual/assets/header/search.png")));
        search.setFitHeight(20);
        search.setFitWidth(20);
        search.setLayoutX(18);
        search.setLayoutY(19);
        search.setPickOnBounds(true);
        search.setPreserveRatio(true);

        logo = new ImageView(new Image(getClass().getResourceAsStream("/AirVisual/assets/header/logo.png")));
        logo.setFitHeight(39);
        logo.setFitWidth(93);
        logo.setLayoutX(109);
        logo.setLayoutY(10);
        logo.setPickOnBounds(true);
        logo.setPreserveRatio(true);

        notification = new ImageView(new Image(getClass().getResourceAsStream("/AirVisual/assets/header/notification.png")));
        notification.setFitHeight(23);
        notification.setFitWidth(23);
        notification.setLayoutX(230);
        notification.setLayoutY(17);
        notification.setPickOnBounds(true);
        notification.setPreserveRatio(true);

        //Click notification icon to go to notification scene
        notification.setOnMouseClicked(event -> AllEventHandler.onNotification());

        menu = new ImageView(new Image(getClass().getResourceAsStream("/AirVisual/assets/header/menu.png")));
        menu.setFitHeight(23);
        menu.setFitWidth(23);
        menu.setLayoutX(270);
        menu.setLayoutY(17);
        menu.setPickOnBounds(true);
        menu.setPreserveRatio(true);

        badge = new Label("20");
        badge.setLayoutX(243);
        badge.setLayoutY(11);
        badge.setPrefWidth(18);
        badge.setPrefHeight(18);
        badge.setAlignment(Pos.CENTER);
        badge.setContentDisplay(ContentDisplay.CENTER);
        badge.setStyle("-fx-background-color: red; -fx-background-radius: 20 20 20 20");
        badge.setTextFill(Color.WHITE);
        badge.setFont(new Font(10));

        scrollPane = new ScrollPane();
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scrollPane.setPrefHeight(470);
        scrollPane.setPrefWidth(311);

        anchorPane = new AnchorPane();
        anchorPane.setPrefWidth(309);

        vBox = new VBox();
        vBox.setAlignment(Pos.CENTER);
        vBox.setPrefWidth(309);
    }

    public void loadWidget() {
        for (int i = 0; i < DrawNewPane.getAllPane().size(); i++) {
            vBox.getChildren().add(DrawNewPane.getAllPane().get(i));
        }
        System.out.println(DrawNewPane.getAllPane());

        buttonAreaPane = buttonPane.createButtonPane();

        vBox.getChildren().add(buttonAreaPane);
    }

    public void loadButton() {

        anchorPane.getChildren().add(vBox);

        scrollPane.setContent(anchorPane);

        top.getChildren().addAll(search, logo, notification, menu, badge);

        bottom.getChildren().addAll(air, earth, user, list, cart, text);

        Main.borderPane = new BorderPane();

        Main.borderPane.setCenter(scrollPane);
        Main.borderPane.setTop(top);
        Main.borderPane.setBottom(bottom);
    }

    public void showNotification() {
        notificateAlert.show();
        badge.setText(Integer.toString(notificateAlert.getCountBadge()));
        badge.setStyle("-fx-background-color: red; -fx-background-radius: 20 20 20 20");
    }

    public void startToFetch(String city, String state, String country) throws IOException, ParseException {
        fetchData.fetch(city, state, country);
    }

    public static Pane getButtonAreaPane() {
        return buttonAreaPane;
    }

    public static ScrollPane getScrollPane() {
        return scrollPane;
    }

    public static Pane getTop() {
        return top;
    }

    public static Label getBadge() {
        return badge;
    }
}
