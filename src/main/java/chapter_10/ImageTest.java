package chapter_10;

import javax.swing.*;
import java.awt.*;

/**
 * http://www.cppcns.com/ruanjian/java/437555.html
 */
public class ImageTest {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            ImageFrame frame = new ImageFrame();
            frame.setTitle("chapter_10.ImageTest");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}

class ImageFrame extends JFrame {
    public ImageFrame() throws HeadlessException {
        add(new ImageComponent());
        pack();
    }
}

class ImageComponent extends JComponent {

    public static final int DEFAULT_WIDTH = 800;
    public static final int DEFAULT_HEIGHT = 800;

    private Image image;

    public ImageComponent() {
        String path = "image/icon.png";
        this.image = new ImageIcon(ClassLoader.getSystemResource(path)).getImage();
    }

    @Override
    protected void paintComponent(Graphics g) {
        if( image == null ) return;

        int imageWidth = this.image.getWidth(this);
        int imageHeight = this.image.getHeight(this);

        g.drawImage(image, 0, 0, null);

        for(int i = 0; i * imageWidth <= getWidth(); i++) {
            for(int j = 0; j * imageHeight <= getHeight(); j++) {
                if((i + j) >0 ) {
                    g.copyArea(0, 0, imageWidth, imageHeight, i * imageWidth, j *  imageHeight);
                }
            }
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }
}
