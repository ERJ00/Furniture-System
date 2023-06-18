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
        String[] message = {"17303 / 1500 / 10 / TABLE / BRAND T / Wooden Table / DINING ROOM / Hood Inc. / 2023-05-23 / " ,
"66611 / 1500 / 15 / BED / BRAND B / Water Bed / BEDROOM / Bed Inc. / 2023-05-31 /  " ,
"41137 / 10500 / 5 / MODCLOUD / CASSINA / Fabric Sofa / LIVING ROOM / ArchieProducts / 2023-05-31 / " ,
"12996 / 1500 / 0 / SINK / BRAND S / Marble / BATHROOM / Sink Inc. / 2023-06-09 / "};
        
        String message2 = "4:636#2#4833#2#43#2#WDEOH#2#EUDQG#W#2#Zrrghq#Wdeoh#2#GLQLQJ#URRP#2#Krrg#Lqf1#2#5356038056#2#";
        int shift = 3;
        //Encryption decode = new Encryption();

        for (int i = 0; i < message.length; i++){
            String encryptedMessage = Encryption.encrypt(message[i]);
            System.out.println(encryptedMessage);
        
        
        }
//        String decryptedMessage = Encryption.decrypt(encryptedMessage);
//        System.out.println("Decrypted Message: " + decryptedMessage);

        
    }
}
