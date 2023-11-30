package edu.hw5;

import org.junit.jupiter.api.Test;
import java.util.List;
import static edu.hw5.CalculateTime.calculateAverageSessionTime;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CalculateTimeTest {
    @Test
    public void testCalculateAverageSessionTime() {
        // given
        var testCases = List.of("2022-03-12, 20:20 - 2022-03-12, 23:50", "2022-04-01, 21:30 - 2022-04-02, 01:20");

        // when
        var answer = calculateAverageSessionTime(testCases);

        // then
        var expectedResult = "3ч 40м";
        assertThat(expectedResult)
            .isEqualTo(answer);
    }

    @Test
    public void testCalculateAverageSessionTimeWithOneValue() {

        // given
        var testCases = List.of("2022-03-12, 20:20 - 2022-03-12, 23:50");

        // when
        var answer = calculateAverageSessionTime(testCases);

        // then
        var expectedResult = "3ч 30м";
        assertThat(expectedResult)
            .isEqualTo(answer);

    }
}
