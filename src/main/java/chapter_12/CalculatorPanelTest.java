package chapter_12;

import oracle.jrockit.jfr.JFR;
import utils.TestFrame;

import javax.swing.*;
import java.awt.*;

public class CalculatorPanelTest {

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            TestFrame frame = new TestFrame(new CalculatorPanel());
            frame.setTitle("Calculator");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}