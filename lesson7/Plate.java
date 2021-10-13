package ru.gb.lesson7;

import java.util.Random;

public class Plate {

    private Random random = new Random();
    private int maxFood = 5;
    private int food = 0;

    public Plate() {

    }
    public void addFood() {
        Variables.printBySymbol(Variables.printBlue("- Okay, let's fill the plate...\n"));
        food = food + randomFood();
        Variables.printBySymbol(Variables.printBlue("- Very good, now you have " + food + " fish on your plate!\n"));

    }

    public int getFood() {
        return food;
    }

    public void takeFood() {
        food--;
    }

    public int randomFood() {
        return random.nextInt(maxFood);
    }
    public boolean isEmpty() {
        return food == 0;
    }
}
