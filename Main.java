package ru.gb;

import java.util.Arrays;

public class Main {
    private static String file = "src\\ru\\gb\\data.csv";

    public static void main(String[] args) {
    AppData appData = new AppData();
    appData.readFromFile(file);
        System.out.println(Arrays.toString(appData.getHeader()));
        System.out.println(Arrays.deepToString(appData.getData()));
    appData.writeToFile(file);

    }


}
