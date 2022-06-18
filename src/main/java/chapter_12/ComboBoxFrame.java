package chapter_12;

import utils.TestFrame;

import javax.swing.*;
import java.awt.*;

public class ComboBoxFrame extends JFrame {

    private JComboBox<String> faceCombo;
    private JLabel label;
    private static final int DEFAULT_SIZE = 24;

    public ComboBoxFrame() {
        label = new JLabel("To be or not to be, this is a question...");
        label.setFont(new Font("Serif", Font.PLAIN, DEFAULT_SIZE));
        add(label, BorderLayout.CENTER);

        // make a combo box and add face names

        faceCombo = new JComboBox<>();
        faceCombo.addItem("Serif");
        faceCombo.addItem("SanSerif");
        faceCombo.addItem("Monospaced");
        faceCombo.addItem("Dialog");
        faceCombo.addItem("DialogInput");

        // the combo box listener changes the label font to the selected face name
        faceCombo.addActionListener(event -> {
            label.setFont(
                    new Font(faceCombo.getItemAt(faceCombo.getSelectedIndex()),
                            Font.PLAIN, DEFAULT_SIZE));
        });

        // add combo box to panel at the frame's southern border
        JPanel comboPanel = new JPanel();
        comboPanel.add(faceCombo);
        add(comboPanel, BorderLayout.SOUTH);
        pack();
    }

    public static void main(String[] args) {
        TestFrame.test(ComboBoxFrame.class);
    }
}
