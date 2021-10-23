package ru.gb;


import java.util.Arrays;
import java.util.stream.Stream;

/*
1. Напишите метод, на вход которого подаётся двумерный строковый массив размером 4х4.
При подаче массива другого размера необходимо бросить исключение MyArraySizeException.
2. Далее метод должен пройтись по всем элементам массива, преобразовать в int и просуммировать.
Если в каком-то элементе массива преобразование не удалось (например, в ячейке лежит символ или
текст вместо числа), должно быть брошено исключение MyArrayDataException с детализацией, в какой
именно ячейке лежат неверные данные.
3. В методе main() вызвать полученный метод, обработать возможные исключения MyArraySizeException
и MyArrayDataException и вывести результат расчета
 */
public class Main {
    public final static int xSize = 4;
    public final static int ySize = 4;
    public static void main(String[] args) {
        final String[][] rightNumbers = new String[][] {  { "4", "2", "3", "3" }, { "8", "2", "7", "3" },{ "2", "3", "1", "3" },  { "2", "3", "1", "3" } };
        final String[][] wrongNumbers = new String[][] {  { "J", "2", "3", "4" }, { "8", "A", "5", "3" },{ "2", "3", "V", "3" },  { "2", "3", "1", "A" } };
        final String[][] wrongRowsCount = new String[][] {  { "8", "A", "5", "3" },{ "2", "3", "V", "3" },  { "2", "3", "1", "A" } };
        final String[][] wrongColumnsCount = new String[][] { { "8", "A", "5", "3", "2"}, {"10", "8", "A", "5", "3" },{ "2", "3", "V", "3" },  { "2", "3", "1", "A" } };

        try {

            // Ниже вызовы массивов с различными ошибками (размер, данные).
            // Сейчас раскомментирован с неверными данными в элементах:

            // correct Array (Size and data are correct):
            //        sumArray(rightNumbers);

            // Array with incorrect elements:
            sumArray(wrongNumbers);

            // Array with incorrect rows count:
//            sumArray(wrongRowsCount);

            //Array with incorrect columns count:
//            sumArray(wrongColumnsCount);
        }
        catch (MyArraySizeException e) {
            System.out.println(e.getMessage());
        }
    }

    private static int sumArray(String[][] inputArray) throws MyArraySizeException {

        System.out.println("Your Array is:");
        Stream.of(inputArray).map(Arrays::toString).forEach(System.out::println);
        if(inputArray.length == ySize) {
            for (String[] sArr : inputArray) {
                if (sArr.length != xSize) {
                    throw new MyArraySizeException();
                }
                return sumStringArray(inputArray);
            }
        }
        throw new MyArraySizeException();

    }

    private static int sumStringArray  (String[][] inputArray){
        int sum = 0;

        for (int i = 0; i < inputArray.length; i++) {
            for (int j = 0; j < inputArray.length; j++) {
                try {
                    sum+= Integer.parseInt(inputArray[i][j]);
                }
                catch (NumberFormatException e) {
                    System.out.println("Wrong data at the element [" + (i+1) + "][" + (j+1) + "] (" + inputArray[i][j] + ")");
                }
            }

        }
        System.out.println("Sum of correct elements of Array is " + sum);
        return sum;
    }
}

