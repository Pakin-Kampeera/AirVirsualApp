package AirVisual.Controller.Draw;

import AirVisual.Controller.Forecast;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;


public class DrawForecastTemp {
    private Pane forecastPane;

    public void createNewForecast(Forecast forecast) {
        forecastPane = new Pane();
        forecastPane.setLayoutX(1);
        forecastPane.setLayoutY(44);
        forecastPane.setPrefHeight(156);
        forecastPane.setPrefWidth(157);

        Label max_temp1 = new Label(forecast.getMax_temp().get(0));
        max_temp1.setLayoutX(20);
        max_temp1.setLayoutY(59);

        Label min_temp1 = new Label(forecast.getMin_temp().get(0));
        min_temp1.setLayoutX(20);
        min_temp1.setLayoutY(85);

        Label day1 = new Label(forecast.getDay().get(0));
        day1.setLayoutX(20);
        day1.setLayoutY(34);

        Label max_temp2 = new Label(forecast.getMax_temp().get(1));
        max_temp2.setLayoutX(65);
        max_temp2.setLayoutY(59);

        Label min_temp2 = new Label(forecast.getMin_temp().get(1));
        min_temp2.setLayoutX(65);
        min_temp2.setLayoutY(85);

        Label day2 = new Label(forecast.getDay().get(1));
        day2.setLayoutX(65);
        day2.setLayoutY(34);

        Label max_temp3 = new Label(forecast.getMax_temp().get(2));
        max_temp3.setLayoutX(109);
        max_temp3.setLayoutY(59);

        Label min_temp3 = new Label(forecast.getMin_temp().get(2));
        min_temp3.setLayoutX(109);
        min_temp3.setLayoutY(85);

        Label day3 = new Label(forecast.getDay().get(2));
        day3.setLayoutX(109);
        day3.setLayoutY(34);

        Pane line1 = new Pane();
        line1.setLayoutX(51);
        line1.setLayoutY(37);
        line1.setPrefHeight(65);
        line1.setPrefWidth(1);
        line1.setStyle("-fx-background-color: #7d90a8");

        Pane line2 = new Pane();
        line2.setLayoutX(96);
        line2.setLayoutY(37);
        line2.setPrefHeight(65);
        line2.setPrefWidth(1);
        line2.setStyle("-fx-background-color: #7d90a8");

        forecastPane.getChildren().addAll(min_temp1, min_temp2, min_temp3, max_temp1, max_temp2, max_temp3, line1, line2, day1, day2, day3);
    }

    public Pane getForecastPane() {
        return forecastPane;
    }
}
