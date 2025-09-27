package ru.balybin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorGUI {
    private final MyCalculator calculator;
    private final JFrame frame;
    private final JTextField firstArgumentField;
    private final JTextField secondArgumentField;
    private final JTextField resultField;
    private final JLabel errorLabel;

    public CalculatorGUI() {
        calculator = new MyCalculator();

        // Создание главного окна
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new GridLayout(6, 2, 10, 10));

        // Создание компонентов
        firstArgumentField = new JTextField();
        secondArgumentField = new JTextField();
        resultField = new JTextField();
        resultField.setEditable(false); // Поле результата только для чтения

        errorLabel = new JLabel("");
        errorLabel.setForeground(Color.RED);

        // Добавление компонентов на форму
        frame.add(new JLabel("First Number:"));
        frame.add(firstArgumentField);

        frame.add(new JLabel("Second Number:"));
        frame.add(secondArgumentField);

        frame.add(new JLabel("Result:"));
        frame.add(resultField);

        frame.add(errorLabel);
        frame.add(new JLabel("")); // Пустая ячейка для выравнивания

        // Создание кнопок
        JButton plusButton = new JButton("+");
        JButton minusButton = new JButton("-");
        JButton multiplyButton = new JButton("*");
        JButton divideButton = new JButton("/");

        // Добавление кнопок на форму
        frame.add(plusButton);
        frame.add(minusButton);
        frame.add(multiplyButton);
        frame.add(divideButton);

        // Обработчики событий для кнопок
        plusButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculate("+");
            }
        });

        minusButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculate("-");
            }
        });

        multiplyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculate("*");
            }
        });

        divideButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculate("/");
            }
        });
    }

    public void show() {
        frame.setVisible(true);
    }

    private void calculate(String operation) {
        try {
            // Очистка предыдущих ошибок
            errorLabel.setText("");

            // Получение значений
            String firstArg = firstArgumentField.getText();
            String secondArg = secondArgumentField.getText();

            // аргументы
            calculator.setFirstArgument(Double.parseDouble(firstArg));
            calculator.setSecondArgument(Double.parseDouble(secondArg));

            // Выполнение операции
            double result = 0;
            switch (operation) {
                case "+":
                    result = calculator.sum(Double.parseDouble(firstArg), Double.parseDouble(secondArg));
                    calculator.onPlusClicked();
                    break;
                case "-":
                    result = calculator.subtract(Double.parseDouble(firstArg), Double.parseDouble(secondArg));
                    calculator.onMinusClicked();
                    break;
                case "*":
                    result = calculator.multiply(Double.parseDouble(firstArg), Double.parseDouble(secondArg));
                    calculator.onMultiplyClicked();
                    break;
                case "/":
                    result = calculator.divide(Double.parseDouble(firstArg), Double.parseDouble(secondArg));
                    calculator.onDivideClicked();
                    break;
            }

            // Отображение результата
            String resultStr = calculator.printResult(result);
            resultField.setText(resultStr);

        } catch (NumberFormatException e) {
            errorLabel.setText("Error: Invalid number format");
            calculator.displayError("Invalid number format");
        } catch (ArithmeticException e) {
            errorLabel.setText("Error: " + e.getMessage());
            calculator.displayError(e.getMessage());
        } catch (Exception e) {
            errorLabel.setText("Error: " + e.getMessage());
            calculator.displayError("Unexpected error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        // Запуск GUI в EDT (Event Dispatch Thread)
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                CalculatorGUI calculatorGUI = new CalculatorGUI();
                calculatorGUI.show();
            }
        });
    }
}

