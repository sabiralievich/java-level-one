package ru.gb.lesson7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class HungryCats {

    public static void main(String[] args) throws InterruptedException, IOException {

/*
        Cat catOne = new Cat("Cat One");
        Cat catTwo = new Cat("Cat Two");
        Cat catThree = new Cat("Cat Three");
        Cat[] cats = {catOne, catTwo, catThree};
        */
        Plate plate = new Plate();

        letTheCatsOut(inputCats(), plate);
    }

    private static void letTheCatsOut(ArrayList<Cat> cats, Plate plate) throws InterruptedException {
        Variables.printBySymbol(Variables.ANSI_BLUE + "- Okay, let's feed " + cats.size() + " cats..\n" + Variables.ANSI_RESET);
        for (Cat cat : cats) {
            if (plate.food == 0) {
                plate.addFood(plate.random.nextInt(plate.maxFood));
            }
            while (cat.hungry > 0) {
                cat.feedTheCat(plate);
            }
        }
        Variables.printBySymbol(Variables.ANSI_BLUE + "Very good, now all " + cats.size() + " cats are fed! \nBut they ate all my fish!!!" + Variables.ANSI_RESET);
    }

    private static ArrayList<Cat> inputCats() throws IOException {
        System.out.println(Variables.ANSI_RED + "Input cats names one by one. When finish, please input 'q'." + Variables.ANSI_RESET);
        System.out.print(Variables.ANSI_RED + "Input 1th" + " cat name or 'q' for quit: " + Variables.ANSI_RESET);
        ArrayList<Cat> catList = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input;
        int i = 2;
        while (!(input = reader.readLine()).equals("q")) {
                System.out.print(Variables.ANSI_RED + "Input " + i + "th" + " cat name or 'q' for quit: " + Variables.ANSI_RESET);
                catList.add(new Cat(input));
                i++;
           }

        return catList;
    }
}
