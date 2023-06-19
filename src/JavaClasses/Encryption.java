package JavaClasses;

public class Encryption {
    private static final int SHIFT = 5;

    public static String encrypt(String plaintext) {
        StringBuilder ciphertext = new StringBuilder();

        for (int i = 0; i < plaintext.length(); i++) {
            char ch = plaintext.charAt(i);

            // Encrypt uppercase letters
            if (Character.isUpperCase(ch)) {
                char encryptedChar = (char) ((ch - 'A' + SHIFT) % 26 + 'A');
                ciphertext.append(encryptedChar);
            }
            // Encrypt lowercase letters
            else if (Character.isLowerCase(ch)) {
                char encryptedChar = (char) ((ch - 'a' + SHIFT) % 26 + 'a');
                ciphertext.append(encryptedChar);
            }
            // Encrypt space and slash characters
            else if (ch == ' ') {
                ciphertext.append('#');
            } else if (ch == '/') {
                ciphertext.append('&');
            }
            // Append other characters as is
            else {
                ciphertext.append(ch);
            }
        }

        return ciphertext.toString();
    }

    public static String decrypt(String ciphertext) {
        StringBuilder plaintext = new StringBuilder();

        for (int i = 0; i < ciphertext.length(); i++) {
            char ch = ciphertext.charAt(i);

            // Decrypt uppercase letters
            if (Character.isUpperCase(ch)) {
                char decryptedChar = (char) ((ch - 'A' - SHIFT + 26) % 26 + 'A');
                plaintext.append(decryptedChar);
            }
            // Decrypt lowercase letters
            else if (Character.isLowerCase(ch)) {
                char decryptedChar = (char) ((ch - 'a' - SHIFT + 26) % 26 + 'a');
                plaintext.append(decryptedChar);
            }
            // Decrypt space and slash characters
            else if (ch == '#') {
                plaintext.append(' ');
            } else if (ch == '&') {
                plaintext.append('/');
            }
            // Append other characters as is
            else {
                plaintext.append(ch);
            }
        }

        return plaintext.toString();
    }
}