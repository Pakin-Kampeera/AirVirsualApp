package AirVisual.Controller;

import AirVisual.Controller.Draw.DrawNewPane;
import AirVisual.Model.AqiData;
import AirVisual.Model.FetchData;
import AirVisual.View.LoadPane;
import AirVisual.View.Notication;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

import java.io.IOException;
import java.text.ParseException;
import java.util.Optional;

public class AllEventHandler {
    private static FetchData fetchData = new FetchData();
    private static Notication notication = new Notication();
    private static LoadPane loadPane = new LoadPane();
    private static NotificateAlert notificateAlert = new NotificateAlert();

    public static void onAdd() {
        try {
            Dialog<Results> dialog = new Dialog<>();
            dialog.setTitle("Add Place");

            DialogPane dialogPane = dialog.getDialogPane();
            dialogPane.getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);

            GridPane gridPane = new GridPane();
            gridPane.setHgap(10);
            gridPane.setVgap(10);
            gridPane.setPadding(new Insets(20, 10, 10, 10));

            TextField city = new TextField();
            city.setPromptText("City");
            TextField state = new TextField();
            state.setPromptText("State");
            TextField country = new TextField();
            country.setPromptText("Country");

            gridPane.add(new Label("City: "), 0, 0);
            gridPane.add(city, 1, 0);
            gridPane.add(new Label("State: "), 0, 1);
            gridPane.add(state, 1, 1);
            gridPane.add(new Label("Country: "), 0, 2);
            gridPane.add(country, 1, 2);

            dialog.getDialogPane().setContent(gridPane);

            Platform.runLater(() -> city.requestFocus());

            dialog.setResultConverter(dialogButton -> {
                if (dialogButton == ButtonType.OK) {
                    return new AllEventHandler.Results(city.getText(), state.getText(), country.getText());
                }
                return null;
            });

            Optional<Results> optionalResult = dialog.showAndWait();

            optionalResult.ifPresent((AllEventHandler.Results results) -> {
                System.out.println("City = " +
                        results.city + ", State = " + results.state + ", Country = " + results.country);
                try {
                    fetchData.fetch(results.city, results.state, results.country);
                    for (int i = 0; i < DrawNewPane.getAllPane().size(); i++) {
                        LoadPane.vBox.getChildren().removeAll(DrawNewPane.getAllPane().get(i));
                    }
                    LoadPane.vBox.getChildren().removeAll(LoadPane.getButtonAreaPane());
                    loadPane.loadWidget();
                    NotificateAlert.getMessage().clear();
                    NotificateAlert.setCountBadge(0);
                    loadPane.showNotification();
                } catch (Exception e) {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Invalid Place");
                    alert.setHeaderText(null);
                    alert.setContentText("This place not exist!");
                    alert.showAndWait();
                    onAdd();
                    e.printStackTrace();
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void onDelete(Parent parent) {
        Alert alert = new Alert(Alert.AlertType.NONE);
        alert.setTitle("Confirmation");
        alert.setContentText("Do you really want to delete this?");
        alert.getButtonTypes().addAll(ButtonType.NO, ButtonType.YES);

        alert.showAndWait().ifPresent(response -> {
            if (response == ButtonType.YES) {
                LoadPane.vBox.getChildren().removeAll(parent);
                DrawNewPane.getAllPane().remove(parent);
                System.out.println(DrawNewPane.getAllPane());
            }
        });
    }

    public static void onNotification() {
        notication.notificatonPage();
    }

    public static void onBack() {
        Main.borderPane.setTop(LoadPane.getTop());
        Main.borderPane.setCenter(LoadPane.getScrollPane());
    }

    public static void onRefresh() throws IOException, ParseException, InterruptedException {
        int count = AqiData.getCity().size();
        for (int i = 0; i < count; i++) {
            LoadPane.vBox.getChildren().removeAll(DrawNewPane.getAllPane().get(i));
        }
        DrawNewPane.getAllPane().clear();
        LoadPane.vBox.getChildren().removeAll(LoadPane.getButtonAreaPane());
        for (int i = 0; i < count; i++) {
            loadPane.startToFetch(AqiData.getCity().get(i), AqiData.getState().get(i), AqiData.getCountry().get(i));
            Thread.sleep(3000);
        }
        loadPane.loadWidget();
        loadPane.showNotification();
    }

    private static class Results {
        String city, state, country;

        private Results(String city, String state, String country) {
            this.city = city;
            this.state = state;
            this.country = country;
        }
    }
}
