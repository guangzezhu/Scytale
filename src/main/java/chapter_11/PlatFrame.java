package chapter_11;

import javax.swing.*;
import java.awt.*;

public class PlatFrame extends JFrame {
    private JPanel buttonPanel;

    public PlatFrame() throws HeadlessException {
        this.buttonPanel = new JPanel();

        UIManager.LookAndFeelInfo[] infos = UIManager.getInstalledLookAndFeels();
        for(UIManager.LookAndFeelInfo info : infos) {
            makeButton(info.getName(), info.getClassName());
        }

        add(buttonPanel);
        pack();
    }

    private void makeButton(String name, String className) {
        // add button to panel
        JButton button = new JButton(name);
        buttonPanel.add(button);

        // set button action
        button.addActionListener(event -> {
            // button action: switch to the new look-anf-feel
            try {
                UIManager.setLookAndFeel(className);
                SwingUtilities.updateComponentTreeUI(this);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
