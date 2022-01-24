import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Generate Password");
        frame.setSize(500, 240);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel);
        frame.setVisible(true);
    }

    private static void placeComponents(JPanel panel) {
        panel.setLayout(null);
        JLabel plainTextLabel = new JLabel("Plaintext");
        plainTextLabel.setBounds(20,20,120,25);
        panel.add(plainTextLabel);

        JTextField plainText = new JTextField(20);
        plainText.setBounds(140,20,320,25);
        panel.add(plainText);

        JLabel CipherTextLabel = new JLabel("Ciphertext");
        CipherTextLabel.setBounds(20,80,120,25);
        panel.add(CipherTextLabel);

        JTextArea cipherText = new JTextArea();
        cipherText.setBounds(140,80,320,50);
        cipherText.setLineWrap(true);
        cipherText.setWrapStyleWord(true);
        panel.add(cipherText);

        JButton clearButton = new JButton("CLEAR");
        clearButton.setBounds(200, 50, 120, 25);
        clearButton.addActionListener(l -> {
            plainText.setText("");
            cipherText.setText("");
        });
        panel.add(clearButton);

        JButton generateButton = new JButton("GENERATE");
        generateButton.setBounds(340, 50, 120, 25);
        generateButton.addActionListener(l -> {
            String rawStr = plainText.getText();
            if("".equals(rawStr)) {
                cipherText.setText("");
                return;
            }

            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            String encryptedStr = encoder.encode(rawStr);
            cipherText.setText(encryptedStr);
        });
        panel.add(generateButton);
    }
}