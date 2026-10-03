import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class clickerGame {
    public static void main(String[] args) {
        JFrame frame = new JFrame ("My app");
        JLabel label = new JLabel("0");
        JButton plus = new JButton("+");
        JButton minus = new JButton("-");
        JButton reset = new JButton("reset");

        frame.setLayout(new GridLayout(4,1));
        frame.setSize(300, 300);
        frame.add(label);
        frame.add(plus);
        frame.add(minus);
        frame.add(reset);

        frame.setVisible(true);

        plus.addActionListener(new ActionListener(){
          public void actionPerformed(ActionEvent e){
              int counter = Integer.parseInt(label.getText()); //reads the value of the label and converts it to int and assigns it to the variable called counter.
          counter++; //increment the value of counter
              label.setText(String.valueOf(counter));
             }
        });

        minus.addActionListener(new ActionListener(){
          public void actionPerformed(ActionEvent e){
              int counter = Integer.parseInt(label.getText()); //reads the value of the label and converts it to int and assigns it to the variable called counter.
          if (counter<=0){
              counter=0;
          }

          if (counter>0){
              counter--;
          }
              label.setText(String.valueOf(counter));
             }
        });

        reset.addActionListener(new ActionListener(){
          public void actionPerformed(ActionEvent e){
              int counter = Integer.parseInt(label.getText()); //reads the value of the label and converts it to int and assigns it to the variable called counter.
          counter=0; //increment the value of counter
              label.setText(String.valueOf(counter));
             }
        });

    }
}
