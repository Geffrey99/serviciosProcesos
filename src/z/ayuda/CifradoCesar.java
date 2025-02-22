package z.ayuda;

public class CifradoCesar {

    /** AYUDA ADICIONAL DE REFERENCIA

     */

    public static void main(String[] args) {
        String message = "ProcesosYserviciosOk";
        int key = 3;

        String encryptedMessage = encrypt(message, key);
        System.out.println("Mensaje cifrado: " + encryptedMessage);

        String decryptedMessage = decrypt(encryptedMessage, key);
        System.out.println("Mensaje descifrado: " + decryptedMessage);
    }




    /**
    Toma el mensaje original y la clave de desplazamiento como argumentos.
    Para cada carácter en el mensaje, si es una letra, se desplaza por el valor de la clave.
    Si el carácter desplazado excede 'z' (para minúsculas) o 'Z' (para mayúsculas), se ajusta restando 26.
    Los caracteres no alfabéticos se añaden sin cambios.
     */
    public static String encrypt(String message, int key) {
        StringBuilder encrypted = new StringBuilder();

        for (char character : message.toCharArray()) {
            if (Character.isLetter(character)) {
                char shifted = (char) (character + key);
                if (Character.isLowerCase(character) && shifted > 'z' ||
                        Character.isUpperCase(character) && shifted > 'Z') {
                    shifted -= 26;
                }
                encrypted.append(shifted);
            } else {
                encrypted.append(character);
            }
        }

        return encrypted.toString();
    }

    /**
    Utiliza el método encrypt con el desplazamiento negativo para descifrar el mensaje.s
     */
    public static String decrypt(String message, int key) {
        return encrypt(message, -key);
    }



}



/*************************************************************************************************************************
Es un tipo de cifrado por sustitución en el cual cada letra del texto plano se sustituye por otra letra
que se encuentra un número fijo de posiciones más adelante en el alfabeto.
Si se llega al final del alfabeto, se vuelve al principio.
 */