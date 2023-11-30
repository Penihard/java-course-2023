package edu.hw3;

import java.util.List;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
public class BackIteratorTest {
    @Test
    public void testBackwardIterator() {

        // given
        List<Integer> numbers = List.of(1, 2, 3, 5, 6, 7, 2, 3, 4);
        BackwardIteratorClass<Integer> iterator = new BackwardIteratorClass<>(numbers);
        iterator.next();
        iterator.next();

        // when
        var answer = iterator.next();

        // then
        var expectedResult = 2;
        assertThat(expectedResult)
            .isEqualTo(answer);

    }
}
