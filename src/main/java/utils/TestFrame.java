package utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import java.awt.*;

public class TestFrame extends JFrame {

//    private static final Logger logger = LoggerFactory.getLogger(TestFrame.class);

    public static final int DEFAULT_WIDTH = 300;
    public static final int DEFAULT_HEIGHT = 200;

    public TestFrame() throws HeadlessException {
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }

    public TestFrame(JPanel panel) {
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        add(panel);
    }

    public static void test(JFrame frame, String title) {
        EventQueue.invokeLater(() -> {
            frame.setTitle(title);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }

    public static void test(Class<?> cls) {
        EventQueue.invokeLater(() -> {
            try {
                JFrame frame = (JFrame) cls.newInstance();
                frame.setTitle(cls.getSimpleName());
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            } catch (Exception ex) {
                ex.printStackTrace();
//                logger.error("test(Class cls),error",ex);
            }

        });
    }
}
