package AirVirsual.Controller;

import AirVirsual.Controller.Draw.DrawNewPane;
import AirVirsual.View.LoadPane;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

import java.util.Optional;

public class AllEventHandler {
    private static FetchData fetchData = new FetchData();

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
                    LoadPane.loadWidget();
                } catch (Exception e) {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Invalid Place");
                    alert.setHeaderText(null);
                    alert.setContentText(String.format("%s, %s, %s is invalid!", results.city.substring(0, 1).toUpperCase() + results.city.substring(1), results.state.substring(0, 1).toUpperCase() + results.state.substring(1), results.country.substring(0, 1).toUpperCase() + results.country.substring(1)));
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

        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent()) {
            LoadPane.vBox.getChildren().removeAll(parent);
            DrawNewPane.getAllPane().remove(parent);
        }
    }

    public static void onRefresh() {
        for (int i = 0; i < DrawNewPane.getAllPane().size(); i++) {
            LoadPane.vBox.getChildren().removeAll(DrawNewPane.getAllPane().get(i));
        }
        LoadPane.vBox.getChildren().removeAll(LoadPane.getButtonAreaPane());
        LoadPane.loadWidget();
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
