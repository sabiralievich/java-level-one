package ru.gb.lesson6;

public class Cat extends Animal {

    public Cat(String name) {
        if(animalCounter < Animal.animals.length) {
            this.name = name;
            System.out.println(this.getClass().getSimpleName() + " " + this.name + " on the starting line!");
            animals[animalCounter] = this;
            animalCounter++;
        } else {
            System.out.println("Maximum " + animals.length + " animals can run in the race.");
        }
    }



    @Override
    protected void swim(int distance) {
        System.out.println(this.name + ": I'm a Cat! I cannot swim!");

        }



    @Override
    protected void run(int distance) {
        if (distance == 0) {
            System.out.println(this.name +": Ok, I'll stay here..");
        } else if (Math.abs(distance) > 200) {
            System.out.println(this.name +": Sorry, I cannot run more than 200 meters..");
        } else {
            System.out.println(this.name +": Okay, I'm running..");
            System.out.println(this.getClass().getSimpleName() + " " + this.name + " run " + distance + " meters!");
        }

    }
}
