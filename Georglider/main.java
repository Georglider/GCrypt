package Georglider;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class main extends JFrame {

    private JPanel contentPane;
    private JTextField encryptedText;
    private JTextField decryptedText;
    private JTextField secretKey;
    int FocusWindow;
    private JTextField txtEncrypted;
    private JTextField txtDecrypted;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    main frame = new main();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public main() {
        setResizable(false);
        setTitle("GCrypt");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JButton CryptButton = new JButton("Decrypt");
        CryptButton.setBounds(179, 222, 113, 28);
        contentPane.add(CryptButton);

        txtEncrypted = new JTextField();
        txtEncrypted.setBackground(new Color(51, 153, 0));
        txtEncrypted.setText("Encrypted text");
        txtEncrypted.setEditable(false);
        txtEncrypted.setBounds(345, 15, 80, 20);
        contentPane.add(txtEncrypted);
        txtEncrypted.setColumns(10);

        txtDecrypted = new JTextField();
        txtDecrypted.setBackground(new Color(255, 0, 0));
        txtDecrypted.setText("Decrypted text");
        txtDecrypted.setEditable(false);
        txtDecrypted.setColumns(10);
        txtDecrypted.setBounds(345, 64, 80, 20);
        contentPane.add(txtDecrypted);

        encryptedText = new JTextField();
        encryptedText.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent arg0) {
                FocusWindow = 1;
                CryptButton.setText("Decrypt");
                txtDecrypted.setBackground(new Color(255, 0, 0));
                txtEncrypted.setBackground(new Color(51, 153, 0));
            }
        });
        encryptedText.setBounds(10, 11, 325, 28);
        contentPane.add(encryptedText);
        encryptedText.setColumns(10);

        decryptedText = new JTextField();
        decryptedText.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                FocusWindow = 2;
                CryptButton.setText("Encrypt");
                txtDecrypted.setBackground(new Color(51, 153, 0));
                txtEncrypted.setBackground(new Color(255, 0, 0));
            }
        });
        decryptedText.setBounds(10, 60, 325, 28);
        contentPane.add(decryptedText);
        decryptedText.setColumns(10);

        secretKey = new JTextField();
        secretKey.setBounds(10, 150, 335, 28);
        contentPane.add(secretKey);
        secretKey.setColumns(10);

        JLabel lblSecretKey = new JLabel("Secret key");
        lblSecretKey.setBounds(355, 157, 69, 14);
        contentPane.add(lblSecretKey);

        JLabel Georglider = new JLabel("Made by Georglider");
        Georglider.setBounds(10, 222, 120, 21);
        contentPane.add(Georglider);

        CryptButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                String secretKeyS = secretKey.getText();
                String enc = encryptedText.getText();
                String dec = decryptedText.getText();

                if (FocusWindow ==1) {
                    String decryptedString = AES.decrypt(enc, secretKeyS);
                    decryptedText.setText(decryptedString);
                    if (decryptedString == null) {
                        decryptedText.setText("Error while decrypting");
                    }
                }
                else if (FocusWindow ==2) {
                    String encryptedString = AES.encrypt(dec, secretKeyS);
                    encryptedText.setText(encryptedString);
                    //if (encryptedString == null) {
                    //    decryptedText.setText("Error while decrypting");
                    //}
                }
                //System.out.print(FocusWindow);
            }
        });
    }
}
