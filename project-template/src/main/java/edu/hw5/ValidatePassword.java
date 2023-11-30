package edu.hw5;

import java.util.regex.Pattern;

public class ValidatePassword {

    private ValidatePassword() {

    }

    public static boolean validatePassword(String password) {
        return password != null
            && Pattern.compile("^[^~!@#$%^&*|]*?[~!@#$%^&*|][^~!@#$%^&*|]*?$").matcher(password).find();
    }
}
