package chapter_12;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuFrame extends JFrame {
    private final static Logger logger = LoggerFactory.getLogger(MenuFrame.class);

    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 200;
    private Action saveAction;
    private Action saveAsAction;
    private JCheckBoxMenuItem readOnlyItem;
    private JPopupMenu popup;

    class TestAction extends AbstractAction {
        public TestAction(String name) {
            super(name);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            logger.info("{} selected.", getValue(Action.NAME));
        }
    }

    public MenuFrame() throws HeadlessException {
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

        JMenu fileMenu = new JMenu("File");
        fileMenu.add(new TestAction("New"));

        JMenuItem openItem = fileMenu.add(new TestAction("Open"));
        openItem.setAccelerator(KeyStroke.getKeyStroke("ctrl O"));

        fileMenu.addSeparator();

        saveAction = new TestAction("Save");
        JMenuItem saveItem = fileMenu.add(saveAction);
        saveItem.setAccelerator(KeyStroke.getKeyStroke("ctrl S"));

        saveAsAction = new TestAction("Save As");
        fileMenu.add(saveAsAction);
        fileMenu.addSeparator();

        fileMenu.add(new AbstractAction("Exit") {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        readOnlyItem = new JCheckBoxMenuItem("Read-only");
        readOnlyItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean saveOk = !readOnlyItem.isSelected();
                saveAction.setEnabled(saveOk);
                saveAsAction.setEnabled(saveOk);
            }
        });

        ButtonGroup group = new ButtonGroup();

        JRadioButtonMenuItem insertItem = new JRadioButtonMenuItem("Insert");
        insertItem.setSelected(true);
        JRadioButtonMenuItem overTypeItem = new JRadioButtonMenuItem("Over Type");

        group.add(insertItem);
        group.add(overTypeItem);

        // demonstrate
        Action cutAction = new TestAction("Cut");
        cutAction.putValue(Action.SMALL_ICON, new ImageIcon("image/icon-png"));
        Action copyAction = new TestAction("Copy");
        copyAction.putValue(Action.SMALL_ICON, new ImageIcon("image/icon-png"));
        Action pasteAction = new TestAction("Paste");
        pasteAction.putValue(Action.SMALL_ICON, new ImageIcon("image/icon-png"));

        JMenu editMenu = new JMenu();
        editMenu.add(cutAction);
        editMenu.add(copyAction);
        editMenu.add(pasteAction);

        // demonstrate mnemonics
    }
}
