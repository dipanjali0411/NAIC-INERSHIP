import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator extends JFrame implements ActionListener {

    // Components
    JTextField display;
    JButton[] numberButtons = new JButton[10];
    JButton addButton, subButton, mulButton, divButton, eqButton, clrButton;
    JPanel panel;

    // Variables
    double num1 = 0, num2 = 0, result = 0;
    char operator;

    public Calculator() {
        setTitle("Simple Calculator");
        setSize(400, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        display = new JTextField();
        display.setBounds(30, 30, 320, 50);
        display.setEditable(false);
        add(display);

        // Buttons
        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        eqButton = new JButton("=");
        clrButton = new JButton("C");

        // Number Buttons
        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
        }

        // Operator Buttons
        JButton[] ops = { addButton, subButton, mulButton, divButton, eqButton, clrButton };
        for (JButton b : ops) {
            b.addActionListener(this);
        }

        // Panel for buttons
        panel = new JPanel();
        panel.setBounds(30, 100, 320, 300);
        panel.setLayout(new GridLayout(4, 4, 10, 10));

        // Add buttons to panel
        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);

        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subButton);

        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(mulButton);

        panel.add(clrButton);
        panel.add(numberButtons[0]);
        panel.add(eqButton);
        panel.add(divButton);

        add(panel);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numberButtons[i]) {
                display.setText(display.getText() + i);
            }
        }

        if (e.getSource() == addButton) {
            num1 = Double.parseDouble(display.getText());
            operator = '+';
            display.setText("");
        }

        if (e.getSource() == subButton) {
            num1 = Double.parseDouble(display.getText());
            operator = '-';
            display.setText("");
        }

        if (e.getSource() == mulButton) {
            num1 = Double.parseDouble(display.getText());
            operator = '*';
            display.setText("");
        }

        if (e.getSource() == divButton) {
            num1 = Double.parseDouble(display.getText());
            operator = '/';
            display.setText("");
        }

        if (e.getSource() == eqButton) {
            num2 = Double.parseDouble(display.getText());
            switch (operator) {
                case '+': result = num1 + num2; break;
                case '-': result = num1 - num2; break;
                case '*': result = num1 * num2; break;
                case '/':
                    if (num2 == 0) {
                        display.setText("Error");
                        return;
                    } else {
                        result = num1 / num2;
                    }
                    break;
            }
            display.setText(String.valueOf(result));
        }

        if (e.getSource() == clrButton) {
            display.setText("");
            num1 = 0;
            num2 = 0;
            result = 0;
        }
    }

    public static void main(String[] args) {
        new Calculator();
    }
}
