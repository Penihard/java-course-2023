package edu.hw5;

import java.util.regex.Pattern;

public class ValidateRusCarNumber {

    private ValidateRusCarNumber() {

    }

    public static boolean validateRusCarNumber(String number) {
        return number != null
            && Pattern.compile("^[АВЕКМНОРСТУХ]\\d{3}[АВЕКМНОРСТУХ]{2}\\d{2,3}$").matcher(number).find();
    }
}
