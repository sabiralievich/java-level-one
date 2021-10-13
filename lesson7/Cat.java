package ru.gb.lesson7;


import java.util.Random;

public class Cat {
    private String name;
    Random random = new Random();
    int maxHungry = 5;
    int hungry = random.nextInt(maxHungry);

    public Cat(String name) {
        this.name = name;
    }



    public void feedTheCat(Plate plate) throws InterruptedException {
        System.out.println(Variables.printRed(name + " is eating now.."));
        while (!plate.isEmpty() && hungry > 0) {
            Variables.printBySymbol(Variables.printGreen("- Meow, I'm hungry for " + hungry + " points of " + maxHungry + ", let me eat something!\n"));
            Thread.sleep(500);
            Variables.printBySymbol(Variables.printBlue("- But you still have " + plate.getFood() + " fish on your plate!\n"));
            Thread.sleep(500);
            Variables.printBySymbol(Variables.printGreen("- Okay, chomp, chomp"));
            for (int i = 0; i < 10; i++) {
                System.out.print(Variables.printGreen(" . "));
                Thread.sleep(300);
            }
            System.out.println("");
            hungry--;
            plate.takeFood();

        }
        if (hungry == 0) {
            Variables.printBySymbol(Variables.printGreen("- I'm full now..\n"));
           }
        if (plate.isEmpty()) {

                Variables.printBySymbol(Variables.printGreen("- What the hell?!!!\n"));
                Thread.sleep(1000);

                Variables.printBySymbol(Variables.printBlue("- You ate all the fish!\n"));
                plate.addFood();
            }


    }


}
