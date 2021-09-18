package ru.gb;
import java.util.ArrayList;
import java.util.Objects;

public class Box extends ArrayList {
    private Double maxWeight = 10.0;
    private static int count;
    private int number;

    public Box() {
        this.number = ++count;
    }
    public Box(Double maxWeight) {
        this.maxWeight = maxWeight;
        this.number = ++count;
    }
    public Box(ArrayList<Fruit> initialBox) {
        this.addAll(initialBox);
        this.maxWeight = this.getWeight();
        this.number = ++count;
        System.out.println("Box number " + this.number + " created! It has " + this.size() + " " + this.getFruitType() + " and weighs " + ((Fruit) this.get(0)).weight * this.size() + " pounds!" );
    }

    public Double getWeight() {
        if(this.isEmpty()) {
            return 0.0;
        } else {
                return ((Fruit) this.get(0)).weight * this.size();
            }
    }

    public void addFruits(Box anotherBox) {
        if(boxAreSame(anotherBox, this)) {
            if (anotherBox.getWeight() + this.getWeight() <= this.maxWeight) {
                this.addAll(anotherBox);
                System.out.println(anotherBox.size() + " " + this.getFruitType() +  "s from box number" + anotherBox.number + " loaded!");
                anotherBox.clear();
            } else {
                System.out.println("Box is overloaded!");
            }
        } else {
            System.out.println("Boxes have different fruits inside!");
        }
    }


    public void addApple(int i) {
        while (this.getWeight() < maxWeight) {
            for (int j = 0; j < i; j++) {
                this.add(new Apple());
            }
        }
        System.out.println(i +" apples were added into box number " + this.number);
    }
    private boolean boxAreSame(Box box1, Box box2) {
            if(box2.isEmpty()) {
                return true;
            } else if (box1.isEmpty()) {
                System.out.println("Nothing to load!");
                return true;
            } else return box1.getFruitType().equals(box2.getFruitType());

    }

    private String getFruitType() {
        if(!this.isEmpty()) {
            return ((Fruit)this.get(0)).type;
        } else return "The Box " + this.number + " is empty!";

    }
    public boolean compare(Box boxToCompare) {
        if(Objects.equals(this.getWeight(), boxToCompare.getWeight())) {
            System.out.println("Boxes weigh equal.");
            return true;
        } else return false;
    }
}
