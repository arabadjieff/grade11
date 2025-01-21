import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TemperatureConverter {
    public static void main(String[] args) {
        // Create the frame
        JFrame frame = new JFrame("Temperature Converter");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        // Input label and text field
        JLabel inputLabel = new JLabel("Enter Temperature:");
        inputLabel.setBounds(50, 50, 150, 25);
        frame.add(inputLabel);

        JTextField inputField = new JTextField();
        inputField.setBounds(200, 50, 100, 25);
        frame.add(inputField);

        // Conversion type labels and buttons
        JLabel convertLabel = new JLabel("Convert To:");
        convertLabel.setBounds(50, 100, 100, 25);
        frame.add(convertLabel);

        JButton toFahrenheitButton = new JButton("To Fahrenheit");
        toFahrenheitButton.setBounds(50, 130, 150, 30);
        frame.add(toFahrenheitButton);

        JButton toCelsiusButton = new JButton("To Celsius");
        toCelsiusButton.setBounds(210, 130, 150, 30);
        frame.add(toCelsiusButton);

        JButton toKelvinButton = new JButton("To Kelvin");
        toKelvinButton.setBounds(50, 170, 150, 30);
        frame.add(toKelvinButton);

        // Result label
        JLabel resultLabel = new JLabel("Result:");
        resultLabel.setBounds(50, 220, 300, 25);
        frame.add(resultLabel);

        // Button action listeners
        toFahrenheitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String inputText = inputField.getText();
                if (isNumeric(inputText)) {
                    double inputTemp = Double.parseDouble(inputText);
                    double result = (inputTemp * 9 / 5) + 32;
                    resultLabel.setText("Result: " + result + " Fahrenheit");
                } else {
                    resultLabel.setText("Invalid input. Please enter a numeric value.");
                }
            }
        });

        toCelsiusButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String inputText = inputField.getText();
                if (isNumeric(inputText)) {
                    double inputTemp = Double.parseDouble(inputText);
                    double result = (inputTemp - 32) * 5 / 9;
                    resultLabel.setText("Result: " + result + " Celsius");
                } else {
                    resultLabel.setText("Invalid input. Please enter a numeric value.");
                }
            }
        });

        toKelvinButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String inputText = inputField.getText();
                if (isNumeric(inputText)) {
                    double inputTemp = Double.parseDouble(inputText);
                    double result = inputTemp + 273.15;
                    resultLabel.setText("Result: " + result + " Kelvin");
                } else {
                    resultLabel.setText("Invalid input. Please enter a numeric value.");
                }
            }
        });

        // Make the frame visible
        frame.setVisible(true);
    }

    private static boolean isNumeric(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (!Character.isDigit(c) && c != '.' && c != '-') {
                return false;
            }
        }
        return true;
    }
}
