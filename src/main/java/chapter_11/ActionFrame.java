package chapter_11;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ActionFrame extends JFrame {

    private JPanel buttonPanel;
    public static final int DEFAULT_WIDTH = 300;
    public static final int DEFAULT_HEIGHT = 200;

    public ActionFrame() throws HeadlessException {
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        buttonPanel = new JPanel();

        // define actions
        Action yellowAction = new ColorAction("Yellow", new ImageIcon("resource/img/icon.png"), Color.YELLOW);
        Action blueAction = new ColorAction("Blue", new ImageIcon("resource/img/icon.png"), Color.BLUE);
        Action redAction = new ColorAction("Red", new ImageIcon("resource/img/icon.png"), Color.RED);
        
        // add buttons for these actions
        buttonPanel.add(new JButton(yellowAction));
        buttonPanel.add(new JButton(blueAction));
        buttonPanel.add(new JButton(redAction));
        
        // add panel to frame
        add(buttonPanel);
        
        // association the Y, B, and R keys with names
        InputMap imap = buttonPanel.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        imap.put(KeyStroke.getKeyStroke("ctrl Y"), "panel.yellow");
        imap.put(KeyStroke.getKeyStroke("ctrl B"), "panel.blue");
        imap.put(KeyStroke.getKeyStroke("ctrl R"), "panel.red");
        
        // association the name with actions
        ActionMap actionMap = buttonPanel.getActionMap();
        actionMap.put("panel.yellow", yellowAction);
        actionMap.put("panel.blue", blueAction);
        actionMap.put("panel.red", redAction);
    }

    public class ColorAction extends AbstractAction {
        public ColorAction(String name, Icon icon, Color c) {
            putValue(Action.NAME, name);
            putValue(Action.SMALL_ICON, icon);
            putValue(Action.SHORT_DESCRIPTION, "Set panel color to " + name.toLowerCase());
            putValue("color", c);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            Color c = (Color) getValue("color");
            buttonPanel.setBackground(c);
        }
    }
}