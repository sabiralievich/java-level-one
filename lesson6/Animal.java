package ru.gb.lesson6;

public abstract class Animal {
    protected static int animalCounter;
    protected static Animal[] animals = new Animal[10];

    protected String name;

    protected abstract void swim(int distance);
    protected abstract void run(int distance);
}
