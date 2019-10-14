package AirVirsual.Controller.Draw;

import AirVirsual.Controller.AllEventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

public class DrawButtonPane {
    private Pane subPane;
    private Button button1, button2;

    public DrawButtonPane(){ }

    public Pane createButtonPane(){
        subPane = new Pane();
        subPane.setPrefHeight(66);
        subPane.setPrefWidth(312);

        button1 = new Button("Add Place");
        button1.setLayoutX(16);
        button1.setLayoutY(20);
        button1.setMnemonicParsing(false);
        button1.setPrefHeight(27);
        button1.setPrefWidth(131);
        button1.setOnAction(actionEvent -> {
            AllEventHandler.onAdd();
        });

        button2 = new Button("Manage Place");
        button2.setLayoutX(159);
        button2.setLayoutY(20);
        button2.setMnemonicParsing(false);
        button2.setPrefHeight(27);
        button2.setPrefWidth(131);

        subPane.getChildren().addAll(button1, button2);

        return subPane;
    }
}
