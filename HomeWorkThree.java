package ru.gb;

public class HomeWorkThree {

    public static void  main (String args[]) {

        /*
        1. Задать целочисленный массив, состоящий из элементов 0 и 1.
        Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ]. С помощью цикла и условия заменить 0 на 1, 1 на 0;
         */
        System.out.println("Задача 1.");
        int[] arrayOne = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        System.out.println("Первоначальный массив:");
        for (int j = 0; j < arrayOne.length; j++) {
            System.out.print(arrayOne[j] + " ");
        }
        System.out.println("\nИнвертированный массив:");
        for(int i = 0; i < arrayOne.length; i++) {

            if(arrayOne[i] == 0) {
                arrayOne[i] = 1;
            } else {
                arrayOne[i] = 0;
            }
            System.out.print(arrayOne[i] + " ");
        }

        /*
        2. Задать пустой целочисленный массив длиной 100.
        С помощью цикла заполнить его значениями 1 2 3 4 5 6 7 8 … 100;
         */
        System.out.println("\n\nЗадача 2.");
        int[] hundred = new int[100];
        for(int i = 0; i < 100; i++) {
            hundred[i] = i+1;
            System.out.print(hundred[i]+" ");
        }

        /*
        3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ]
        пройти по нему циклом, и числа меньшие 6 умножить на 2;
         */
        System.out.println("\n\nЗадача 3.");
        int[] toDouble = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println("Первоначальный массив:");
        for(int i = 0; i < toDouble.length; i++) {
            System.out.print(toDouble[i] + " ");
        }
        System.out.println("\nИзмененный массив:");
        for (int j = 0; j < toDouble.length; j++) {
            if (toDouble[j] < 6) {
                toDouble[j] = toDouble[j] * 2;
            }
            System.out.print(toDouble[j] + " ");
        }

        /*
        4. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое),
        и с помощью цикла(-ов) заполнить его диагональные элементы единицами
        (можно только одну из диагоналей, если обе сложно). Определить элементы одной из диагоналей можно
        по следующему принципу: индексы таких элементов равны, то есть [0][0], [1][1], [2][2], …, [n][n];
         */
        System.out.println("\n\nЗадача 4.");
        int[][] matrix = new int[5][5];
        for(int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (i == j) {
                    matrix[i][j] = 1;
                }
                System.out.print(matrix[i][j] + " ");
            }

            System.out.println();
        }
        // Вызов задачи 5:
        System.out.println("\nЗадача 5:");
        createArray(5, 0);



        /*
        6. * Задать одномерный массив и найти в нем минимальный и максимальный элементы ;
         */

        int[] minMax = {2, 2, 2, 1, 2, 2, 10, 1};
        System.out.println("\n\nЗадача 6:");
        System.out.println("В массиве");
        int min = minMax[0];
        int max = minMax[0];
        for (int i = 0; i < minMax.length; i++) {
            System.out.print(minMax[i] + " ");
            if(min > minMax[i]) {
                min = minMax[i];
            }
            if (max <= minMax[i]) {
                max = minMax[i];
            }
        }
        System.out.println("\nминимальный элемент равен " + min + ", а максимальный равен " + max);

        //Вызов задачи 7:
        System.out.println("\nЗадача 7:");
        System.out.println("Для массива");
        for (int i = 0; i < minMax.length; i++) {
            System.out.print(minMax[i] + " ");
        }
        System.out.println("\nРезультат проверки равенства левой и правой частей - " + checkBalance(minMax));

        //Вызов задачи 8:
        System.out.println("\nЗадача 8:");
        System.out.println("Смещение элементов массива");
        for (int i = 0; i < minMax.length; i++) {
            System.out.print(minMax[i] + " ");
        }
        shift_array(minMax, -3);
    }




    /*
    5. Написать метод, принимающий на вход два аргумента: len и initialValue,
     и возвращающий одномерный массив типа int длиной len, каждая ячейка которого равна initialValue;
     */
    public static int[] createArray(int len, int initialValue) {
        int[] array = new int[len];
        System.out.println("Новый массив размером " + len + " и начальным значением " + initialValue + ":");
        for (int i = 0; i < array.length; i++) {
            array[i] = initialValue;
            System.out.print(array[i] + " ");
        }
        return array;
    }

    /*
    7. ** Написать метод, в который передается не пустой одномерный целочисленный массив,
    метод должен вернуть true, если в массиве есть место, в котором сумма левой и правой части массива равны.
     */

    public static boolean checkBalance(int[] array) {

        for (int i = 0; i < array.length; i++) {
            if(checkLeftSum(array, i) == checkRightSum(array, i)) {
                return true;
            }

        }

        return false;
    }
    public static int checkLeftSum (int[] array, int i) {
        int result = array[i];
        for (int j = i-1; j == 0; j--) {
           result = result + array[j];
        }
        return result;
    }
    public static int checkRightSum (int[] array, int i) {
        int result = array[i];
        for (int j = i+1; j < array.length; j++) {
            result =  result = result + array[j];
        }
        return result;
    }

    /*
    8. *** Написать метод, которому на вход подается одномерный массив и число n
    (может быть положительным, или отрицательным), при этом метод должен сместить
    все элементы массива на n позиций. Элементы смещаются циклично. Для усложнения
    задачи нельзя пользоваться вспомогательными массивами
     */
    public static int getNumber(int x, int y) {
        while(y != 0) {
            int buf = x;
            x = y;
            y = buf % x;
        }
        return x;
    }

    public static void shift_array(int[] array, int n) {

        System.out.print("на " + Math.abs(n) + " элементов");
        if (n >= 0)
            System.out.println(" вправо:");
        else System.out.println(" влево:");

        int length = array.length;
        n %= length;
        if(n < 0)
            n = length + n;
        int num = getNumber(length, n);
        for(int i = 0; i < num; i++) {
            int buf = array[i];
            for(int j = i - n + length; j != i; j = (j - n + length) % length)
                array[(j + n) % length] = array[j];
            array[i + n] = buf;
        }
        for(int i = 0; i < array.length; i++) {

            System.out.print(array[i] + " ");
        }
    }
}
