package edu.hw3;

public class RomanNumeralsClass {

    private RomanNumeralsClass() {

    }

    @SuppressWarnings("MagicNumber")
    public static String romanNumerals(int number) {
        int[] arabicNumbers = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romanNumbers = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder romanNumber = new StringBuilder();

        int inputNumber = number;

        for (int i = 0; i < arabicNumbers.length; i++) {
            while (inputNumber >= arabicNumbers[i]) {
                romanNumber.append(romanNumbers[i]);
                inputNumber -= arabicNumbers[i];
            }
        }

        return romanNumber.toString();
    }
}
