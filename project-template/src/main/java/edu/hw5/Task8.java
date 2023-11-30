package edu.hw5;

public class Task8 {

    private Task8() {

    }

    public static boolean isOddLength(String input) {
        return input.matches("^[01]([01]{2})*$");
    }

    public static boolean isEvenOrOddLength(String input) {
        return input.matches("^1[01]([01]{2})*$|^0([01]{2})*$");
    }

    public static boolean areNumbersOnOddPositionsEqualOne(String input) {
        return input.matches("^1([01]1)*[01]?$");
    }

    public static boolean areThereNoRepeatingOnes(String input) {
        return input.matches("^(?!.*11)[01]+$");
    }

    public static boolean areThereNo11and111(String input) {
        return input.matches("^(?:$|0|1|10|110|1110|11110|\\d*(?:01|001)(?:\\d+|$))$");
    }

}
