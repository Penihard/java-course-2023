package edu.hw3;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountWordsClass {
    private CountWordsClass() {

    }

    public static <T> Map<T, Integer> countWord(List<T> list) {
        Map<T, Integer> wordMap = new HashMap<>();

        for (T item : list) {
            wordMap.put(item, wordMap.getOrDefault(item, 0) + 1);
        }

        return wordMap;
    }
}
