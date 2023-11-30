package edu.hw5.dateRecognizer;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class DateRecognizer {

    private DateRecognizer() {

    }

    public static Optional<LocalDate> parseDate(String input) {
        return input == null ? Optional.empty() : getParsedDate(List.of(
            new AgoAndAfterHandler().handle(input),
            new TextHandler().handle(input),
            new DateHandler().handle(input)
        ));
    }

    private static Optional<LocalDate> getParsedDate(List<Optional<LocalDate>> parsedDates) {
        for (Optional<LocalDate> date : parsedDates) {
            if (date.isPresent()) {
                return date;
            }
        }

        return Optional.empty();
    }
}
