package ru.gb.lesson4;


import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
    private static final int SIZE = 5;
    private static final char DOT_EMPTY = '·';
    private static final char DOT_HUMAN = 'X';
    private static final char DOT_AI= '0';

    private static final String HEADER_FIRST_SYMBOL = "*";
    private static final String SPACE_MAP = " ";


    static final char[][] MAP = new char[SIZE][SIZE];
    private static final Random random = new Random();
    private static final Scanner in = new Scanner(System.in);

    private static int turnsCount;

    private static final int POINTS_TO_WIN = 3;
    private static int rowNumber;
    private static int columnNumber;

    public static void main(String[] args) {

        launchGame();

    }

    private static void launchGame() {
        do {
            initMap();
            printMap();
            playGame();
        } while (isContinueGame());

    }




    private static void initMap() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                MAP[i][j] = DOT_EMPTY;
            }
        }
    }
    private static void printMap() {
        printHeaderMap();

        printBodyMap();
    }

    private static void printBodyMap() {
        for (int i = 0; i < SIZE; i++) {
            printMapNumber(i);
            for (int j = 0; j < SIZE; j++) {
                System.out.print(MAP[i][j] + SPACE_MAP);
            }
            System.out.println();
        }
    }

    private static void printMapNumber(int i) {
        System.out.print(i + 1 + SPACE_MAP);
    }

    private static void printHeaderMap() {
        System.out.print(HEADER_FIRST_SYMBOL + SPACE_MAP);
        for (int i = 0; i < SIZE; i++) {
            printMapNumber(i);
        }
        System.out.println();
    }
    private static void playGame() {
        while (true) {
            humanTurn();

            printMap();
            if (checkEnd(DOT_HUMAN)) {
                break;
            }

            aiTurn();
            printMap();
            if (checkEnd(DOT_AI)) {
                break;
            }        }


    }



    private static void aiTurn()
        {
            System.out.println("Ходит компьютер...");

            do {
                rowNumber = random.nextInt(SIZE);
                columnNumber = random.nextInt(SIZE);

            } while (!isCellFree(rowNumber, columnNumber));

            MAP[rowNumber][columnNumber] = DOT_AI;
            turnsCount++;
        }

    private static void humanTurn() {
        System.out.println("Ваш ход, пожалуйста!");

        do {
            rowNumber = getValidNumber() - 1;
            columnNumber = getValidNumber() - 1;
            if (isCellFree(rowNumber, columnNumber)) {
                break;
            } else {
                System.out.println("\nЯчейка занята");
            }
        } while (true);

        MAP[rowNumber][columnNumber] = DOT_HUMAN;
        turnsCount++;
    }

    private static boolean isCellFree(int rowNumber, int columnNumber) {
        return MAP[rowNumber][columnNumber] == DOT_EMPTY;
    }

    private static int getValidNumber() {
        do {
            System.out.print("Введите координату: ");
            if ( in.hasNextInt()) {
                int n = in.nextInt();
                if (isNumberValid(n)) {
                    System.out.println("Координата " + n + " принята");
                    return n;
                }
                System.out.println("\nЗначение координаты должно быть от 1 до " + SIZE);
            } else {
                System.out.println("\nПожалуйста, введите целое число.");
                in.next();
            }
        } while (true);
    }

    private static boolean isNumberValid(int n) {
        return n >=1 && n <= SIZE;
    }

    private static boolean checkEnd(char player) {
        if (checkWin(player)) {
            if (player == DOT_HUMAN) {
                System.out.println("\nВы победили!");
            } else {
                System.out.println("\nВы проиграли..");
            }
            return true;
        }
        if (checkDraw()) {
            System.out.println("\nНичья");
            return true;
        }
        return false;
    }

    private static boolean checkDraw() {
        return turnsCount == SIZE * SIZE;
    }

    private static boolean checkWin(char player) {

        if (checkHorisontal(player)) {
            return true;
        }
        if (checkVertical(player)) {
            return true;
        }
        if (checkMainDia(player)) {

            return true;
        }
        if (checkAddDia(player)) {
            return true;
        }
        return false;
    }

    // метод для проверки победы на диагонали, параллельной побочной.
    private static boolean checkAddDia(char player) {
       int n = 1;
        for (int i = 1, j = 1; i <= 2 && j <= 2 ; i++, j++) {
            if (((rowNumber - i) >= 0) &&  ((columnNumber + j) <  SIZE)) {
                if((MAP[rowNumber-i][columnNumber+j]) == player) {
                    n++;
                }
            }
            if (((rowNumber + i) < SIZE) &&  ((columnNumber - j) >=  0)) {
                if((MAP[rowNumber+i][columnNumber-j]) == player) {
                    n++;
                }
            }
            if (n == POINTS_TO_WIN) {
                return true;
        }
        }
        return false;
    }

    // Метод для проверки победы на диагонали, переллельной основной.
    // Более криво написать не сумел...
    private static boolean checkMainDia(char player) {
        int n = 0;
        int leftCorner = 0;
        if (rowNumber - columnNumber > 0) {
            leftCorner = rowNumber - columnNumber;
            for (int i = leftCorner, j = 0; i < SIZE && j < SIZE; i++, j++) {

                    if(MAP[i][j] == player) {
                        n++;
                    } else n = 0;

                if (n == POINTS_TO_WIN) {
                    return true;
                }
            }
        }
        if (rowNumber - columnNumber < 0) {
            leftCorner = columnNumber - rowNumber;
            for (int i = leftCorner, j = 0; i < SIZE && j < SIZE; i++, j++) {

                if(MAP[j][i] == player) {
                    n++;
                } else n = 0;

                if (n == POINTS_TO_WIN) {
                    return true;
                }
            }
        }
        if (rowNumber - columnNumber == 0) {
            for (int i = 0, j = 0; i < SIZE && j < SIZE; i++, j++) {

                if(MAP[j][i] == player) {
                    n++;
                } else n = 0;

                if (n == POINTS_TO_WIN) {
                    return true;
                }
            }
        }
        return false;

    }

    private static boolean checkVertical(char player) {
        int n = 0;
        for (int i = 0; i < SIZE; i++) {
            if ((MAP[i][columnNumber]) == player) {
                n++;
            } else n = 0;
            if (n == POINTS_TO_WIN) {
                return true;
            }

        }
        return false;
    }

    private static boolean checkHorisontal(char player) {
        int n = 0;
        for (int j = 0; j < SIZE; j++) {
            if ((MAP[rowNumber][j]) == player) {
                n++;
            } else n = 0;
            if (n == POINTS_TO_WIN) {
                return true;
            }

        }
        return false;
    }
    private static boolean isContinueGame() {
        System.out.println("Сыграть еще? y/n");
        return switch (in.next()) {
            case "y" -> true;
            default -> false;
        };
    }
}
