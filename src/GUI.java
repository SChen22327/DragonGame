import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUI implements ActionListener, KeyListener {
    public GUI() {
        init();
    }

    private void init() {
        JFrame frame = new JFrame("Dragon Slayer");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(500, 400);
        frame.setLocation(300, 50);

        JTextField input = new JTextField();
        JPanel top = new JPanel();
        top.add(input);


        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
