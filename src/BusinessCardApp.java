import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class BusinessCardApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(BusinessCardApp::createAndShowGUI);
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("名刺作成アプリ");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridLayout(0, 2, 5, 5));

        JTextField nameField = new JTextField();
        JTextField titleField = new JTextField();
        JTextField companyField = new JTextField();
        JTextField emailField = new JTextField();
        JTextField phoneField = new JTextField();
        JTextField addressField = new JTextField();

        inputPanel.add(new JLabel("名前:"));
        inputPanel.add(nameField);
        inputPanel.add(new JLabel("役職:"));
        inputPanel.add(titleField);
        inputPanel.add(new JLabel("会社名:"));
        inputPanel.add(companyField);
        inputPanel.add(new JLabel("メール:"));
        inputPanel.add(emailField);
        inputPanel.add(new JLabel("電話番号:"));
        inputPanel.add(phoneField);
        inputPanel.add(new JLabel("所在地:"));
        inputPanel.add(addressField);

        JButton generateButton = new JButton("名刺を表示");

        JTextArea cardArea = new JTextArea();
        cardArea.setEditable(false);
        cardArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
        cardArea.setBackground(new Color(240, 248, 255));
        cardArea.setBorder(BorderFactory.createTitledBorder("名刺プレビュー"));

        generateButton.addActionListener(e -> {
            String cardText = String.format(
                "╔══════════════════════════╗\n" +
                "║ %s（%s）\n" +
                "║ %s\n" +
                "║ 📧 %s\n" +
                "║ 📞 %s\n" +
                "║ 📍 %s\n" +
                "╚══════════════════════════╝",
                nameField.getText(),
                titleField.getText(),
                companyField.getText(),
                emailField.getText(),
                phoneField.getText(),
                addressField.getText()
            );
            cardArea.setText(cardText);
        });

        frame.add(inputPanel, BorderLayout.NORTH);
        frame.add(generateButton, BorderLayout.CENTER);
        frame.add(cardArea, BorderLayout.SOUTH);

        frame.setVisible(true);
    }
}
