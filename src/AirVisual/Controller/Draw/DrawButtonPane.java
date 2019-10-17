package AirVisual.Controller.Draw;

import AirVisual.Controller.AllEventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;

import java.io.IOException;
import java.text.ParseException;

public class DrawButtonPane {
    private Pane subPane;
    private Button button1, button2;

    public Pane createButtonPane() {
        subPane = new Pane();
        subPane.setPrefHeight(66);
        subPane.setPrefWidth(312);

        button1 = new Button("ADD PLACE");
        button1.setLayoutX(16);
        button1.setLayoutY(16);
        button1.setMnemonicParsing(false);
        button1.setPrefHeight(40);
        button1.setPrefWidth(131);
        button1.setFocusTraversable(false);
        button1.setTextFill(Paint.valueOf("#4E8ABE"));
        button1.setStyle("-fx-background-color: transparent; -fx-border-color: lightgrey; -fx-border-radius: 5 5 5 5;");

        //Add place click
        button1.setOnAction(event -> AllEventHandler.onAdd());

        //Button text color changed
        button1.setOnMouseEntered(event -> button1.setTextFill(Paint.valueOf("#303030")));

        //Button text color changed
        button1.setOnMouseExited(event -> button1.setTextFill(Paint.valueOf("#4E8ABE")));

        button2 = new Button("REFRESH");
        button2.setLayoutX(159);
        button2.setLayoutY(16);
        button2.setMnemonicParsing(false);
        button2.setPrefHeight(40);
        button2.setPrefWidth(131);
        button2.setFocusTraversable(false);
        button2.setTextFill(Paint.valueOf("#4E8ABE"));
        button2.setStyle("-fx-background-color: transparent; -fx-border-color: lightgrey; -fx-border-radius: 5 5 5 5;");

        //Refresh click
        button2.setOnAction(event -> {
            try {
                AllEventHandler.onRefresh();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ParseException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        //Button text color changed
        button2.setOnMouseEntered(event -> button2.setTextFill(Paint.valueOf("#303030")));

        //Button text color changed
        button2.setOnMouseExited(event -> button2.setTextFill(Paint.valueOf("#4E8ABE")));

        subPane.getChildren().addAll(button1, button2);

        return subPane;
    }
}
