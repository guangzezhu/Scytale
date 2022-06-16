package utils;

import javax.swing.*;
import java.awt.*;

public class TestFrame extends JFrame {

    public static final int DEFAULT_WIDTH = 300;
    public static final int DEFAULT_HEIGHT = 200;

    public TestFrame() throws HeadlessException {
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }

    public TestFrame(JPanel panel) {
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        add(panel);
    }
}
