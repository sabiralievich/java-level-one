package ru.gb;
public class Orange extends Fruit {

    public Orange() {
        this.weight = 1.5;
        this.type = "Orange";
    }

    public Double getWeight() {
        return this.weight;
    }
    public String getType() {
        return this.type;
    }
}
