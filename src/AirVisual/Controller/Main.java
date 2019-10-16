package AirVisual.Controller;

import AirVisual.View.LoadPane;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.text.ParseException;

public class Main extends Application {
    private static Scene mainScene;
    public static BorderPane borderPane;
    private LoadPane loadPane;

    @Override
    public void start(Stage primaryStage) throws IOException, ParseException {
        primaryStage.setTitle("AirVisual");
        initMainPane();
        mainScene = new Scene(borderPane);
        primaryStage.setScene(mainScene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    private void initMainPane() throws IOException, ParseException {
        loadPane = new LoadPane();
        loadPane.loadHeader();
        loadPane.startToFetch("Bangkok", "Bangkok", "Thailand");
        loadPane.startToFetch("Phuket", "Phuket", "Thailand");
        loadPane.startToFetch("Chiang Mai", "Chiang Mai", "Thailand");
        loadPane.loadWidget();
        loadPane.loadButton();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
