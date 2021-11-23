package ru.gb;

public class JavaCourse implements Course {
    String name = "Java Course. Level 1";
    @Override
    public String getName() {
        return name;
    }
}
