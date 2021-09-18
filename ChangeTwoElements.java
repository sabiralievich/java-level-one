package ru.gb;
public class ChangeTwoElements {
    public static void main(String[] args) {
        String [] s = {"1", "2", "3", "4"};
        changeTwoElements(s, 1, 2);
    }

    public static void changeTwoElements(Object[] array, int i, int j) {
        System.out.println("Input array is:");
        for(Object o : array) {
            System.out.print(o.toString());
        }
        System.out.println("");
        Object buf = array[i];
        array[i] = array[j];
        array[j] = buf;

        System.out.println("Output array is:");
        for(Object o : array) {
            System.out.print(o.toString());
        }

    }
}
