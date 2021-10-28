package ru.gb;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<Fruit> apples = new ArrayList<>();
        ArrayList<Fruit> oranges = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            apples.add(new Apple());
            oranges.add(new Orange());
        }
        Box box1 = new Box(apples);
        Box box2 =new Box(oranges);
        Box box3 = new Box(40.0);
        Box box4 = new Box(30.0);

        box3.addFruits(box1);
      //    box3.addFruits(box1);
        box4.addFruits(box2);

        box2.compare(box1);

        box1.addApple(4);
        System.out.println("Box1 weighs " + box1.getWeight());
    }

}
