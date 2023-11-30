package edu.hw7;

import edu.hw6.Task5;
import org.junit.jupiter.api.Test;
import static edu.hw7.Task2.calculateFactorial;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task2Test {

    @Test
    public void task2_testFactorial() {
        // given
        var testCase1 = 1;
        var testCase2 = 6;
        var testCase3 = 11;
        var testCase4 = 4;

        // when
        var answer1 = calculateFactorial(testCase1);
        var answer2 = calculateFactorial(testCase2);
        var answer3 = calculateFactorial(testCase3);
        var answer4 = calculateFactorial(testCase4);

        // then
        var expectedResult1 = 1;
        var expectedResult2 = 720;
        var expectedResult3 = 39916800;
        var expectedResult4 = 24;
        assertThat(expectedResult1)
            .isEqualTo(answer1);
        assertThat(expectedResult2)
            .isEqualTo(answer2);
        assertThat(expectedResult3)
            .isEqualTo(answer3);
        assertThat(expectedResult4)
            .isEqualTo(answer4);

    }

}
