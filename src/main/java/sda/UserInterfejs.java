package sda;

import java.util.Scanner;

public class UserInterfejs {



    public void run (){
        System.out.println("Witaj w naszej aplikacji pogodowej;");
        Scanner scaner = new Scanner(System.in);

        while (true){
            System.out.println("Zaczynajmy");
            System.out.println("1) Wyświetl aktualnanie dodane lokalizacje pogodowe : ");
            System.out.println("2) Wyświetl aktualną pogode : ");
            System.out.println("3) Dodaj lokalizacje : ");
            System.out.println("0) Wyjdź z programu :( ");
            int respown = scaner.nextInt();

            switch (respown) {
                case 1 :
                    System.out.println("nie masz żadnych lokacji ");
                    break;
                case 2 :
                    System.out.println("nie masz żadnych lokacji");
                    break;
                case 3 :
                    addLocation();
                   break;
                case 0 :
                    return;

            }

        }
    }

    private void addLocation() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj miasta : ");
        String nameLocation = scanner.nextLine();
        System.out.println("Podaj dlugość i szerokość geograficzną : ");
        System.out.println("Podaj X : ");
        double x = scanner.nextDouble();
        System.out.println("Podaj Y : ");
        double y = scanner.nextDouble();
        System.out.println("Podaj region : ");
        String region = scanner.nextLine();
        System.out.println("Podaj Kraj : ");
        String country = scanner.nextLine();

    }
}
