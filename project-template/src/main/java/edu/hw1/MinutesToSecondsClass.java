package edu.hw1;

public class MinutesToSecondsClass {

    private MinutesToSecondsClass() {

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
}
