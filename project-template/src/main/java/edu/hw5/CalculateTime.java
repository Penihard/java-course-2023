package edu.hw5;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class CalculateTime {

    private CalculateTime() {

    }

    private static final String DATE_PATTERN = "yyyy-MM-dd, HH:mm";

    public static String calculateAverageSessionTime(List<String> visits) {
        Duration totalDuration = Duration.ZERO;

        for (String visit : visits) {
            String[] parts = visit.split(" - ");
            LocalDateTime start = LocalDateTime.parse(parts[0], DateTimeFormatter.ofPattern(DATE_PATTERN));
            LocalDateTime end = LocalDateTime.parse(parts[1], DateTimeFormatter.ofPattern(DATE_PATTERN));
            Duration duration = Duration.between(start, end);
            totalDuration = totalDuration.plus(duration);
        }
        long averageDurationInSeconds = totalDuration.toSeconds() / visits.size();
        Duration averageDuration = Duration.ofSeconds(averageDurationInSeconds);
        long hours = averageDuration.toHours();
        long minutes = averageDuration.toMinutesPart();

        return  String.format("%dч %dм", hours, minutes);
    }
}

