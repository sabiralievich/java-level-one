package ru.gb;

import java.util.HashMap;
import java.util.Map;

public class PhoneBook extends HashMap<String, String> {
    public PhoneBook() {
        this.put("+19034538353", "Peter");
        this.put("+10349343233", "Gabriel");
        this.put("+50483238380", "Peter");
        this.put("+79013853432", "Nancy");
    }

    public void add(String name, String phoneNumber) {
        this.put(name, phoneNumber);
    }
    public void get(String name) {
        for (Map.Entry<String, String> record : this.entrySet()) {
            if(record.getValue().equals(name)) {
                System.out.print(record.getValue() + ": ");
                System.out.println(record.getKey());
            }
        }
    }
}
