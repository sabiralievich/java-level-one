package ru.gb;
public class Apple extends Fruit {

    public Apple() {
        this.weight = 1.0;
        this.type = "Apple";
    }

    public Double getWeight() {
        return this.weight;
    }

    public String getType() {
        return this.type;
    }
}
