package edu.hw3;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CountWordsTest {

    @Test
    public void countWordsClass_testGetFrequencyDictWithLetters() {

        // given
        Map<String, Integer> testCaseOne = new HashMap<>();


        // when
        var answer = CountWordsClass.countWord(List.of(new String[] {"a", "bb", "a", "bb"}));

        // then
        testCaseOne.put("bb", 2);
        testCaseOne.put("a", 2);;

        assertThat(testCaseOne)
            .isEqualTo(answer);
    }

    @Test
    public void countWordsClass_testGetFrequencyDictWithWords() {

        // given
        Map<String, Integer> testCaseOne = new HashMap<>();


        // when
        var answer = CountWordsClass.countWord(List.of(new String[] {"this", "and", "that", "and"}));

        // then
        testCaseOne.put("this", 1);
        testCaseOne.put("and", 2);
        testCaseOne.put("that", 1);

        assertThat(testCaseOne)
            .isEqualTo(answer);

    }

    @Test
    public void countWordsClass_testGetFrequencyDictWithWordsFromDifferentLanguages() {

        // given
        Map<String, Integer> testCaseOne = new HashMap<>();


        // when
        var answer = CountWordsClass.countWord(List.of(new String[] {"код", "код", "код", "bug"}));

        // then
        testCaseOne.put("код", 3);
        testCaseOne.put("bug", 1);

        assertThat(testCaseOne)
            .isEqualTo(answer);

    }

    @Test
    public void countWordsClass_testGetFrequencyDictWithDigits() {

        // given
        Map<Integer, Integer> testCaseOne = new HashMap<>();


        // when
        var answer = CountWordsClass.countWord((List.of(new Integer[] {1, 1, 2, 2})));
        testCaseOne.put(1, 2);
        testCaseOne.put(2, 2);

        assertThat(testCaseOne)
            .isEqualTo(answer);

    }
}
