package ru.gb.lesson6;

public class Dog extends Animal {
    public Dog(String name) {
        if(animalCounter < Animal.animals.length) {
            this.name = name;
            System.out.println(this.getClass().getSimpleName() + " " + this.name + " on the starting line!");
            animals[animalCounter] = this;
            animalCounter++;
        } else {
            System.out.println("Maximum " + Animal.animals.length + " animals can run in the race.");
        }

    }



    @Override
    protected void swim(int distance) {
        if (this.name.equals("Mu-Mu")) {
            mumuStyle();
        } else if (distance == 0) {
                System.out.println(this.name + ": Ok, I'll stay here..");
            } else if (Math.abs(distance) > 10) {
                System.out.println(this.name + ": Sorry, I cannot swim more than 10 meters..");
            } else {
                System.out.println(this.name + ": Okay, I'm diving...");
                System.out.println(this.getClass().getSimpleName() + " " + this.name + " had swam " + distance + " meters!");

        }
    }
    private void mumuStyle() {
        System.out.println(this.name + ": За что, Герасим?!");
    }

    @Override
    protected void run(int distance) {
        if (distance == 0) {
            System.out.println(this.name +": Ok, I'll stay here..");
        } else if (Math.abs(distance) > 500) {
                    System.out.println(this.name +": Sorry, I cannot run more than 500 meters..");
                } else {
            System.out.println(this.name +": Okay, I'm running..");
            System.out.println(this.getClass().getSimpleName() + " " + this.name + " run " + distance + " meters!");
        }

    }
}

