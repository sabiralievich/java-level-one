package ru.gb.lesson8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Objects;

public class MainWindow extends JFrame {
        private static JTextField input = new JTextField();

    public MainWindow() {

        setTitle("Calculator" + Calculator.getVersion());
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(300, 300, 400, 400);
        setLayout(new BorderLayout());
        add(input = (JTextField) getTopJPanel().getComponent(0), BorderLayout.NORTH);
        add(getCenterPanel(), BorderLayout.CENTER);
        add(getRightPanel(), BorderLayout.EAST);
        setVisible(true);
    }

    public static JTextField getInput() {
        return input;
    }
    public static void setInputText(String result) {
        input.setText(result);
    }
    private JPanel getTopJPanel() {
        JPanel top = new JPanel();
        top.setLayout(new BorderLayout());
        JTextField input = new JTextField();
        input.setPreferredSize( new Dimension( 50, 48 ) );
        input.setEditable(false);
        top.add(input, BorderLayout.NORTH);
        return top;
    }

    private JPanel getCenterPanel() {
        JPanel center = new JPanel();
        center.setLayout(new GridLayout(4, 3));
        for (JButton button : Objects.requireNonNull(getOpearators("center")))  { //Это IntelliJIdea написал, у меня просто вот так было: for (JButton button : getOpearators("center"))
            center.add(button);
        }

        for (int i = 1; i <= 9; i++) {
            center.add(getDigits(i));
        }
        return center;
    }
    private JPanel getRightPanel() {
        JPanel right = new JPanel();
        right.setLayout(new GridLayout(3, 3));
        for(JButton button : Objects.requireNonNull(getOpearators("EAST"))) {
            right.add(button);
        }
        return right;
    }

    private JButton[] getOpearators(String panel) {
        ActionListener buttonListener = new ButtonListener();
        if(panel.equals("center")){
            JButton equal = new JButton("=");
            JButton clear = new JButton("C");
            JButton zero = new JButton("0");
            equal.addActionListener(buttonListener);
            clear.addActionListener(buttonListener);
            zero.addActionListener(buttonListener);
            return new JButton[]{clear, zero, equal};
        }
        if(panel.equals("EAST")) {
            JButton plus = new JButton("+");
            JButton minus = new JButton("-");
            JButton divide = new JButton("/");
            JButton multiply = new JButton("x");

            JButton leftBracket = new JButton("(");
            JButton rightBracket = new JButton(")");
            leftBracket.addActionListener(buttonListener);
            rightBracket.addActionListener(buttonListener);
            minus.addActionListener(buttonListener);
            plus.addActionListener(buttonListener);
            divide.addActionListener(buttonListener);
            multiply.addActionListener(buttonListener);

            return new JButton[]{plus, minus, divide, multiply, leftBracket, rightBracket};
        }
        return null;
    }

    private JButton getDigits(int n) {
        ActionListener buttonListener = new ButtonListener();
        JButton button = (JButton)add(new JButton(String.valueOf(n)));
        button.addActionListener(buttonListener);
        return button;

    }
}
