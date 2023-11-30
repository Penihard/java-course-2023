package edu.hw3;

public class AtbashClass {
    private final static int CHAR_CODE = 25;

    private AtbashClass() {

    }


    public static String atbash(String input) {
        StringBuilder encrypted = new StringBuilder();
        for (char c : input.toCharArray()) {
            if (Character.isLetter(c) && validateSymbol(Character.toString(c).toLowerCase())) {
                char base = Character.isUpperCase(c) ? 'A' : 'a';
                char encryptedChar = ((char) (2 * base + CHAR_CODE - c));
                encrypted.append(encryptedChar);
            } else {
                encrypted.append(c);
            }
        }
        return encrypted.toString();
    }

    private static boolean validateSymbol(String input) {
        return input.matches("[a-z]");
    }
}
