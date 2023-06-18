package JavaClasses;

public class Encryption {
private static final int SHIFT = 5;

public static String encrypt(String plaintext) {
    StringBuilder ciphertext = new StringBuilder();

    for (int i = 0; i < plaintext.length(); i++) {
        char ch = plaintext.charAt(i);

        char shiftedChar = (char) ((ch + SHIFT) % 65536);
        ciphertext.append(shiftedChar);
    }

    return ciphertext.toString();
}

public static String decrypt(String ciphertext) {
    StringBuilder plaintext = new StringBuilder();

    for (int i = 0; i < ciphertext.length(); i++) {
        char ch = ciphertext.charAt(i);

        char shiftedChar = (char) ((ch - SHIFT + 65536) % 65536);
        plaintext.append(shiftedChar);
    }

    return plaintext.toString();
}


//    public static String decrypt(String ciphertext) {
//        StringBuilder plaintext = new StringBuilder();
//
//        for (int i = 0; i < ciphertext.length(); i++) {
//            char ch = ciphertext.charAt(i);
//
//            char shiftedChar = (char) ((ch - SHIFT + 65536) % 65536);
//            plaintext.append(shiftedChar);
//        }
//
//        return plaintext.toString();
//    }
}