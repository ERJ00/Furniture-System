/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JavaClasses;

/**
 *
 * @author user
 */
public class sample {
    public static String encrypt(String plaintext, int shift) {
        StringBuilder ciphertext = new StringBuilder();

        for (int i = 0; i < plaintext.length(); i++) {
            char ch = plaintext.charAt(i);

            char shiftedChar = (char) ((ch + shift) % 65536);
            ciphertext.append(shiftedChar);
        }

        return ciphertext.toString();
    }

    public static String decrypt(String ciphertext, int shift) {
        StringBuilder plaintext = new StringBuilder();

        for (int i = 0; i < ciphertext.length(); i++) {
            char ch = ciphertext.charAt(i);

            char shiftedChar = (char) ((ch - shift + 65536) % 65536);
            plaintext.append(shiftedChar);
        }

        return plaintext.toString();
    }

    public static void main(String[] args) {
        String[] message = {"BALANCE / EMMAN / 11/11/1111 / 0123456789 / NEAR CITY / MODCLOUD / LIVING ROOM / 2 / 11000 / 1000 / 10000 / 0 / 2023-06-17 / 11289 / "};
        
        String message2 = "GFQFSHJslsJRRFSsls11l11l1111sls0123456789slsSJFWsHNYDslsRTIHQTZIslsQNANSLsWTTRsls2sls11000sls1000sls10000sls0sls2023-06-17sls11289sls";
        int shift = 3;
        //Encryption decode = new Encryption();

        for (int i = 0; i < message.length; i++){
            String encryptedMessage = Encryption.encrypt(message[i]);
            System.out.println(encryptedMessage);
        
//        String decryptedMessage = Encryption.decrypt(encryptedMessage);
//        System.out.println("Decrypted Message: " + decryptedMessage);
        }
        

        
    }
}
