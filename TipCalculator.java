import javax.swing.*;
import java.awt.*;

class TipCalculator {
    public static void main(String[] args) {
        // Create the frame
        JFrame frame = new JFrame("Tip Calculator");
        frame.setSize(500, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create panel for input fields
        JPanel inputPanel = new JPanel();
        JLabel billLabel = new JLabel("Total Bill:");
        JTextField billField = new JTextField(10);  // Set width of the text field
        JLabel tipLabel = new JLabel("Tip Percentage:");
        JTextField tipField = new JTextField(10);   // Set width of the text field
        inputPanel.add(billLabel);
        inputPanel.add(billField);
        inputPanel.add(tipLabel);
        inputPanel.add(tipField);

        // Create result panel
        JPanel resultPanel = new JPanel();
        JLabel resultLabel = new JLabel("Tip Amount: $0.00");
        resultPanel.add(resultLabel);

        // Create button panel
        JPanel buttonPanel = new JPanel();
        JButton calculateButton = new JButton("Calculate Tip");
        buttonPanel.add(calculateButton);

        // Add panels to frame
        frame.add(inputPanel, BorderLayout.NORTH);
        frame.add(buttonPanel, BorderLayout.CENTER);
        frame.add(resultPanel, BorderLayout.SOUTH);

        // Calculate button action
        calculateButton.addActionListener(e -> {
            String billText = billField.getText();
            String tipText = tipField.getText();
            if (!billText.isEmpty() && !tipText.isEmpty()) {
                double billAmount = Double.parseDouble(billText);
                double tipPercentage = Double.parseDouble(tipText);
                double tipAmount = billAmount * (tipPercentage / 100);
                resultLabel.setText("Tip Amount: $" + String.format("%.2f", tipAmount));
            }
        });

        // Show frame
        frame.setVisible(true);
    }
}
