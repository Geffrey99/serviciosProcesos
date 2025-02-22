package Practica2;

import java.io.*;
import java.net.*;


//ejecutar server antes --------------------itsokkkk
public class Client {
    public static void main(String[] args) {


        try (Socket socket = new Socket("localhost", 5000)) {
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("Conectado al servidor.");
            System.out.print("Introduce el mensaje a enviar: ");
            String message = stdIn.readLine();

            if (message != null && !message.isEmpty()) {
                String encryptedMessage = encrypt(message, "K");
                out.println(encryptedMessage);
                System.out.println("Mensaje enviado (cifrado): " + encryptedMessage);

                String response;

                while ((response = in.readLine()) != null) {
                    System.out.println("Respuesta recibida (cifrada): " + response);
                    String decryptedResponse = decrypt(response, "K");
                    System.out.println("Respuesta descifrada: " + decryptedResponse);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //----------------------------------------------------------------------

    public static String encrypt(String message, String key) {
        StringBuilder encrypted = new StringBuilder();

        int keyLength = key.length();

        for (int i = 0; i < message.length(); i++) {
            char c = (char) (message.charAt(i) + keyLength);
            encrypted.append(c);
        }

        return encrypted.toString();
    }

    //---------------------------------------------------------------
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