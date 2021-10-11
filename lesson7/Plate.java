package ru.gb.lesson7;

import java.util.Random;

public class Plate {

    Random random = new Random();
    int maxFood = 5;
    int food = 0;

    public Plate() {

    }
    public void addFood(int add) {
        Variables.printBySymbol(Variables.ANSI_BLUE + "- Okay, let's fill the plate...\n" + Variables.ANSI_RESET);
        food = food + add;
        Variables.printBySymbol(Variables.ANSI_BLUE + "- Very good, now you have " + food + " fish on your plate!\n" + Variables.ANSI_RESET);

    }
}
