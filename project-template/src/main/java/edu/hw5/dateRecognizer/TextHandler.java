package edu.hw5.dateRecognizer;

import java.time.LocalDate;
import java.util.Optional;

public class TextHandler implements FormatHandler {
    public Optional<LocalDate> handle(String dateString) {
        if (dateString.equals("today")) {
            LocalDate date = LocalDate.now();
            return Optional.of(date);
        } else if (dateString.equals("yesterday")) {
            LocalDate date = LocalDate.now().minusDays(1);
            return Optional.of(date);
        } else if (dateString.equals("tomorrow")) {
            LocalDate date = LocalDate.now().plusDays(1);
            return Optional.of(date);
        } else {
            return  Optional.empty();
        }
    }
}
