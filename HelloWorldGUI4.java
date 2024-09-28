import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class HelloWorldGUI4 {
    public static void main(String[] args) {

        JPanel displayPanel = new JPanel() {
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawString("Hello Rajendra Pancholi!", 20, 30);
            }
        };
        JButton okButton = new JButton("OK");
        okButton.addActionListener(new ActionListener() {
            // An anonymous class that defines the listener object.
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        JPanel content = new JPanel();
        content.setLayout(new BorderLayout());
        content.add(displayPanel, BorderLayout.CENTER);
        content.add(okButton, BorderLayout.SOUTH);
        JFrame window = new JFrame("TicTacToe");
        window.setContentPane(content);
        window.setSize(400, 450);
        window.setLocation(100, 100);
        window.setVisible(true);
    }
}