package edu.hw1;

public class StringFunctionsClass {

    private StringFunctionsClass() {

    }

    public static String fixString(String str) {
        char[] charStr = str.toCharArray();

        for (int i = 0; i < charStr.length - 1; i += 2) {
            char tmp = charStr[i];
            charStr[i] = charStr[i + 1];
            charStr[i + 1] = tmp;
        }

        return new String(charStr);
    }

    @SuppressWarnings("MagicNumber")
    public static boolean isPalindromeDescendant(int number) {
        int numberTemp = number;
        while (numberTemp >= 10) {
            if (isPalindrome(numberTemp)) {
                return true;
            }
            numberTemp = foundDescendant(numberTemp);
        }

        return false;
    }

    private static int foundDescendant(int number) {
        String descendant = new String();
        String str = Integer.toString(number);
        for (int i = 0; i < str.length() - 1; i += 2) {
            int digit1 = Character.getNumericValue(str.charAt(i));
            int digit2 = Character.getNumericValue(str.charAt(i + 1));
            descendant += (digit1 + digit2);
        }

        if (str.length() % 2 != 0) {
            descendant += (str.charAt(str.length() - 1));
        }

        return Integer.parseInt(descendant);
    }

    private static boolean isPalindrome(int number) {
        String str = Integer.toString(number);
        return str.equals(new StringBuilder(str).reverse().toString());
    }
}
