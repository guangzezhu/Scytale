package chapter_12;

import utils.TestFrame;

import javax.swing.*;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.util.Dictionary;
import java.util.Hashtable;

public class SliderFrame extends JFrame {
    private JPanel sliderPanel;
    private JTextField textField;
    private ChangeListener listener;

    public SliderFrame() {
        sliderPanel = new JPanel();
        sliderPanel.setLayout(new GridLayout());

        // common listener for all sliders
        listener = event -> {
          JSlider source = (JSlider)  event.getSource();
          textField.setText("" + source.getValue());
        };

        // add a plain slider
        JSlider slider = new JSlider();
        addSlider(slider, "Plain");

        // add a slider with major an minor tricks
        slider = new JSlider();
        slider.setPaintTicks(true);
        slider.setMajorTickSpacing(20);
        slider.setMinorTickSpacing(5);
        addSlider(slider, "Ticks");

        // add a slider that snaps to ticks
        slider = new JSlider();
        slider.setPaintTicks(true);
        slider.setSnapToTicks(true);
        slider.setMajorTickSpacing(20);
        slider.setMinorTickSpacing(5);
        addSlider(slider, "Snap to ticks");

        // add a slider with no track
        slider = new JSlider();
        slider.setPaintTicks(true);
        slider.setMajorTickSpacing(20);
        slider.setMinorTickSpacing(5);
        slider.setInverted(true);
        addSlider(slider, "Inverted");

        // add a slider with numeric labels
        slider = new JSlider();
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        slider.setMajorTickSpacing(20);
        slider.setMinorTickSpacing(5);
        addSlider(slider, "Labels");

        // add a slider with alphabetic labels
        slider = new JSlider();
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        slider.setMajorTickSpacing(20);
        slider.setMinorTickSpacing(5);

        Dictionary<Integer, Component> labelTale = new Hashtable<>();
        labelTale.put(0, new JLabel("A"));
        labelTale.put(20, new JLabel("B"));
        labelTale.put(40, new JLabel("C"));
        labelTale.put(60, new JLabel("D"));
        labelTale.put(80, new JLabel("E"));
        labelTale.put(100, new JLabel("F"));
        slider.setLabelTable(labelTale);
        addSlider(slider, "Custom labels");

        // add a single with icon labels
        slider = new JSlider();
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        slider.setSnapToTicks(true);
        slider.setMajorTickSpacing(20);
        slider.setMinorTickSpacing(20);

        labelTale.put(0, new JLabel(new ImageIcon("/image/icon.png")));
        labelTale.put(20, new JLabel(new ImageIcon("/image/icon.png")));
        labelTale.put(40, new JLabel(new ImageIcon("/image/icon.png")));
        labelTale.put(60, new JLabel(new ImageIcon("/image/icon.png")));
        labelTale.put(80, new JLabel(new ImageIcon("/image/icon.png")));
        labelTale.put(100, new JLabel(new ImageIcon("/image/icon.png")));
        slider.setLabelTable(labelTale);
        addSlider(slider, "Icon labels");

        // add the text field that display the slider value
        textField = new JTextField();
        add(sliderPanel, BorderLayout.CENTER);
        add(textField, BorderLayout.SOUTH);
        pack();
    }

    private void addSlider(JSlider s, String description) {
        s.addChangeListener(listener);
        JPanel panel = new JPanel();
        panel.add(s);
        panel.add(new JLabel(description));
        panel.setAlignmentX(Component.LEFT_ALIGNMENT);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridy = sliderPanel.getComponentCount();
        gbc.anchor = GridBagConstraints.WEST;
        sliderPanel.add(panel);
    }

    public static void main(String[] args) {
        TestFrame.test(SliderFrame.class);
    }
}
