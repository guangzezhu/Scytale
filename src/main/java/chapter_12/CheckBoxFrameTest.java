package chapter_12;

import javax.swing.*;
import java.awt.*;

public class CheckBoxFrameTest {

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            CheckBoxFrame frame = new CheckBoxFrame();
            frame.setTitle("CheckBox");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}
