import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class TipCalculatorLogic {
    private double billAmount;
    private double tipPercentage;

    public TipCalculatorLogic(double billAmount, double tipPercentage) {
        this.billAmount = billAmount;
        this.tipPercentage = tipPercentage;
    }

    public double calculateTip() {
        return billAmount * (tipPercentage / 100);
    }
}

public class TipCalculator {
    public static void main(String[] args) {
        // Create the frame
        JFrame frame = new JFrame("Tip Calculator");
        frame.setSize(400, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout(10, 10));
        frame.setResizable(false);

        // Create panel for input fields
        JPanel inputPanel = new JPanel(new GridLayout(2, 2, 5, 5));
        JLabel billLabel = new JLabel("Total Bill:");
        JTextField billField = new JTextField();
        JLabel tipLabel = new JLabel("Tip Percentage (%):");
        JTextField tipField = new JTextField();
        inputPanel.add(billLabel);
        inputPanel.add(billField);
        inputPanel.add(tipLabel);
        inputPanel.add(tipField);

        // Create panel for result
        JPanel resultPanel = new JPanel();
        JLabel resultLabel = new JLabel("Tip Amount: ");
        JLabel tipAmountLabel = new JLabel("$0.00");
        resultPanel.add(resultLabel);
        resultPanel.add(tipAmountLabel);

        // Create panel for button
        JPanel buttonPanel = new JPanel();
        JButton calculateButton = new JButton("Calculate Tip");
        buttonPanel.add(calculateButton);

        // Add panels to the frame
        frame.add(inputPanel, BorderLayout.NORTH);
        frame.add(buttonPanel, BorderLayout.CENTER);
        frame.add(resultPanel, BorderLayout.SOUTH);

        // Action Listener for button
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String billText = billField.getText();
                String tipText = tipField.getText();
                if (!billText.matches("\\d+(\\.\\d+)?") || !tipText.matches("\\d+(\\.\\d+)?")) {
                    JOptionPane.showMessageDialog(frame, "Please enter valid bill and tip amounts.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                double billAmount = Double.parseDouble(billText);
                double tipPercentage = Double.parseDouble(tipText);

                TipCalculatorLogic calculator = new TipCalculatorLogic(billAmount, tipPercentage);
                double tipAmount = calculator.calculateTip();
                tipAmountLabel.setText("$" + tipAmount);
            }
        });

        // Make the frame visible
        frame.setVisible(true);
    }
}
