package AirVirsual.View;

import AirVirsual.Controller.Draw.DrawButtonPane;
import AirVirsual.Controller.Draw.DrawNewPane;
import AirVirsual.Controller.FetchData;
import AirVirsual.Controller.Main;
import javafx.geometry.Pos;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class LoadPane {
    private static DrawButtonPane buttonPane = new DrawButtonPane();
    private static FetchData fetchData = new FetchData();
    private static Pane buttonAreaPane = new Pane();
    private static AnchorPane anchorPane;
    public static VBox vBox;

    public void initialLoadPane() throws IOException {
        Main.scrollPane = new ScrollPane();
        Main.scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        Main.scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        Main.scrollPane.setPrefHeight(539);
        Main.scrollPane.setPrefWidth(311);
        Main.scrollPane.setStyle("-fx-background-color: lightgrey");

        anchorPane = new AnchorPane();
        anchorPane.setStyle("-fx-background-color: lightgrey");

        vBox = new VBox();
        vBox.setAlignment(Pos.CENTER);
        vBox.setPrefWidth(309);
        vBox.setStyle("-fx-background-color: lightgrey");

        startToFetch();
        loadWidget();

        anchorPane.getChildren().add(vBox);
        Main.scrollPane.setContent(anchorPane);
    }

    public static void loadWidget() {
        for (int i = 0; i < DrawNewPane.getAllPane().size(); i++) {
            vBox.getChildren().add(DrawNewPane.getAllPane().get(i));
        }
        buttonAreaPane = buttonPane.createButtonPane();
        vBox.getChildren().add(buttonAreaPane);
    }

    private static void startToFetch() throws IOException {
        fetchData.fetch("Bangkok", "Bangkok", "Thailand");
        fetchData.fetch("Phuket", "Phuket", "Thailand");
        fetchData.fetch("Chiang Mai", "Chiang Mai", "Thailand");
    }

    public static Pane getButtonAreaPane() {
        return buttonAreaPane;
    }
}
