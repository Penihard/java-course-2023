package edu.hw6;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task5Test {
    @Test
    public void task5_testHackerNewsTopStories() {
        // given
        Task5 hackerNews = new Task5();

        // when
        var answer = hackerNews.hackerNewsTopStories();

        // then
        var expectedResult = true;
        assertThat(expectedResult)
            .isEqualTo(answer!=null);
    }

    @Test
    public void task5_testNews() {
        // given
        Task5 hackerNews = new Task5();

        // when
        var answer = hackerNews.news(38422454);

        // then
        var expectedResult = true;
        assertThat(expectedResult)
            .isEqualTo(!answer.equals("Title not found"));

    }
}
