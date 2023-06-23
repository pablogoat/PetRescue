package com.example.petrescue.controller;

import com.example.petrescue.dto.AnimalDTO;
import com.example.petrescue.service.DogsFetcher;
import com.example.petrescue.service.DogsPageService;
import com.example.petrescue.service.InterestedListRefreshService;
import javafx.fxml.FXML;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class DogsPageController {

    private static DogsPageService dogsPageService;

    private static InterestedListRefreshService refreshService;
    @FXML
    private VBox dogsList;

    @FXML
    private VBox interestedList;

    @FXML
    private GridPane rightContainer;

    @FXML
    private GridPane rightInterestedContainer;

    @FXML
    protected void initialize() {
        interestedList.getChildren().clear();
        dogsList.getChildren().clear();

        DogsFetcher.prepare();

        dogsPageService = new DogsPageService();

        dogsPageService.insertDogs(dogsList, rightContainer, 0);
        dogsPageService.insertInterested(interestedList, rightInterestedContainer);

        refreshService = new InterestedListRefreshService(dogsPageService, interestedList, rightInterestedContainer);
//        refreshService.start();
    }

    @FXML
    protected void nextPage() {
        dogsList.getChildren().clear();

        dogsPageService.insertDogs(dogsList, rightContainer, 1);
    }

    @FXML
    protected void previousPage() {
        dogsList.getChildren().clear();

        dogsPageService.insertDogs(dogsList, rightContainer, -1);
    }

    public static void addInterested(AnimalDTO dog) {
        dogsPageService.addInterested(dog);

        refreshService.refreshInterested();
        /*synchronized (refreshService) {
            refreshService.notify();
        }*/
    }

    public static void removeInterested(AnimalDTO dog) {
        dogsPageService.removeInterested(dog);

        refreshService.refreshInterested();
        /*synchronized (refreshService) {
            refreshService.notify();
        }*/
    }
}