package edu.hw6;

import org.junit.jupiter.api.Test;
import static edu.hw6.Task6.isPortAvailable;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task6Test  {
    @Test public void task6_testPortAvailabilityWithTrueResult() {
        // given

        // when
        var answer = isPortAvailable(5001);

        // then
        var expectedResult = true;
        assertThat(expectedResult)
            .isEqualTo(answer);
    }
    @Test public void task6_testPortAvailabilityWithFalseResult() {
        // given

        // when
        var answer = isPortAvailable(135);

        // then
        var expectedResult = false;
        assertThat(expectedResult)
            .isEqualTo(answer);
    }
}
