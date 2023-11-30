package edu.hw5;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.Optional;
import static edu.hw5.dateRecognizer.DateRecognizer.parseDate;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class DateTest {
    @Test
    public void dateRecognizer_testParseDateWithFormatValues() {
        // given
        var testCases1 =  "2023-11-11";
        var testCases2 =  "2002-4-20";
        var testCases3 =  "1/3/20";
        // when
        var answer1 = parseDate(testCases1);
        var answer2 = parseDate(testCases2);
        var answer3 = parseDate(testCases3);

        // then
        var expectedResult1 =
            Optional.of(LocalDate.of(2023, 11, 11));
        var expectedResult2 =
            Optional.of(LocalDate.of(2002, 4, 20));
        var expectedResult3 =
            Optional.of(LocalDate.of(2020, 1, 3));
        assertThat(expectedResult1)
            .isEqualTo(answer1);
        assertThat(expectedResult2)
            .isEqualTo(answer2);
        assertThat(expectedResult3)
            .isEqualTo(answer3);
    }

    @Test
    public void dateRecognizer_testParseDateWithWordValues() {
        // given
        var testCases1 =  "today";
        var testCases2 =  "tomorrow";
        var testCases3 =  "yesterday";
        // when
        var answer1 = parseDate(testCases1);
        var answer2 = parseDate(testCases2);
        var answer3 = parseDate(testCases3);

        // then
        var expectedResult1 =
            Optional.of(LocalDate.now());
        var expectedResult2 =
            Optional.of(LocalDate.now().plusDays(1));
        var expectedResult3 =
            Optional.of(LocalDate.now().minusDays(1));
        assertThat(expectedResult1)
            .isEqualTo(answer1);
        assertThat(expectedResult2)
            .isEqualTo(answer2);
        assertThat(expectedResult3)
            .isEqualTo(answer3);
    }

    @Test
    public void dateRecognizer_testParseDateWithIntervals() {
        // given
        var testCases1 =  "5 days ago";
        var testCases2 =  "7 days after";

        // when
        var answer1 = parseDate(testCases1);
        var answer2 = parseDate(testCases2);

        // then
        var expectedResult1 =
            Optional.of(LocalDate.now().minusDays(5));
        var expectedResult2 =
            Optional.of(LocalDate.now().plusDays(7));

        assertThat(expectedResult1)
            .isEqualTo(answer1);
        assertThat(expectedResult2)
            .isEqualTo(answer2);

    }
}
