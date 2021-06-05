package com.weather;

import com.weather.forecast.ForecastController;
import com.weather.location.LocationController;

import java.util.Scanner;

public class UserInterface {

    private final LocationController locationController;
    private final ForecastController forecastController;

    public UserInterface(LocationController locationController, ForecastController forecastController) {
        this.locationController = locationController;
        this.forecastController = forecastController;
    }

    public void run() {
        System.out.println("Witaj w Aplikacji Pogoda");

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Wybierz opcje od 1 do 4. Co chcesz zrobić ?");
            System.out.println("1. Dodaj nową lokacje");
            System.out.println("2. Pokarz wszystkie lokacje");
            System.out.println("3. Pokarz pogode ");
            System.out.println("4. Wyjdz z aplikacji");

            int response = scanner.nextInt();

            switch (response) {
                case 1:
                    addNewLocation();
                    break;
                case 2:
                    showAllLocations();
                    break;
                case 3:
                    getForecast();
                    break;
                case 4:
                    return;
            }
        }
    }

    public void addNewLocation() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nazwa miasta : ");
        String cityName = scanner.nextLine();
        System.out.println("Szerokość geograficzna : ");
        Double latitude = scanner.nextDouble();
        System.out.println("Długość geograficzna : ");
        Double longitude = scanner.nextDouble();
        System.out.println("Region : ");
        String region = scanner.nextLine();
        scanner.nextLine();
        System.out.println("Kraj : ");
        String country = scanner.nextLine();

        String httpResponseBody = locationController.createNewLocation(cityName, latitude, longitude, region, country);
        System.out.println("Response from the server: " + httpResponseBody);
        System.out.println();
    }

    public void showAllLocations() {
        String httpResponseBody = locationController.showAllLocations();
        System.out.println("Response from the server: " + httpResponseBody);
        System.out.println();
    }

    public void getForecast() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj ID miasta: ");
        Long locationId = scanner.nextLong();
        System.out.println("Podaj dzień (1-8) który chcesz sprawdzić : ");
        Integer date = scanner.nextInt();

        String httpResponseBody = forecastController.getForecast(locationId, date);
        System.out.println("Response from the server: " + httpResponseBody);
        System.out.println();
    }
}
