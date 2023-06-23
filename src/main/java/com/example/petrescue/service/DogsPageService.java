package com.example.petrescue.service;

import com.example.petrescue.components.scrollBarDogElement;
import com.example.petrescue.dao.DogRepo;
import com.example.petrescue.dto.AnimalDTO;
import com.example.petrescue.event.ButtonEventHandlers;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.util.List;

public class DogsPageService {

    private static DogRepo dogRepo;

    public DogsPageService() {
        dogRepo = new DogRepo();
    }

    public void insertDogs(VBox dogListContainer, GridPane detailsContainer, int page) {
        List<AnimalDTO> dogList = DogsFetcher.getAnimals(DogsFetcher.changePage(page));

        for(AnimalDTO dog : dogList) {
            scrollBarDogElement itemHBox = new scrollBarDogElement(
                    dog,
                    detailsContainer,
                    event -> {
                ButtonEventHandlers.handleDetailsButtonEvent(event, detailsContainer, dog);
            });
            itemHBox.setAlignment(Pos.CENTER_LEFT);
            itemHBox.setSpacing(10);

            dogListContainer.getChildren().add(itemHBox);
        }
    }

    public void insertInterested(VBox dogListContainer, GridPane detailsContainer) {
        List<AnimalDTO> dogList = dogRepo.getDogs();

        for(AnimalDTO dog : dogList) {
            scrollBarDogElement itemHBox = new scrollBarDogElement(
                    dog,
                    detailsContainer,
                    event -> {
                ButtonEventHandlers.handleInterestedDetailsButtonEvent(event, detailsContainer, dog);
            });
            itemHBox.setAlignment(Pos.CENTER_LEFT);
            itemHBox.setSpacing(10);

            dogListContainer.getChildren().add(itemHBox);
        }
    }

    public void addInterested(AnimalDTO dog) {
        dogRepo.addDog(dog);
    }

    public void removeInterested(AnimalDTO dog) {
        dogRepo.removeDog(dog);
    }


}
