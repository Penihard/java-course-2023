package edu.hw1;

import java.util.Arrays;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public final class Main {
    private final static Logger LOGGER = LogManager.getLogger();

    private Main() {
    }

    public static void helloWorld() {
        LOGGER.info("Hello world!");
    }

    @SuppressWarnings("MagicNumber")
    public static int minutesToSeconds(String str) {
        String[] splitedStr = str.split(":");

        int minutes = Integer.parseInt(splitedStr[0]);
        int seconds = Integer.parseInt(splitedStr[1]);
        if (seconds >= 60 || seconds <= -1) {
            return -1;
        }
        return minutes * 60 + seconds;
    }

    @SuppressWarnings("MagicNumber")
    public static int countDigits(int value) {
        int count = 0;
        int valueTemp = value;
        if (valueTemp == 0) {
            return 1;
        }
        if (valueTemp < 0) {
            valueTemp = Math.abs(valueTemp);
        }
        while (valueTemp > 0) {
            count++;
            valueTemp = valueTemp / 10;
        }
        return count;
    }

    public static boolean isNestable(int[] a1, int[] a2) {
        if (Arrays.stream(a1).min().getAsInt() > Arrays.stream(a2).min().getAsInt()) {
            if (Arrays.stream(a2).max().getAsInt() > Arrays.stream(a1).max().getAsInt()) {
                return true;
            }
        }
        return false;
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

    @SuppressWarnings("MagicNumber")
    public static int countK(int value) {
        if (value == 6174) {
            return 0;
        }

        return 1 + countK(sortDigitsInNumber(value));
    }

    private static int sortDigitsInNumber(int number) {
        String numberString = String.valueOf(number);
        char[] digitsArray = numberString.toCharArray();
        Arrays.sort(digitsArray);
        StringBuilder sortedNumberString = new StringBuilder(new String(digitsArray));
        sortedNumberString.reverse();
        int val1 = Integer.parseInt(sortedNumberString.toString());
        int val2 = Integer.parseInt(new String(digitsArray));
        return val1 - val2;
    }

    public static int rotateRight(int n, int shift) {
        int shiftTemp = shift;
        String binaryStr = Integer.toBinaryString(n);
        shiftTemp %= binaryStr.length();
        String rotatedBinaryStr = binaryStr.substring(binaryStr.length() - shiftTemp)
            + binaryStr.substring(0, binaryStr.length() - shiftTemp);
        return Integer.parseInt(rotatedBinaryStr, 2);
    }

    public static int rotateLeft(int n, int shift) {
        int shiftTemp = shift;
        String binaryStr = Integer.toBinaryString(n);
        shiftTemp %= binaryStr.length();
        String rotatedBinaryStr = binaryStr.substring(shiftTemp) + binaryStr.substring(0, shiftTemp);
        return Integer.parseInt(rotatedBinaryStr, 2);
    }

    public static String toBinaryString(int n) {
        return String.format("%32s", Integer.toBinaryString(n))
            .replaceAll(" ", "0");
    }

    @SuppressWarnings("MagicNumber")
    public static boolean knightBoardCapture(int[][] board) {
        int[] dx = {-2, -2, -1, -1, 1, 1, 2, 2};
        int[] dy = {-1, 1, -2, 2, -2, 2, -1, 1};
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j] == 1) {
                    for (int k = 0; k < 8; k++) {
                        int x = i + dx[k];
                        int y = j + dy[k];
                        if (x >= 0 && x < 8 && y >= 0 && y < 8 && board[x][y] == 1) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}
