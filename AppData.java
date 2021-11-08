package ru.gb;

import java.io.File;
import java.io.Serializable;
import java.util.Arrays;

public class AppData implements Serializable {
    private String[] header;
    private int[][] data;

    public AppData() {
        System.out.println("New data instance created");
    }

    public AppData(String[] header, int[][] rows) {
        this.header = header;
        this.data = rows;
    }
    @Override
    public String toString() {
        StringBuilder headerString = new StringBuilder();
        StringBuilder row = new StringBuilder();
        for(String s : header) {
            headerString.append(s).append(";");
        }
        for (int[] datum : data) {
            for (int j = 0; j < 3; j++) {
                row.append(datum[j]).append(";");
            }
            row.append("\n");
        }
        return headerString + "\n" + row;

    }

    public void setData() {

    }

    public void getData() {

    }
}
