package AirVirsual.Controller;

import AirVirsual.View.LoadPane;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    private static Scene mainScene;
    public static ScrollPane scrollPane;
    private LoadPane loadPane;

    @Override
    public void start(Stage primaryStage) throws IOException {
        primaryStage.setTitle("Air Virtual");
        initMainPane();
        mainScene = new Scene(scrollPane);
        primaryStage.setScene(mainScene);
        primaryStage.show();
    }

    private void initMainPane() throws IOException {
        loadPane = new LoadPane();
        loadPane.initialLoadPane();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
