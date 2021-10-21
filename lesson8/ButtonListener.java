package ru.gb.lesson8;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonListener implements ActionListener {

    private JTextField input = MainWindow.getInput();

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton pressed = (JButton) e.getSource();
        String pressedText = pressed.getText();
        if(pressedText.equals("C")){
            inputClear();
        } else if (pressedText.equals("=")) {
            calculateExpression(input.getText());
        } else
            {
                input.setText(input.getText() + pressedText);
            }
        }

    private void calculateExpression(String expression) {
        Calculator.calculate(expression);
    }


    private void inputClear() {
        input.setText("");
    }
}
