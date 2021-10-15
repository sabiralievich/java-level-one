package ru.gb.lesson8;

import java.util.Stack;

public class Calculator {
    private static String version = "v.0.1";
    public static String getVersion() {
        return " " + version;
    }

    public static void main(String[] args) {
        new MainWindow();
    }

    public static void calculate (String expression) {
        Double result = result(toRPN(expression));
        MainWindow.setInputText(String.valueOf(result));
    }
    private static String toRPN(String expression) {
        StringBuilder output = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        int priority;
        for (int i = 0; i < expression.length(); i++) {
            priority = getPriority(expression.charAt(i));
            if(priority == 0) {
                output.append(expression.charAt(i));
            }
            if(priority == 1) {
                stack.push(expression.charAt(i));
            }
            if(priority > 1) {
                output.append(' ');
                while (!stack.isEmpty()) {
                    if(getPriority(stack.peek()) >= priority) {
                        output.append(stack.pop());
                    } else {
                        break;
                    }
                }
                stack.push(expression.charAt(i));
            }
            if(priority == -1) {
                output.append(' ');
                while (getPriority(stack.peek()) != 1) {
                    output.append(stack.pop());
                    stack.pop();
                }
            }
        }
        while (!stack.isEmpty()) {
            output.append(stack.pop());
        }
        return output.toString();
    }

    private static int getPriority(char currentChar) {
        if(currentChar == 'x' || currentChar == '/') return 3;
        else if(currentChar == '+' || currentChar == '-') return 2;
        else if(currentChar == '(') return 1;
        else if(currentChar == ')') return -1;
        else return 0;
    }

    private static double result(String rpn) {
        StringBuilder operand = new StringBuilder();
        Stack<Double> stack = new Stack<>();
        for (int i = 0; i < rpn.length(); i++) {
            if(rpn.charAt(i) == ' ') {
                continue;
            }
            if(getPriority(rpn.charAt(i)) == 0) {
                while (rpn.charAt(i) != ' ' && getPriority(rpn.charAt(i)) ==0 ) {
                    operand.append(rpn.charAt(i++));
                    if(i == rpn.length()) {
                        break;
                    }
                }
                stack.push(Double.parseDouble(operand.toString()));
                operand = new StringBuilder();
            }
            if(getPriority(rpn.charAt(i)) > 1) {
                double a = stack.pop();
                double b = stack.pop();
                if(rpn.charAt(i) == '+') {
                    stack.push(b + a);
                }
                if(rpn.charAt(i) == '-') {
                    stack.push(b - a);
                }
                if(rpn.charAt(i) == 'x') {
                    stack.push(b * a);
                }
                if(rpn.charAt(i) == '/') {
                    stack.push(b / a);
                }
            }
        }
        return stack.pop();
    }
}
