package chapter_12;

import javax.swing.*;
import java.awt.*;

public class TextComponentFrameTest {

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            TextComponentFrame frame = new TextComponentFrame();
            frame.setTitle("Text Component");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}
