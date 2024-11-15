import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class guessingGui {
    public static void main(String[] args) {
        // Create random number
        Random rand = new Random();
        int randomNumber = rand.nextInt(100) + 1;

        // Create the frame
        JFrame frame = new JFrame("Number Guessing Game");
        frame.setSize(400, 300);
        frame.setLayout(new GridLayout(3, 1));

        // Input panel
        JPanel inputPanel = new JPanel(new FlowLayout());
        JTextField inputField = new JTextField(10);
        inputPanel.add(new JLabel("Enter your guess:"));
        inputPanel.add(inputField);

        // Buttons panel
        JPanel buttonPanel = new JPanel(new FlowLayout());
        JButton guessButton = new JButton("Guess");
        JButton quitButton = new JButton("Quit");
        buttonPanel.add(guessButton);
        buttonPanel.add(quitButton);

        // Result panel
        JPanel resultPanel = new JPanel(new FlowLayout());
        JLabel resultLabel = new JLabel("Make a guess!");
        resultPanel.add(resultLabel);

        // Add panels to frame
        frame.add(inputPanel);
        frame.add(buttonPanel);
        frame.add(resultPanel);

        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // State variables
        final int[] attempts = {1}; // Use array to allow modification within the ActionListener

        // Guess button logic
        guessButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int guess = Integer.parseInt(inputField.getText());
                    if (guess == randomNumber) {
                        resultLabel.setText("Correct! You won in " + attempts[0] + " attempts!");
                        guessButton.setEnabled(false); // Disable after winning
                    } else if (guess < randomNumber) {
                        resultLabel.setText("Incorrect. Guess higher.");
                    } else {
                        resultLabel.setText("Incorrect. Guess lower.");
                    }
                    attempts[0]++;
                } catch (NumberFormatException ex) {
                    resultLabel.setText("Please enter a valid number.");
                }
                inputField.setText(""); // Clear input
            }
        });

        // Quit button logic
        quitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame,
                        "You quit the game! The number was " + randomNumber + ".",
                        "Game Over",
                        JOptionPane.INFORMATION_MESSAGE);
                System.exit(0);
            }
        });
    }
}
