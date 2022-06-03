package chapter_10;

import javax.swing.*;
import java.awt.*;

public class NotHelloWorld {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            NotHelloWorldFrame frame = new NotHelloWorldFrame();
            frame.setTitle("chapter_10.NotHelloWorld");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}

class NotHelloWorldFrame extends JFrame {
    public NotHelloWorldFrame() throws HeadlessException {
        add(new NotHelloWorldComponent());
        pack();
    }
}

class NotHelloWorldComponent extends JComponent {

    public static final int MESSAGE_X = 75;
    public static final int MESSAGE_Y = 100;

    public static final int DEFAULT_WIDTH = 300;
    public static final int DEFAULT_HEIGHT = 200;

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawString("Not a Hello, World program", MESSAGE_X, MESSAGE_Y);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }
}
