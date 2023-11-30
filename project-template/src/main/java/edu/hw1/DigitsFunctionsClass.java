package edu.hw1;

import java.util.Arrays;

public class DigitsFunctionsClass {

    private DigitsFunctionsClass() {
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
}
