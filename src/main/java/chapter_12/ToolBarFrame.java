package chapter_12;

import utils.TestFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ToolBarFrame extends JFrame {

    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 200;
    private JPanel panel;

    public ToolBarFrame() throws HeadlessException {
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

        // add a panel for color change
        panel = new JPanel();
        add(panel, BorderLayout.CENTER);

        // set up actions
        Action blueAction = new ColorAction("Blue", TestFrame.getImageIcon("image/blue-icon.png"), Color.BLUE);
        Action yellowAction = new ColorAction("Yellow", TestFrame.getImageIcon("image/yellow-icon.png"), Color.YELLOW);
        Action redAction = new ColorAction("Red", TestFrame.getImageIcon("image/red-icon.png"), Color.RED);

        Action exitAction = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        };
        exitAction.putValue(Action.SHORT_DESCRIPTION, "Exit");
        exitAction.putValue(Action.SMALL_ICON, TestFrame.getImageIcon("image/exit-icon.png"));

        // populate toolbar
        JToolBar bar = new JToolBar();
        bar.add(blueAction);
        bar.add(yellowAction);
        bar.add(redAction);
        bar.add(exitAction);
        add(bar, BorderLayout.NORTH);

        // populate menu
        JMenu menu = new JMenu("Color");
        menu.add(blueAction);
        menu.add(yellowAction);
        menu.add(redAction);
        menu.addSeparator();
        menu.add(exitAction);
        JMenuBar menuBar = new JMenuBar();
        menuBar.add(menu);
        setJMenuBar(menuBar);
    }

    class ColorAction extends AbstractAction {
        public ColorAction(String name, Icon icon, Color c) {
            putValue(Action.NAME, name);
            putValue(Action.SMALL_ICON, icon);
            putValue(Action.SHORT_DESCRIPTION, name + " background");
            putValue("Color", c);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            Color c = (Color) getValue("Color");
            panel.setBackground(c);
        }
    }

    public static void main(String[] args) {
        TestFrame.test(ToolBarFrame.class);
    }
}
