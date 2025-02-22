package Practica1;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Codificador {
    public static void main(String[] args) {

        JFrame frame = new JFrame("Codificador");

        String message = JOptionPane.showInputDialog(frame,
                "Introduce texto a cifrar:");

        if (message != null && !message.isEmpty()) {
            JButton button = new JButton("Cifrar");
            frame.add(button);
            frame.setSize(200, 100);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);

            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String encryptedMessage = encrypt(message, "K");
                    JOptionPane.showMessageDialog(frame, "Mensaje cifrado : " + encryptedMessage);
                }
            });
        }
    }


/*-----------------------------------------------------*/

    /**
     *
     *
     *
     *
     * Implementa un cifrado simple
     * desplazando cada carácter del mensaje
     * por la longitud de la llave K
     *
     *
     */
    public static String encrypt(String message, String key) {
        StringBuilder encrypted = new StringBuilder();
        int keyLength = key.length();

        for (int i = 0; i < message.length(); i++) {
            char c = (char) (message.charAt(i) + keyLength);
            encrypted.append(c);
        }

        return encrypted.toString();
    }
}

/*
ittttss okokokokokkk ✔️✔️✔️
Explicacion a recordar
 Formula Cifrado : C = (M+K) 26
 Formula Descifdrado : M = (C-K) 26
 C : es el carácter cifrado.
 M : es el caracter original
 k : es la clave de desplazamiento
 26 el numeroo de letras en el alfabeto inglees
 ---------------------------------------------------riightt😀
 */
