package ru.gb;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class Main {
    private static File file = new File("src\\ru\\gb\\data.csv");

    public static void main(String[] args) {

        String[] headerOut = new String[] {"header1", "header2", "header3"};
        int[][] dataOut = new int[][] {{101,200,300}, {400,500,600}, {123,123,123}, {234,234,234}, {345,345,345}, {456,456,456}};

       writeFile(headerOut, dataOut);

       // readFile();

    }

    private static void writeFile(String[] headerOut, int[][] dataOut) {
        AppData appDataOut = new AppData(headerOut, dataOut);
        byte[] appDataOutByte = appDataOut.toString().getBytes(StandardCharsets.UTF_8);
        try (ObjectOutputStream objOut = new ObjectOutputStream(new FileOutputStream(file))) {
            objOut.writeObject(appDataOut.toString());
            System.out.println("Recorded into file " + file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (FileOutputStream fileOutputStream = new FileOutputStream(file)) {
            fileOutputStream.write(appDataOutByte);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void readFile() {
        AppData appDataIn = new AppData();
        byte[] buf = new byte[20];
        System.out.println("reading file " + file + ":");
        try (FileInputStream fileInputStream = new FileInputStream(file)) {
            int count;
            while ((count = fileInputStream.read(buf)) > 0) {
                for (int i = 0; i < count; i++) {
                    System.out.print((char) buf[i]);
                }
            }

        } catch (IOException e) {
            e.getStackTrace();
        }
    }
}
