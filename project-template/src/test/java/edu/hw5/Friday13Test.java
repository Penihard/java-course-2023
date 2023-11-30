package edu.hw5;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.List;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Friday13Test {
    @Test
    public void search13Friday_testFindFridayTheThirteenthsWith2024Year() {
        // given
        var testCases = 2024;

        // when
        var answer = Search13Friday.searchFridayTheThirteenthsInYear(testCases);

        // then
        var expectedResult = List.of(new LocalDate[] {
            LocalDate.of(2024, 9, 13),
            LocalDate.of(2024, 12, 13),
        });
        assertThat(expectedResult)
            .isEqualTo(answer);
    }

    @Test
    public void search13Friday_testFindFridayTheThirteenthsWith1925Year() {
        // given
        var testCases = 1925;

        // when
        var answer = Search13Friday.searchFridayTheThirteenthsInYear(testCases);

        // then
        var expectedResult = List.of(new LocalDate[] {
            LocalDate.of(1925, 2, 13),
            LocalDate.of(1925, 3, 13),
            LocalDate.of(1925, 11, 13),
        });
        assertThat(expectedResult)
            .isEqualTo(answer);
    }
    @Test
    public void search13Friday_testCalculateAverageSessionTimeWithOneValue() {
        // given
        var testCases =  LocalDate.of(1925, 3, 10);
        // when
        var answer = Search13Friday.searchNextFridayTheThirteenths(testCases);

        // then
        var expectedResult =
            LocalDate.of(1925, 3, 13);
        assertThat(expectedResult)
            .isEqualTo(answer);

    }
}
