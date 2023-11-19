package edu.hw5.dateRecognizer;

import java.time.LocalDate;
import java.util.Optional;

public class AgoAndAfterHandler implements FormatHandler {

    private static final String AGO = "ago";

    @SuppressWarnings("MagicNumber")
    public Optional<LocalDate> handle(String dateString) {
        String[] parts = dateString.split(" ");
        if (parts.length == 3) {
            try {
                int num = Integer.parseInt(parts[0]);
                String unit = parts[1];
                LocalDate date;
                if (unit.equals("days")) {
                    if (parts[2].equals(AGO)) {
                        date = LocalDate.now().minusDays(num);
                    } else {
                        date = LocalDate.now().plusDays(num);
                    }
                } else if (unit.equals("weeks")) {
                    if (parts[2].equals(AGO)) {
                        date = LocalDate.now().minusWeeks(num);
                    } else {
                        date = LocalDate.now().plusWeeks(num);
                    }
                } else if (unit.equals("months")) {
                    if (parts[2].equals(AGO)) {
                        date = LocalDate.now().minusMonths(num);
                    } else {
                        date = LocalDate.now().plusMonths(num);
                    }
                } else if (unit.equals("years")) {
                    if (parts[2].equals(AGO)) {
                        date = LocalDate.now().minusYears(num);
                    } else {
                        date = LocalDate.now().plusYears(num);
                    }
                    date = LocalDate.now().minusYears(num);
                } else {
                    return Optional.empty();
                }
                return Optional.of(date);
            } catch (NumberFormatException e) {
                return Optional.empty();
            }
        }
        return Optional.empty();
    }
}
