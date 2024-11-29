import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class guessingGui {
    public static void main(String[] args) {
        Random rand = new Random();
        int randomNumber = rand.nextInt(100) + 1;

        JFrame frame = new JFrame("The Greatest Guessing Game");
        frame.setSize(400, 300);
        frame.setLayout(new GridLayout(3, 1));

        JPanel inputPanel = new JPanel(new FlowLayout());
        JTextField inputField = new JTextField(10);
        inputPanel.add(new JLabel("Enter your guess:"));
        inputPanel.add(inputField);

        JPanel buttonPanel = new JPanel(new FlowLayout());
        JButton guessButton = new JButton("Guess");
        JButton quitButton = new JButton("Quit");
        buttonPanel.add(guessButton);
        buttonPanel.add(quitButton);

        JPanel resultPanel = new JPanel(new FlowLayout());
        JLabel resultLabel = new JLabel("Make a guess!");
        resultPanel.add(resultLabel);

        //add stuff to the frame
        frame.add(inputPanel);
        frame.add(buttonPanel);
        frame.add(resultPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        // track attempts, realno ne znam dali nqma da mi e po-lesno da ne e class
        class AttemptTracker {
            private int attempts = 1;

            public int getAttempts() {
                return attempts;
            }

            public void increment() {
                attempts++;
            }
        }

        AttemptTracker attemptTracker = new AttemptTracker();

        guessButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String inputText = inputField.getText();
                if (isNumeric(inputText)) {
                    int guess = Integer.parseInt(inputText);
                    if (guess == randomNumber) {
                        resultLabel.setText("Correct! You won in " + attemptTracker.getAttempts() + " attempts!");
                        guessButton.setEnabled(false);
                    } else if (guess < randomNumber) {
                        resultLabel.setText("Incorrect. Guess higher.");
                    } else {
                        resultLabel.setText("Incorrect. Guess lower.");
                    }
                    attemptTracker.increment();
                } else {
                    resultLabel.setText("Please enter a valid number.");
                }
                inputField.setText(""); //pochisti textbox
            }

            // Helper method to validate numeric input
            private boolean isNumeric(String str) {
                if (str == null || str == "") return false;
                for (int i = 0; i < str.length(); i++) {
                    if (str.charAt(i) < '0' || str.charAt(i) > '9') return false;
                }
                return true;
            }
        });

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
