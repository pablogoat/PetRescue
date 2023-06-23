package com.example.petrescue.service;

import org.codehaus.jackson.map.ObjectMapper;
import com.example.petrescue.dto.AnimalDTO;
import com.example.petrescue.dto.ResponseDTO;
import com.example.petrescue.dto.SingleResponseDTO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Collections;
import java.util.List;
import java.util.Properties;

public class DogsFetcher {

    private static final Properties properties = new Properties();

    private static final HttpClient httpClient = HttpClient.newHttpClient();
    private static final ObjectMapper objectMapper = new ObjectMapper();
    private static String bearerToken;

    private static int page;

    public static void prepare() {
        try {
            FileInputStream fileInputStream = new FileInputStream("C:/dziwne_rzeczy/VScode/sem6/edp/PetRescue/src/main/java/config.properties");
            properties.load(fileInputStream);

            bearerToken = properties.getProperty("app.apiToken");
            page = Integer.parseInt(properties.getProperty("app.startingPage"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public static int changePage(int mode) {
        DogsFetcher.page += mode;
        if(DogsFetcher.page < 1) {
            DogsFetcher.page = 1;
        }
        return DogsFetcher.page;
    }

    public static AnimalDTO getSingleAnimal(int id){
        final String url = String.format("https://api.petfinder.com/v2/animals/%d", id);
        String responseBody = fetch(url);

        try {
            SingleResponseDTO singleResponseDTO = objectMapper.readValue(responseBody, SingleResponseDTO.class);

            return singleResponseDTO.animal();
        } catch (IOException e){
            e.printStackTrace();
            return null;
        }
    }
    public static List<AnimalDTO> getAnimals(int page){
        final String url = String.format("https://api.petfinder.com/v2/animals?type=dog&page=%d", page);
        String responseBody = fetch(url);

        try {
            ResponseDTO responseDTO =objectMapper.readValue(responseBody, ResponseDTO.class);

            return responseDTO.animals();
        } catch (IOException e){
            e.printStackTrace();
            return Collections.emptyList();
        }

    }

    private static String fetch(String path){
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(path))
                .header("Authorization", String.format("Bearer %s", bearerToken))
                .GET()
                .build();
        try {
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            return response.body();
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
