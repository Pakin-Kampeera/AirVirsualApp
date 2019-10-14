package AirVirsual.View;

import AirVirsual.Controller.Draw.DrawButtonPane;
import AirVirsual.Controller.Draw.DrawNewPane;
import AirVirsual.Controller.FetchData;
import AirVirsual.Controller.Main;
import javafx.geometry.Pos;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class LoadPane {
    private static DrawButtonPane buttonPane = new DrawButtonPane();
    private FetchData fetchData = new FetchData();

    public LoadPane() {

    }

    public void initialLoadPane() throws IOException {
        Main.scrollPane = new ScrollPane();
        Main.scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        Main.scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        Main.scrollPane.setPrefHeight(539);
        Main.scrollPane.setPrefWidth(311);
        Main.scrollPane.setStyle("-fx-background-color: lightgrey");

        Main.anchorPane = new AnchorPane();
        Main.anchorPane.setStyle("-fx-background-color: lightgrey");

        Main.vBox = new VBox();
        Main.vBox.setAlignment(Pos.CENTER);
        Main.vBox.setPrefWidth(309);
        Main.vBox.setStyle("-fx-background-color: lightgrey");

        loadWidget();

        Main.anchorPane.getChildren().add(Main.vBox);
        Main.vBox.getChildren().add(buttonPane.createButtonPane());
        Main.scrollPane.setContent(Main.anchorPane);
    }

    public void loadWidget() throws IOException {
        startToFetch();
        for(int i = 0; i < DrawNewPane.getAllPane().size(); i++){
            Main.vBox.getChildren().add(DrawNewPane.getAllPane().get(i));
        }
    }

    public void startToFetch() throws IOException {
        fetchData.fetch("Bangkok", "Bangkok", "Thailand");
        fetchData.fetch("Phuket", "Phuket", "Thailand");
        fetchData.fetch("Chiang Mai", "Chiang Mai", "Thailand");
    }
}
