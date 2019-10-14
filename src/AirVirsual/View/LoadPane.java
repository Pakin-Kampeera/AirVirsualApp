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
    private DrawButtonPane buttonPane = new DrawButtonPane();
    private FetchData fetchData = new FetchData();
    public AnchorPane anchorPane;
    public VBox vBox;

    public LoadPane() {

    }

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
    }

    public void loadWidget() {
        for (int i = 0; i < DrawNewPane.getAllPane().size(); i++) {
            vBox.getChildren().add(DrawNewPane.getAllPane().get(i));
        }
        anchorPane.getChildren().add(vBox);
        vBox.getChildren().add(buttonPane.createButtonPane());
        Main.scrollPane.setContent(anchorPane);
    }

    public void startToFetch() throws IOException {
        fetchData.fetch("Bangkok", "Bangkok", "Thailand");
        fetchData.fetch("Phuket", "Phuket", "Thailand");
        fetchData.fetch("Chiang Mai", "Chiang Mai", "Thailand");
    }


}
