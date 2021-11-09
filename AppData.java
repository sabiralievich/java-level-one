package ru.gb;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class AppData implements Serializable {
    private String[] header;
    private Integer[][] data;
    private final String DELIMITER = ";";
    public String[] getHeader() {
        return header;
    }

    public Integer[][] getData() {
        return data;
    }
    public void readFromFile(String file) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            ArrayList<Integer[]> dataRows = new ArrayList<>();
            header = (reader.readLine().split(DELIMITER));
            String row;
            while ((row = reader.readLine()) != null) {
                String[] bufString = row.split(DELIMITER);
                Integer[] bufInt = new Integer[bufString.length];
                for (int i = 0; i < bufString.length; i++) {
                    bufInt[i] = Integer.parseInt(bufString[i]);
                }
                dataRows.add(bufInt);
            }
            data = dataRows.toArray(new Integer[][]{});
            System.out.println("Data had been read from the file " + file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeToFile(String file) {
        try {
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), StandardCharsets.UTF_8));
            StringBuilder row = new StringBuilder();
            for (String s : header) {
                row.append(s);
                row.append(DELIMITER);
            }
            writer.write(row.toString());
            writer.newLine();

            for (int i = 0; i < data.length; i++) {
                Integer[] rowInt = data[i];
                row.delete(0, row.length());
                for (int j = 0; j < rowInt.length; j++) {
                    row.append(rowInt[i]);
                    row.append(DELIMITER);
                    
                }
                writer.write(row.toString());
                writer.newLine();
            }
            writer.flush();
            writer.close();
            System.out.println("Data recorded");
        } catch (IOException e) {
            e.getStackTrace();
        }
    }

}
