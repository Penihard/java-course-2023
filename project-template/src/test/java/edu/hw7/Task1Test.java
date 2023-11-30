package edu.hw7;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task1Test {
    @Test
    public void task1_testCounterIncrementWithSeveralThreads() throws InterruptedException {
        // given
        Task1 counter = new Task1();

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                counter.incrementCounter();
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                counter.incrementCounter();
            }
        });

        Thread thread3 = new Thread(() -> {
            for (int i = 0; i < 375; i++) {
                counter.incrementCounter();
            }
        });
        // when
        thread1.start();
        thread2.start();
        thread3.start();


        thread1.join();
        thread2.join();
        thread3.join();

        var answer = counter.getCounterValue();
        // then
        var expectedResult = 485;
        assertThat(expectedResult)
            .isEqualTo(answer);
    }
}
