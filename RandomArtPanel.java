import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * InnerRandomArtPanel
 */
interface InnerRandomArtPanel {

    public void keyPressed(KeyEvent evt);

    // public void keyReleased(KeyEvent evt);

    // public void keyTyped(KeyEvent evt);
}

public class RandomArtPanel extends JPanel implements InnerRandomArtPanel {

    private class RepaintAction implements ActionListener {
        public void actionPerformed(ActionEvent evt) {
            repaint(); // Call the repaint() method in the panel class.
        }
    }

    private static final int SQUARE_SIZE = 0;
    private int squareLeft;
    private int squareTop;

    public RandomArtPanel() {
        RepaintAction action = new RepaintAction();
        Timer timer = new Timer(4000, action);
        timer.start();
    }

    public void paintComponent(Graphics g) {
    }

    public void keyPressed(KeyEvent evt) {
        int key = evt.getKeyCode(); // keyboard code for the pressed key
        if (key == KeyEvent.VK_LEFT) { // move the square left
            squareLeft -= 8;
            if (squareLeft < 3)
                squareLeft = 3;
            repaint();
        } else if (key == KeyEvent.VK_RIGHT) { // move the square right
            squareLeft += 8;
            if (squareLeft > getWidth() - 3 - SQUARE_SIZE)
                squareLeft = getWidth() - 3 - SQUARE_SIZE;
            repaint();
        } else if (key == KeyEvent.VK_UP) { // move the squre up
            squareTop -= 8;
            if (squareTop < 3)
                squareTop = 3;
            repaint();
        } else if (key == KeyEvent.VK_DOWN) { // move the square down
            squareTop += 8;
            if (squareTop > getHeight() - 3 - SQUARE_SIZE)
                squareTop = getHeight() - 3 - SQUARE_SIZE;
            repaint();
        }
    }
}