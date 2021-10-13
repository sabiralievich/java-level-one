package ru.gb.lesson7;

public class Variables {
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_BLUE = "\u001B[34m";
    private static final String ANSI_RED = "\u001b[35;1m";

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

    public static String printRed(String s) {
        return ANSI_RED + s + ANSI_RESET;
    }
    public static String printBlue(String s) {
        return ANSI_BLUE + s + ANSI_RESET;
    }
    public static String printGreen(String s) {
        return ANSI_GREEN + s + ANSI_RESET;
    }
}
