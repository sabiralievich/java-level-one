package ru.gb.lesson7;

public class Variables {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_RED = "\u001b[35;1m";

    public static void printBySymbol(String str){
        char [] myCharArray = str.toCharArray ();
        for(char ch:myCharArray){
            System.out.print(ch);
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }
}
