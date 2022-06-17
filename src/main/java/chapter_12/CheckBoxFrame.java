package chapter_12;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class CheckBoxFrame extends JFrame {

    private JLabel label;
    private JCheckBox bold;
    private JCheckBox italic;
    private static final int FONT_SIZE = 14;

    public CheckBoxFrame() throws HeadlessException {

        label = new JLabel("To be or not to be, this is a question...");
        add(label, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        ActionListener listener = event -> {
            int mode = 0;
            if( bold.isSelected() ) {
                mode += Font.BOLD;
            }
            if(italic.isSelected()) {
                mode += Font.ITALIC;
            }
            label.setFont(new Font("Serif", mode, FONT_SIZE));
        };

        bold = new JCheckBox("Bold");
        bold.setSelected(true);
        bold.addActionListener(listener);
        buttonPanel.add(bold);

        italic = new JCheckBox("Italic");
        italic.addActionListener(listener);
        buttonPanel.add(italic);

        add(buttonPanel, BorderLayout.SOUTH);
        pack();
    }
}
