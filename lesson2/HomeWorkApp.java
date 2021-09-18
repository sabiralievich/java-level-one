package ru.gb.lesson2;

public class HomeWorkApp {
    public static void main(String[] args) {

        checkSum(2, 3);
        checkSignConsole(-100);
        checkSignBoolean(-1);
        printSting("Эх раз...", 3);
        leapYear(2024);
    }
    /*
    1. Написать метод, принимающий на вход два целых числа и проверяющий,
    что их сумма лежит в пределах от 10 до 20 (включительно), если да – вернуть true,
    в противном случае – false.
    */
    public static boolean checkSum(int i, int j) {
        if(((i + j) >= 10) && (i + j) <= 20) {
            System.out.println("Sum is in the range");
            return true;
        }
        else {
            System.out.println("Sum is out of range");
            return false;
        }
    }
    /*
    2. Написать метод, которому в качестве параметра передается целое число,
    метод должен напечатать в консоль, положительное ли число передали или отрицательное.
    Замечание: ноль считаем положительным числом.
     */
    public static void checkSignConsole(int i) {
        if (i >= 0)
            System.out.println("Number is positive, no return");
        else
            System.out.println("Number is negative, no return");
    }
    /*
    3. Написать метод, которому в качестве параметра передается целое число.
    Метод должен вернуть true, если число отрицательное, и вернуть false если положительное.
     */
    public static boolean checkSignBoolean(int i) {
        if (i >= 0) {
            System.out.println("Number is positive, return is false");
            return false;
        }
        else {
            System.out.println("Number is negative, return is true");
            return true;
        }
    }
    /*
    4. Написать метод, которому в качестве аргументов передается строка и число,
    метод должен отпечатать в консоль указанную строку, указанное количество раз;
     */
    public static void printSting(String s, int count) {
        for (int i = 0; i < count; i++) {
            System.out.println(s);
        }
    }
    /*
    5. * Написать метод, который определяет, является ли год високосным,
    и возвращает boolean (високосный - true, не високосный - false).
    Каждый 4-й год является високосным, кроме каждого 100-го, при этом каждый 400-й – високосный.
     */
    public static boolean leapYear(int year) {
        if ((year%400) == 0) {
            System.out.println("This is a leap year!");
            return true;
        }
        else if ((year%100 == 0)) {
            System.out.println("This is just a usual year..");
            return false;
        }
        else if ((year%4 == 0)) {
            System.out.println("This is a leap year!");
            return true;
        }
        else {
            System.out.println("This is just a usual year..");
            return false;
        }



    }
}
