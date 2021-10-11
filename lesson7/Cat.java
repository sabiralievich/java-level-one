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
        System.out.println(Variables.ANSI_RED + name + " is eating now.." + Variables.ANSI_RESET);
        while (plate.food > 0 && hungry > 0) {
            Variables.printBySymbol(Variables.ANSI_GREEN + "- Meow, I'm hungry for " + hungry + " points of " + maxHungry + ", let me eat something!\n" + Variables.ANSI_RESET);
            Thread.sleep(500);
            Variables.printBySymbol(Variables.ANSI_BLUE + "- But you still have " + plate.food + " fish on your plate!\n" + Variables.ANSI_RESET);
            Thread.sleep(500);
            Variables.printBySymbol(Variables.ANSI_GREEN + "- Okay, chomp, chomp");
            for (int i = 0; i < 10; i++) {
                System.out.print(" . ");
                Thread.sleep(300);
            }
            System.out.println(Variables.ANSI_RESET);
            hungry--;
            plate.food--;

        }
        if (hungry == 0) {
            Variables.printBySymbol(Variables.ANSI_GREEN + "- I'm full now..\n" + Variables.ANSI_RESET);
           }
        if (plate.food == 0) {

                Variables.printBySymbol(Variables.ANSI_GREEN + "- What the hell?!!!\n" + Variables.ANSI_RESET);
                Thread.sleep(1000);

                Variables.printBySymbol(Variables.ANSI_BLUE + "- You ate all the fish!\n" + Variables.ANSI_RESET);
                plate.addFood(plate.random.nextInt(plate.maxFood));
            }


    }


}
