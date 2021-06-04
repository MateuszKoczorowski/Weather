package sda;

import java.util.Scanner;

public class UserInterface {
    private  final  LocationController locationController;
    public UserInterface(LocationController locationController)
    {
        this.locationController = locationController;
    }

    public void run() {
        System.out.println("Aplikacja jest uruchomiona!");
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("Witaj w aplikacji Pogodowej ");
            System.out.println("1) Dodaj nowa lokalizacje  ");
            System.out.println("2) Wyswietl wszystkie lokacje ");
            System.out.println("0) Wyjdź ");
            int response = scanner.nextInt();
            switch (response){
                case 1:
                    addNewLocation();
                case 2:
                    showAllLocation();
                case 0:
                    return;

            }
        }
    }

    private void addNewLocation() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj nazwe miasta : ");
        String cityName = scanner.nextLine();
        System.out.println("Podaj szerokość geograficzna ");
        Double length = scanner.nextDouble();
        System.out.println("Podaj dlugość geograficzną :");
        Double longitude = scanner.nextDouble();
        System.out.println("Podaj region : ");
        String region = scanner.nextLine();
        System.out.println("Podaj Nazwe kraju : ");
        String country = scanner.nextLine();

           }
           public void showAllLocation(){
        String httpResponseBody = locationController.showAllLocation();
               System.out.println("Twoje lokacje : " + httpResponseBody );
           }
}
