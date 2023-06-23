package com.example.petrescue.service;

import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.concurrent.Service;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class InterestedListRefreshService /*extends Service<Void>*/ {
    private final DogsPageService dogsPageService;

    private final VBox interestedList;
    private final GridPane rightInterestedContainer;

    public InterestedListRefreshService(DogsPageService dogsPageService, VBox interestedList, GridPane rightInterestedContainer) {
        this.dogsPageService = dogsPageService;
        this.interestedList = interestedList;
        this.rightInterestedContainer = rightInterestedContainer;
    }

    public void refreshInterested() {
        interestedList.getChildren().clear();
        rightInterestedContainer.getChildren().clear();
        dogsPageService.insertInterested(interestedList, rightInterestedContainer);
    }

    /*@Override
    protected Task<Void> createTask() {
        return new Task<Void>() {
            @Override
            protected Void call() throws Exception {
                while (true) {

                    synchronized (this) {
                        Platform.runLater(() -> {
                            try {
                                interestedList.getChildren().clear();
                                dogsPageService.insertInterested(interestedList, rightInterestedContainer);
                            } catch (Exception e){
                                e.printStackTrace();
                            }
                        });
                        System.out.println("dupa1");
                        this.wait();
                    }
                }
            }
        };
    }*/
}
