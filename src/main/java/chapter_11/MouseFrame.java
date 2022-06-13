package chapter_11;

import javax.swing.*;
import java.awt.*;

public class MouseFrame extends JFrame {

    public MouseFrame() throws HeadlessException {
        add(new MouseComponent());
        pack();
    }
}
