import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BMICalculator {
    public static void main(String[] args) {
        JFrame frame = new JFrame("BMI Calculator");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(3, 1));

        //panel for height and weight
        JPanel inputPanel = new JPanel(new FlowLayout());
        JTextField heightField = new JTextField(15);
        JTextField weightField = new JTextField(15);
        inputPanel.add(new JLabel("Enter Height (cm):"));
        inputPanel.add(heightField);
        inputPanel.add(new JLabel("Enter Weight (kg):"));
        inputPanel.add(weightField);

        //panel for butons
        JPanel buttonPanel = new JPanel(new FlowLayout());
        JButton calculateButton = new JButton("Calculate BMI");
        JButton resetButton = new JButton("Reset");
        buttonPanel.add(calculateButton);
        buttonPanel.add(resetButton);

        //panel for result
        JPanel resultPanel = new JPanel(new FlowLayout());
        JLabel resultLabel = new JLabel("Enter your details to calculate BMI.");
        resultPanel.add(resultLabel);

        //make frame visible and adds stuff to it
        frame.add(inputPanel);
        frame.add(buttonPanel);
        frame.add(resultPanel);
        frame.setVisible(true);

        //calc button
        calculateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String heightText = heightField.getText();
                String weightText = weightField.getText();

                if (heightText.isEmpty() || weightText.isEmpty()) {
                    resultLabel.setText("Fill in both fields!");
                    return;
                }

                // Validate if the input is a valid number
                if (isValidNumber(heightText) && isValidNumber(weightText)) {
                    double height = Double.parseDouble(heightText);
                    double weight = Double.parseDouble(weightText);

                    double bmi = weight / (height * height / 10000); // Calculate BMI
                    String status = getBMICategory(bmi);

                    resultLabel.setText("BMI: " + bmi + " - " + status);  // Simple string concatenation
                } else {
                    resultLabel.setText("Enter valid numbers!");
                }
            }
        });

        //reset button
        resetButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                heightField.setText("");
                weightField.setText("");
                resultLabel.setText("Enter your details to calculate BMI");
            }
        });
    }

    //validation
    public static boolean isValidNumber(String str) {
        if (str == null || str.trim().isEmpty()) {
            return false;
        }
        for (char c : str.toCharArray()) {
            if (!Character.isDigit(c) && c != '.') {
                return false;
            }
        }
        return true;
    }

    //determine obesity
    private static String getBMICategory(double bmi) {
        if (bmi <= 18.5) {
            return "Underweight";
        } else if (bmi < 25) {
            return "Normal weight";
        } else if (bmi < 30) {
            return "Overweight";
        } else {
            return "Obese";
        }
    }
}
