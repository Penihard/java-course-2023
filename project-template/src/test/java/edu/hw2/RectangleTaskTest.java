package edu.hw2;

import edu.hw2.rectangleTask.Rectangle;
import edu.hw2.rectangleTask.Square;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RectangleTaskTest {

    @Test
    public void rectangle_TestRectangleArea() {
        // given
        var testCases = new Rectangle(20, 20);

        // when
        var answer = testCases.area();

        // then
        var expectedResult = 400.0;
        assertThat(expectedResult)
            .isEqualTo(answer);
    }

    @Test
    public void rectangle_TestRectangleAreaWithChangeHeight() {
        // given
        var testCases = new Rectangle(20, 20);

        // when
        testCases = testCases.setHeight(10);
        var answer = testCases.area();

        // then
        var expectedResult = 200.0;
        assertThat(expectedResult)
            .isEqualTo(answer);
    }

    @Test
    public void rectangle_TestRectangleAreaWithChangeWidth() {
        // given
        var testCases = new Rectangle(20, 20);

        // when
        testCases = testCases.setWidth(5);
        var answer = testCases.area();

        // then
        var expectedResult = 100.0;
        assertThat(expectedResult)
            .isEqualTo(answer);
    }

    @Test
    public void rectangle_TestRectangleAreaWithChangeWidthAndHeight() {
        // given
        var testCases = new Rectangle(20, 20);

        // when
        testCases = testCases.setWidth(5);
        testCases = testCases.setHeight(5);

        var answer = testCases.area();

        // then
        var expectedResult = 25.0;
        assertThat(expectedResult)
            .isEqualTo(answer);
    }

    @Test
    public void rectangle_TestSquareArea() {
        // given
        var testCases = new Square(20);

        // when
        var answer = testCases.area();

        // then
        var expectedResult = 400.0;
        assertThat(expectedResult)
            .isEqualTo(answer);
    }

    @Test
    public void rectangle_TestSquareAreaWithChangeWidth() {
        // given
        var testCases = new Square(20);

        // when
        testCases = testCases.setWidth(5);
        var answer = testCases.area();

        // then
        var expectedResult = 25.0;
        assertThat(expectedResult)
            .isEqualTo(answer);
    }

    @Test
    public void rectangle_TestSquareAreaWithChangeHeight() {
        // given
        var testCases = new Square(20);

        // when
        testCases = testCases.setHeight(5);
        var answer = testCases.area();

        // then
        var expectedResult = 25.0;
        assertThat(expectedResult)
            .isEqualTo(answer);
    }

    @Test
    public void rectangle_TestSquareAreaWithChangeHeightAndWidth() {
        // given
        var testCases = new Square(20);

        // when
        testCases = testCases.setHeight(5);
        testCases = testCases.setWidth(6);
        var answer = testCases.area();

        // then
        var expectedResult = 36.0;
        assertThat(expectedResult)
            .isEqualTo(answer);
    }
}
