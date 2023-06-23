package com.example.petrescue.components;

import com.example.petrescue.dto.AnimalDTO;
import com.example.petrescue.event.ButtonEventHandlers;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class scrollBarDogElement extends HBox {
    //private ImageView imageView;
    //private Button button;
    private VBox imageAndButtonContainer;
    private Text text;

    public scrollBarDogElement(AnimalDTO dog, GridPane detailsContainer, EventHandler<ActionEvent> eventHandler) {
        ImageView imageView = new ImageView();
        if (!dog.photos().isEmpty()) {
            imageView.setImage(new Image(dog.photos().get(0).small()));
        }
        imageView.setFitWidth(100);
        imageView.setFitHeight(100);
        // Przycisk
        Button button = new Button("View details");
        button.setPrefWidth(100);
        button.setMaxHeight(30);

        button.setOnAction(eventHandler);

        imageAndButtonContainer = new VBox();
        imageAndButtonContainer.getChildren().addAll(imageView, button);

        // Krotki tekst
        text = new Text(dog.name());
        text.setStyle("-fx-font-size: 14px; -fx-font-weight: bold;");

        getChildren().add(imageAndButtonContainer);
        getChildren().add(text);
    }
}
