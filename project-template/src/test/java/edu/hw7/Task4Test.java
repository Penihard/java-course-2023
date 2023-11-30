package edu.hw7;

import org.junit.jupiter.api.Test;
import java.util.concurrent.ExecutionException;
import static edu.hw7.Task4.calculatePiMultiThreaded;
import static edu.hw7.Task4OneThread.calculatePiSingleThreaded;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task4Test {
    @Test
    public void task4_testCalculatePiSingleThreaded() {
        // given
        var testCase = 10000000;

        // when
        var answer = String.format("%.2f",calculatePiSingleThreaded(testCase));

        // then
        var expectedResult = "3,14";
        assertThat(expectedResult)
            .isEqualTo(answer);
    }

    @Test
    public void task4_testCalculatePiMultiThreaded() throws InterruptedException, ExecutionException {
        // given
        var testCase = 10000000;
        var countThreads = 5;
        // when
        var answer = String.format("%.2f",calculatePiMultiThreaded(testCase,countThreads));

        // then
        var expectedResult = "3,14";
        assertThat(expectedResult)
            .isEqualTo(answer);
    }

}
