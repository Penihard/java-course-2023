package edu.hw3;

import java.util.TreeMap;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class NullComparatorTest {
    @Test
    public void nullComparator_testNullComparator() {

        // given
        TreeMap<String, String> tree = new TreeMap<>(new NullComparatorClass());
        tree.put(null, "test");
        // when
        var answer = tree.containsKey(null);

        // then
        var expectedResult = true;
        assertThat(expectedResult)
            .isEqualTo(answer);

    }
}
