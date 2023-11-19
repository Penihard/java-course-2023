package edu.hw5.dateRecognizer;

import java.time.LocalDate;
import java.util.Optional;

public interface FormatHandler {
    static Optional<LocalDate> tryParse(String input) {
        return Optional.empty();
    }
}
