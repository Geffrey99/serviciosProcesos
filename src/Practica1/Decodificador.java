package Practica1;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Decodificador {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Decodificador");

        String message = JOptionPane.showInputDialog(frame,
                "Introduce texto a descifrar:");

        if (message != null && !message.isEmpty()) {
            JButton button = new JButton("Descifrar");
            frame.add(button);
            frame.setSize(200, 100);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);

            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String decryptedMessage = decrypt(message, "K");
                    JOptionPane.showMessageDialog(frame, "Mensaje descifrado: " + decryptedMessage);
                }
            });
        }
    }

    /*-----------------------------------------------------*/


    /**
     *
     *
     *
     * Implementa el descifrado inverso
     * desplazando cada carácter del mensaje
     * por la longitud de la llave K.
     *
     *
     *
     *
     */
    public static String decrypt(String message, String key) {
        StringBuilder decrypted = new StringBuilder();
        int keyLength = key.length();

        for (int i = 0; i < message.length(); i++) {
            char c = (char) (message.charAt(i) - keyLength);
            decrypted.append(c);
        }

        return decrypted.toString();
    }
}

/*
Okkk ✔️✔️✔️✔️✔️✔️
 */