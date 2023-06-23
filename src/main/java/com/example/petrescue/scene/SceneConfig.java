package com.example.petrescue.scene;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class SceneConfig {
    public static Scene setScene(){

        // Tworzenie zawartości zakładek
        Node tabContent1 = createDogsTab();
        Node tabContent2 = createInterestedTab();

        // Tworzenie pierwszej zakładki
        Tab tab1 = new Tab("Dogs");
        tab1.setContent(tabContent1);
        tab1.setClosable(false);

        // Tworzenie drugiej zakładki
        Tab tab2 = new Tab("Interested");
        tab2.setContent(tabContent2);
        tab2.setClosable(false);

        // Tworzenie TabPane i dodawanie zakładek
        TabPane tabPane = new TabPane(tab1, tab2);

        // Tworzenie sceny
        Scene scene = new Scene(tabPane, 800, 600); // Ustaw odpowiednie wymiary
        return scene;
    }

    private static Node createDogsTab(){
        Image placeHolderImage100 = new Image("https://dl5zpyw5k3jeb.cloudfront.net/photos/pets/65033819/1/?bust=1687079929&width=100");
        Image placeHolderImage300 = new Image("https://dl5zpyw5k3jeb.cloudfront.net/photos/pets/65033819/1/?bust=1687079929&width=300");

        // Kontener ze scrollem
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setPrefWidth(300); // Szerokość kontenera ze scrollem
        scrollPane.setId("DogsScroll");

        // VBox na kontenery
        VBox containerVBox = new VBox();
        containerVBox.setSpacing(10); // Odstęp między kontenerami
        containerVBox.setAlignment(Pos.BASELINE_LEFT);

        // Dodaj 20 kontenerów
        for (int i = 0; i < 20; i++) {
            // Kontener dla pojedynczej pozycji
            HBox itemHBox = new HBox();
            itemHBox.setAlignment(Pos.CENTER_LEFT);
            itemHBox.setSpacing(10); // Odstęp między elementami w kontenerze

            // Obrazek
            ImageView imageView = new ImageView(placeHolderImage100);
            imageView.setFitWidth(100); // Szerokość obrazka
            imageView.setFitHeight(100); // Wysokość obrazka

            // Krotki tekst
            Text text = new Text("Name");

            // Przycisk
            Button button = new Button("View details");

            // Dodaj elementy do kontenera
            itemHBox.getChildren().addAll(imageView, text, button);

            // Dodaj kontener do kontenera ze scrollem
            containerVBox.getChildren().add(itemHBox);
        }

// Przyciski Poprzednia strona i Następna strona
        Button previousButton = new Button("Previous page");
        Button nextButton = new Button("Next page");

// Kontener dla przycisków
        HBox buttonsContainer = new HBox(previousButton, nextButton);
        buttonsContainer.setSpacing(10); // Odstęp między przyciskami
        buttonsContainer.setAlignment(Pos.CENTER_LEFT);

// Kontener na lewej stronie
        VBox leftContainerVBox = new VBox(scrollPane, buttonsContainer);
        leftContainerVBox.setSpacing(10); // Odstęp między kontenerami

// Ustaw kontener jako zawartość kontenera ze scrollem
        scrollPane.setContent(containerVBox);



        // Kontener na prawej stronie ----------------
        GridPane rightContainer = new GridPane();
        rightContainer.setVgap(10); // Odstęp między wierszami
        rightContainer.setAlignment(Pos.TOP_CENTER);

// Obrazek na górze
        ImageView bigImageView = new ImageView(placeHolderImage300);
        bigImageView.setFitWidth(300); // Szerokość obrazka
        bigImageView.setFitHeight(300); // Wysokość obrazka

// Dodaj obrazek do pierwszego wiersza
        rightContainer.add(bigImageView, 0, 0, 1, 1); // columnIndex, rowIndex, columnSpan, rowSpan

// Tworzenie etykiet i wartości
        Label ageLabel = new Label("Age:");
        Label ageValueLabel = new Label("sample age");

        Label genderLabel = new Label("Gender:");
        Label genderValueLabel = new Label("sample gender");

        Label sizeLabel = new Label("Size:");
        Label sizeValueLabel = new Label("sample size");

        Label coatLabel = new Label("Coat:");
        Label coatValueLabel = new Label("sample coat");

        Label nameLabel = new Label("Name:");
        Label nameValueLabel = new Label("sample name");

        Label descriptionLabel = new Label("Description:");
        Label descriptionValueLabel = new Label("Friendly dog");

        Label environmentLabel = new Label("Environment:");
        Label environmentValueLabel = new Label("sample environment");

        Label contactLabel = new Label("Contact:");
        Label contactValueLabel = new Label("sample contact");

// Dodaj etykiety i wartości do kolejnych wierszy
        rightContainer.addRow(1, ageLabel, ageValueLabel);
        rightContainer.addRow(2, genderLabel, genderValueLabel);
        rightContainer.addRow(3, sizeLabel, sizeValueLabel);
        rightContainer.addRow(4, coatLabel, coatValueLabel);
        rightContainer.addRow(5, nameLabel, nameValueLabel);
        rightContainer.addRow(6, descriptionLabel, descriptionValueLabel);
        rightContainer.addRow(7, environmentLabel, environmentValueLabel);
        rightContainer.addRow(8, contactLabel, contactValueLabel);

// Przycisk na dole
        Button bottomButton = new Button("Interested");

// Dodaj przycisk na ostatnim wierszu
        rightContainer.add(bottomButton, 0, 9, 2, 1); // columnIndex, rowIndex, columnSpan, rowSpan

// Kontener główny
        BorderPane mainContainer = new BorderPane();
        mainContainer.setLeft(leftContainerVBox);
        mainContainer.setRight(rightContainer);

        return mainContainer;
    }

    private static Node createInterestedTab(){
        Image placeHolderImage100 = new Image("https://dl5zpyw5k3jeb.cloudfront.net/photos/pets/65037699/1/?bust=1687118059&width=100");
        Image placeHolderImage300 = new Image("https://dl5zpyw5k3jeb.cloudfront.net/photos/pets/65037699/1/?bust=1687118059&width=300");

        // Kontener ze scrollem
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setPrefWidth(300); // Szerokość kontenera ze scrollem

// VBox na kontenery
        VBox containerVBox = new VBox();
        containerVBox.setSpacing(10); // Odstęp między kontenerami
        containerVBox.setAlignment(Pos.BASELINE_LEFT);

// Dodaj 20 kontenerów
        for (int i = 0; i < 20; i++) {
            // Kontener dla pojedynczej pozycji
            HBox itemHBox = new HBox();
            itemHBox.setAlignment(Pos.CENTER_LEFT);
            itemHBox.setSpacing(10); // Odstęp między elementami w kontenerze

            // Obrazek
            ImageView imageView = new ImageView(placeHolderImage100);
            imageView.setFitWidth(100); // Szerokość obrazka
            imageView.setFitHeight(100); // Wysokość obrazka

            // Krotki tekst
            Text text = new Text("Name");

            // Przycisk
            Button button = new Button("View details");

            // Dodaj elementy do kontenera
            itemHBox.getChildren().addAll(imageView, text, button);

            // Dodaj kontener do kontenera ze scrollem
            containerVBox.getChildren().add(itemHBox);
        }

// Przyciski Poprzednia strona i Następna strona
        Button previousButton = new Button("Previous page");
        Button nextButton = new Button("Next page");

// Kontener dla przycisków
        HBox buttonsContainer = new HBox(previousButton, nextButton);
        buttonsContainer.setSpacing(10); // Odstęp między przyciskami
        buttonsContainer.setAlignment(Pos.CENTER_LEFT);

// Kontener na lewej stronie
        VBox leftContainerVBox = new VBox(scrollPane, buttonsContainer);
        leftContainerVBox.setSpacing(10); // Odstęp między kontenerami

// Ustaw kontener jako zawartość kontenera ze scrollem
        scrollPane.setContent(containerVBox);



        // Kontener na prawej stronie ----------------
        GridPane rightContainer = new GridPane();
        rightContainer.setVgap(10); // Odstęp między wierszami
        rightContainer.setAlignment(Pos.TOP_CENTER);

// Obrazek na górze
        ImageView bigImageView = new ImageView(placeHolderImage300);
        bigImageView.setFitWidth(300); // Szerokość obrazka
        bigImageView.setFitHeight(300); // Wysokość obrazka

// Dodaj obrazek do pierwszego wiersza
        rightContainer.add(bigImageView, 0, 0, 1, 1); // columnIndex, rowIndex, columnSpan, rowSpan

// Tworzenie etykiet i wartości
        Label ageLabel = new Label("Age:");
        Label ageValueLabel = new Label("sample age");

        Label genderLabel = new Label("Gender:");
        Label genderValueLabel = new Label("sample gender");

        Label sizeLabel = new Label("Size:");
        Label sizeValueLabel = new Label("sample size");

        Label coatLabel = new Label("Coat:");
        Label coatValueLabel = new Label("sample coat");

        Label nameLabel = new Label("Name:");
        Label nameValueLabel = new Label("sample name");

        Label descriptionLabel = new Label("Description:");
        Label descriptionValueLabel = new Label("Friendly dog");

        Label environmentLabel = new Label("Environment:");
        Label environmentValueLabel = new Label("sample environment");

        Label contactLabel = new Label("Contact:");
        Label contactValueLabel = new Label("sample contact");

// Dodaj etykiety i wartości do kolejnych wierszy
        rightContainer.addRow(1, ageLabel, ageValueLabel);
        rightContainer.addRow(2, genderLabel, genderValueLabel);
        rightContainer.addRow(3, sizeLabel, sizeValueLabel);
        rightContainer.addRow(4, coatLabel, coatValueLabel);
        rightContainer.addRow(5, nameLabel, nameValueLabel);
        rightContainer.addRow(6, descriptionLabel, descriptionValueLabel);
        rightContainer.addRow(7, environmentLabel, environmentValueLabel);
        rightContainer.addRow(8, contactLabel, contactValueLabel);

// Przycisk na dole
        Button bottomButton = new Button("Interested");

// Dodaj przycisk na ostatnim wierszu
        rightContainer.add(bottomButton, 0, 9, 2, 1); // columnIndex, rowIndex, columnSpan, rowSpan

// Kontener główny
        BorderPane mainContainer = new BorderPane();
        mainContainer.setLeft(leftContainerVBox);
        mainContainer.setRight(rightContainer);

        return mainContainer;
    }
}
