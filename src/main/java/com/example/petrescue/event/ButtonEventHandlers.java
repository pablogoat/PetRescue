package com.example.petrescue.event;

import com.example.petrescue.controller.DogsPageController;
import com.example.petrescue.dto.AnimalDTO;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class ButtonEventHandlers {
    public static void handleDetailsButtonEvent(ActionEvent event, GridPane detailsContainer, AnimalDTO dog){
        detailsContainer.getChildren().clear();
        // Obrazek na górze
        ImageView bigImageView = new ImageView();
        bigImageView.setFitWidth(300); // Szerokość obrazka
        bigImageView.setFitHeight(300); // Wysokość obrazka

        if(!dog.photos().isEmpty()) {
            bigImageView.setImage(new Image(dog.photos().get(0).medium()));
        }

// Dodaj obrazek do pierwszego wiersza
        detailsContainer.add(bigImageView, 0, 0, 1, 1); // columnIndex, rowIndex, columnSpan, rowSpan

// Tworzenie etykiet i wartości
        Label ageLabel = new Label("Age:");
        Label ageValueLabel = new Label(dog.age());

        Label genderLabel = new Label("Gender:");
        Label genderValueLabel = new Label(dog.gender());

        Label sizeLabel = new Label("Size:");
        Label sizeValueLabel = new Label(dog.size());

        Label coatLabel = new Label("Coat:");
        Label coatValueLabel = new Label(dog.coat());

        Label nameLabel = new Label("Name:");
        Label nameValueLabel = new Label(dog.name());

        Label descriptionLabel = new Label("Description:");
        Label descriptionValueLabel = new Label(dog.description());

        Label environmentLabel = new Label("Environment to avoid:");
        Label environmentValueLabel = new Label(dog.environment().toString());

        Label contactLabel = new Label("Contact:");
        Label contactValueLabel = new Label(dog.contact().toString());

// Dodaj etykiety i wartości do kolejnych wierszy
        detailsContainer.addRow(1, ageLabel, ageValueLabel);
        detailsContainer.addRow(2, genderLabel, genderValueLabel);
        detailsContainer.addRow(3, sizeLabel, sizeValueLabel);
        detailsContainer.addRow(4, coatLabel, coatValueLabel);
        detailsContainer.addRow(5, nameLabel, nameValueLabel);
        detailsContainer.addRow(6, descriptionLabel, descriptionValueLabel);
        detailsContainer.addRow(7, environmentLabel, environmentValueLabel);
        detailsContainer.addRow(8, contactLabel, contactValueLabel);

// Przycisk na dole
        Button bottomButton = new Button("Interested");

        bottomButton.setOnAction(interestedEvent -> DogsPageController.addInterested(dog));

// Dodaj przycisk na ostatnim wierszu
        detailsContainer.add(bottomButton, 0, 9, 2, 1); // columnIndex, rowIndex, columnSpan, rowSpan
    }

    public static void handleInterestedDetailsButtonEvent(ActionEvent event, GridPane detailsContainer, AnimalDTO dog){
        detailsContainer.getChildren().clear();
        // Obrazek na górze
        ImageView bigImageView = new ImageView();
        bigImageView.setFitWidth(300); // Szerokość obrazka
        bigImageView.setFitHeight(300); // Wysokość obrazka

        if(!dog.photos().isEmpty()) {
            bigImageView.setImage(new Image(dog.photos().get(0).medium()));
        }

// Dodaj obrazek do pierwszego wiersza
        detailsContainer.add(bigImageView, 0, 0, 1, 1); // columnIndex, rowIndex, columnSpan, rowSpan

// Tworzenie etykiet i wartości
        Label ageLabel = new Label("Age:");
        Label ageValueLabel = new Label(dog.age());

        Label genderLabel = new Label("Gender:");
        Label genderValueLabel = new Label(dog.gender());

        Label sizeLabel = new Label("Size:");
        Label sizeValueLabel = new Label(dog.size());

        Label coatLabel = new Label("Coat:");
        Label coatValueLabel = new Label(dog.coat());

        Label nameLabel = new Label("Name:");
        Label nameValueLabel = new Label(dog.name());

        Label descriptionLabel = new Label("Description:");
        Label descriptionValueLabel = new Label(dog.description());

        Label environmentLabel = new Label("Environment to avoid:");
        Label environmentValueLabel = new Label(dog.environment().toString());

        Label contactLabel = new Label("Contact:");
        Label contactValueLabel = new Label(dog.contact().toString());

// Dodaj etykiety i wartości do kolejnych wierszy
        detailsContainer.addRow(1, ageLabel, ageValueLabel);
        detailsContainer.addRow(2, genderLabel, genderValueLabel);
        detailsContainer.addRow(3, sizeLabel, sizeValueLabel);
        detailsContainer.addRow(4, coatLabel, coatValueLabel);
        detailsContainer.addRow(5, nameLabel, nameValueLabel);
        detailsContainer.addRow(6, descriptionLabel, descriptionValueLabel);
        detailsContainer.addRow(7, environmentLabel, environmentValueLabel);
        detailsContainer.addRow(8, contactLabel, contactValueLabel);

// Przycisk na dole
        Button bottomButton = new Button("Remove");

        bottomButton.setOnAction(interestedEvent -> DogsPageController.removeInterested(dog));

// Dodaj przycisk na ostatnim wierszu
        detailsContainer.add(bottomButton, 0, 9, 2, 1); // columnIndex, rowIndex, columnSpan, rowSpan
    }
}
