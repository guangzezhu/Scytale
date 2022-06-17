package chapter_12;

import javafx.scene.control.RadioButton;

import javax.swing.*;
import java.awt.*;

public class RadioButtonFrame extends JFrame {

    private JPanel buttonPanel;
    private ButtonGroup buttonGroup;
    private JLabel label;
    private static final int DEFAULT_SIZE = 36;

    public RadioButtonFrame() {

        label = new JLabel("To be or not to be, this is a question...");
        label.setFont(new Font("Serif", Font.PLAIN, DEFAULT_SIZE));
        add(label, BorderLayout.CENTER);

        buttonPanel = new JPanel();
        buttonGroup = new ButtonGroup();

        addRadioButton("Small", 8);
        addRadioButton("Medium", 12);
        addRadioButton("Large", 18);
        addRadioButton("Extra", 36);

        add(buttonPanel, BorderLayout.SOUTH);
        pack();
    }

    private void addRadioButton(String name, int size) {
        boolean isSelected = size == DEFAULT_SIZE;
        JRadioButton radioButton = new JRadioButton(name, isSelected);
        radioButton.addActionListener(event -> {
            label.setFont(new Font("Serif", Font.PLAIN, size));
        });
        buttonGroup.add(radioButton);
        buttonPanel.add(radioButton);
    }
}
