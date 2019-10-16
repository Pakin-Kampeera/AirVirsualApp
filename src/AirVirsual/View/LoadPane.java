package AirVirsual.View;

import AirVirsual.Controller.Draw.DrawButtonPane;
import AirVirsual.Controller.Draw.DrawNewPane;
import AirVirsual.Controller.FetchData;
import AirVirsual.Controller.Main;
import javafx.geometry.Pos;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import java.io.IOException;

public class LoadPane {
    private static DrawButtonPane buttonPane;
    private static FetchData fetchData;
    private static Pane buttonAreaPane, top;
    private static AnchorPane anchorPane;
    private static ScrollPane scrollPane;
    private static ImageView search, logo, notification, menu;
    public static VBox vBox;

    public void initialLoadPane() throws IOException {
        buttonAreaPane = new Pane();
        fetchData = new FetchData();
        buttonPane = new DrawButtonPane();

        Main.borderPane = new BorderPane();

        top = new Pane();
        top.setPrefHeight(49);
        top.setPrefWidth(311);

        search = new ImageView(new Image(getClass().getResourceAsStream("/AirVirsual/assets/header/search.png")));
        search.setFitHeight(20);
        search.setFitWidth(20);
        search.setLayoutX(18);
        search.setLayoutY(19);
        search.setPickOnBounds(true);
        search.setPreserveRatio(true);

        logo = new ImageView(new Image(getClass().getResourceAsStream("/AirVirsual/assets/header/logo.png")));
        logo.setFitHeight(39);
        logo.setFitWidth(93);
        logo.setLayoutX(109);
        logo.setLayoutY(10);
        logo.setPickOnBounds(true);
        logo.setPreserveRatio(true);

        notification = new ImageView(new Image(getClass().getResourceAsStream("/AirVirsual/assets/header/notification.png")));
        notification.setFitHeight(23);
        notification.setFitWidth(23);
        notification.setLayoutX(230);
        notification.setLayoutY(17);
        notification.setPickOnBounds(true);
        notification.setPreserveRatio(true);

        menu = new ImageView(new Image(getClass().getResourceAsStream("/AirVirsual/assets/header/menu.png")));
        menu.setFitHeight(23);
        menu.setFitWidth(23);
        menu.setLayoutX(270);
        menu.setLayoutY(17);
        menu.setPickOnBounds(true);
        menu.setPreserveRatio(true);

        scrollPane = new ScrollPane();
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scrollPane.setPrefHeight(500);
        scrollPane.setPrefWidth(311);

        anchorPane = new AnchorPane();
        anchorPane.setPrefWidth(311);

        vBox = new VBox();
        vBox.setAlignment(Pos.CENTER);
        vBox.setPrefWidth(309);

        startToFetch();
        loadWidget();

        anchorPane.getChildren().add(vBox);
        scrollPane.setContent(anchorPane);
        top.getChildren().addAll(search, logo, notification, menu);
        Main.borderPane.setCenter(scrollPane);
        Main.borderPane.setTop(top);
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
