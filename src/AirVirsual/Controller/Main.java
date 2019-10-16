package AirVirsual.Controller;

import AirVirsual.View.LoadPane;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    private static Scene mainScene;
    public static BorderPane borderPane;
    private LoadPane loadPane;

    @Override
    public void start(Stage primaryStage) throws IOException {
        primaryStage.setTitle("AirVirsual");
        initMainPane();
        mainScene = new Scene(borderPane);
        primaryStage.setScene(mainScene);
        primaryStage.setResizable(false);
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
