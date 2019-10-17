package AirVisual.Controller.Draw;

import AirVisual.Controller.AllEventHandler;
import AirVisual.Controller.NotificateAlert;
import AirVisual.Model.AqiData;
import AirVisual.Model.Forecast;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.scene.input.MouseEvent;

import java.util.ArrayList;

public class DrawNewPane {
    private static ArrayList<Node> allPane = new ArrayList<>();
    private DrawForecastTemp drawForecastTemp = new DrawForecastTemp();
    private static ArrayList<String> place = new ArrayList<>();
    private static ArrayList<Integer> data = new ArrayList<>();
    private NotificateAlert notificateAlert = new NotificateAlert();
    private static ArrayList<String> notice = new ArrayList<>();

    public void createNewPane(AqiData aqiData, Forecast forecast) {
        Pane mainPane = new Pane();
        mainPane.setPrefHeight(219);
        mainPane.setPrefWidth(312);

        FlowPane flowPane = new FlowPane();
        flowPane.setLayoutX(15);
        flowPane.setLayoutY(17);
        flowPane.setPrefHeight(177);
        flowPane.setPrefWidth(277);
        flowPane.setAlignment(Pos.BOTTOM_CENTER);
        flowPane.setStyle("-fx-background-radius: 7 7 7 7;-fx-background-color: lightgrey");

        Pane leftPane = new Pane();
        leftPane.prefHeight(200);
        leftPane.setPrefWidth(120);
        leftPane.setStyle("-fx-background-color: #" + aqiData.getDownColor() + "; -fx-background-radius: 7 0 0 7");

        Pane innerPane = new Pane();
        innerPane.prefHeight(34);
        innerPane.setPrefWidth(120);
        innerPane.setStyle("-fx-background-color: #" + aqiData.getHeadColor() + "; -fx-background-radius: 7 0 0 0");

        Label temp = new Label(aqiData.getWeather());
        temp.setLayoutX(80);
        temp.setLayoutY(6);
        temp.setPrefHeight(23);
        temp.setPrefWidth(29);
        temp.setTextFill(Color.WHITE);
        temp.setFont(new Font(18));

        Image image1 = new Image(getClass().getResourceAsStream(String.format("/AirVisual/assets/weather/%s", aqiData.getIcon())));
        ImageView icon = new ImageView(image1);
        icon.setFitHeight(26);
        icon.setFitWidth(27);
        icon.setLayoutX(10);
        icon.setLayoutY(5);
        icon.setPickOnBounds(true);
        icon.setPreserveRatio(true);

        Label unit = new Label("US AQI");
        unit.setAlignment(Pos.CENTER);
        unit.setContentDisplay(ContentDisplay.CENTER);
        unit.setLayoutY(173);
        unit.setPrefHeight(18);
        unit.setPrefWidth(120);
        unit.setTextAlignment(TextAlignment.CENTER);
        unit.setFont(new Font(10));

        Label aqi = new Label(Integer.toString(aqiData.getAqi()));
        aqi.setAlignment(Pos.CENTER);
        aqi.setContentDisplay(ContentDisplay.CENTER);
        aqi.setLayoutY(136);
        aqi.setPrefHeight(44);
        aqi.setPrefWidth(120);
        aqi.setTextAlignment(TextAlignment.CENTER);
        aqi.setFont(new Font(36));

        Label quality = new Label(aqiData.getQuality());
        quality.setAlignment(Pos.CENTER);
        quality.setContentDisplay(ContentDisplay.CENTER);
        quality.setLayoutY(34);
        quality.setPrefHeight(45);
        quality.setPrefWidth(120);
        quality.setTextAlignment(TextAlignment.CENTER);
        quality.setFont(new Font(18));

        Image image2 = new Image(getClass().getResourceAsStream(String.format("/AirVisual/assets/face/%s", aqiData.getFace())));
        ImageView face = new ImageView(image2);
        face.setFitHeight(65);
        face.setFitWidth(65);
        face.setLayoutX(27);
        face.setLayoutY(77);
        face.setPickOnBounds(true);
        face.setPreserveRatio(true);

        Image image3 = new Image(getClass().getResourceAsStream("/AirVisual/assets/clear/delete.png"));
        ImageView trash = new ImageView(image3);
        trash.setFitHeight(15);
        trash.setFitWidth(15);
        trash.setLayoutX(135);
        trash.setLayoutY(6);
        trash.setPickOnBounds(true);
        trash.setPreserveRatio(true);
        trash.setStyle("-fx-background-color:transparent");

        //Trash click
        trash.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            AllEventHandler.onDelete(trash.getParent().getParent().getParent());
            event.consume();
        });

        //Trash mouse over
        trash.setOnMouseEntered(event -> trash.setImage(new Image(getClass().getResourceAsStream("/AirVisual/assets/clear/clear.png"))));

        //Trash mouse exit
        trash.setOnMouseExited(event -> trash.setImage(new Image(getClass().getResourceAsStream("/AirVisual/assets/clear/delete.png"))));

        Pane rightPane = new Pane();
        rightPane.setPrefHeight(200);
        rightPane.setPrefWidth(157);
        rightPane.setStyle("-fx-background-color: white; -fx-background-radius: 0 7 7 0");

        Label mainLocation = new Label(aqiData.getMainLocation());
        mainLocation.setLayoutX(8);
        mainLocation.setLayoutY(5);
        mainLocation.setPrefHeight(17);
        mainLocation.setPrefWidth(143);
        mainLocation.setWrapText(true);
        mainLocation.setFont(new Font(18));

        Label subLocation = new Label(aqiData.getLocation());
        subLocation.setLayoutX(8);
        subLocation.setLayoutY(27);
        subLocation.setPrefHeight(35);
        subLocation.setPrefWidth(132);
        subLocation.setWrapText(true);
        subLocation.setAlignment(Pos.TOP_LEFT);
        subLocation.setTextFill(Paint.valueOf("#7d90a8"));

        drawForecastTemp.createNewForecast(forecast);

        rightPane.getChildren().addAll(mainLocation, subLocation, trash, drawForecastTemp.getForecastPane());

        innerPane.getChildren().addAll(icon, temp);

        leftPane.getChildren().addAll(innerPane, unit, aqi, quality, face);

        flowPane.getChildren().addAll(leftPane, rightPane);

        mainPane.getChildren().add(flowPane);

        allPane.add(mainPane);

        place.add(aqiData.getLocation());

        data.add(aqiData.getAqi());
    }

    public static ArrayList<Node> getAllPane() {
        return allPane;
    }

    public static ArrayList<String> getPlace() {
        return place;
    }

    public static ArrayList<Integer> getData() {
        return data;
    }
}
