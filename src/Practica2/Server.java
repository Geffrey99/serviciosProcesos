package Practica2;

import java.io.*;
import java.net.*;

public class Server {

    public static void main(String[] args) {

        try (ServerSocket serverSocket = new ServerSocket(5000)) {

            System.out.println("Servidor iniciado y esperando conexión...");

            try (Socket clientSocket = serverSocket.accept()) {

                System.out.println("Cliente conectado.");

                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

                String message;

                while ((message = in.readLine()) != null) {
                    System.out.println("Mensaje recibido (cifrado): " + message);
                    String decryptedMessage = decrypt(message, "K");
                    System.out.println("Mensaje descifrado: " + decryptedMessage);

                    // Enviar la confirmación cifrada al cliente--------------
                    String confirmation = "Mensaje recibido: " + decryptedMessage;
                    String encryptedConfirmation = encrypt(confirmation, "K");
                    out.println(encryptedConfirmation);
                    System.out.println("Confirmación enviada (cifrada): " + encryptedConfirmation);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /*-----------------------------------------------------*/
    public static String encrypt(String message, String key) {
        StringBuilder encrypted = new StringBuilder();
        int keyLength = key.length();

        for (int i = 0; i < message.length(); i++) {
            char c = (char) (message.charAt(i) + keyLength);
            encrypted.append(c);
        }

        return encrypted.toString();
    }



    /*-----------------------------------------------------*/
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