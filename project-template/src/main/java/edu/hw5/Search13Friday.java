package edu.hw5;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;

public class Search13Friday {

    private Search13Friday() {

    }

    private static final int THIRTEEN = 13;

    public static List<LocalDate> searchFridayTheThirteenthsInYear(int year) {
        List<LocalDate> result = new ArrayList<LocalDate>();
        LocalDate date = LocalDate.of(year, Month.JANUARY, THIRTEEN);
        while (date.getYear() == year) {
            if (date.getDayOfWeek() == DayOfWeek.FRIDAY) {
                result.add(date);
            }
            date = date.plusMonths(1);
        }


        return result;
    }

    public static LocalDate searchNextFridayTheThirteenths(LocalDate date) {
        return date.with(TemporalAdjusters.nextOrSame(DayOfWeek.FRIDAY))
            .with(TemporalAdjusters.next(DayOfWeek.FRIDAY))
            .withDayOfMonth(THIRTEEN);
    }
}
