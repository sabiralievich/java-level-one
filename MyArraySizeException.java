package ru.gb;

public class MyArraySizeException extends Exception {
    @Override
    public String getMessage() {
        return "Wrong Array Size! Should be " + Main.xSize + "x" + Main.ySize;
    }
}
