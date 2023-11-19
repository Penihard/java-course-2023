package edu.hw5;

import org.junit.jupiter.api.Test;
import static edu.hw5.Task8.areNumbersOnOddPositionsEqualOne;
import static edu.hw5.Task8.areThereNo11and111;
import static edu.hw5.Task8.areThereNoRepeatingOnes;
import static edu.hw5.Task8.isEvenOrOddLength;
import static edu.hw5.Task8.isOddLength;
import static edu.hw5.ValidateSpecialString.isLengthMoreOrEqualsOneAndLessOrEqualsThree;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task8Test {
    @Test
    public void task8_testIsOddLength() {
        // given
        var testCases1 = "111";
        var testCases2 = "11111";
        var testCases3 = "11";


        // when
        var answer1 = isOddLength(testCases1);
        var answer2 = isOddLength(testCases2);
        var answer3 = isOddLength(testCases3);


        // then
        var expectedResult1 = true;
        var expectedResult2 = true;
        var expectedResult3 = false;
        assertThat(expectedResult1)
            .isEqualTo(answer1);
        assertThat(expectedResult2)
            .isEqualTo(answer2);
        assertThat(expectedResult3)
            .isEqualTo(answer3);

    }

    @Test
    public void task8_testIsEvenOrOddLength() {
        // given
        var testCases1 = "1111";
        var testCases2 = "000";
        var testCases3 = "1";


        // when
        var answer1 = isEvenOrOddLength(testCases1);
        var answer2 = isEvenOrOddLength(testCases2);
        var answer3 = isEvenOrOddLength(testCases3);


        // then
        var expectedResult1 = true;
        var expectedResult2 = true;
        var expectedResult3 = false;
        assertThat(expectedResult1)
            .isEqualTo(answer1);
        assertThat(expectedResult2)
            .isEqualTo(answer2);
        assertThat(expectedResult3)
            .isEqualTo(answer3);
    }

    @Test
    public void task8_testAreNumbersOnOddPositionsEqualOne() {
        // given
        var testCases1 = "111";
        var testCases2 = "10101";
        var testCases3 = "01";


        // when
        var answer1 = areNumbersOnOddPositionsEqualOne(testCases1);
        var answer2 = areNumbersOnOddPositionsEqualOne(testCases2);
        var answer3 = areNumbersOnOddPositionsEqualOne(testCases3);


        // then
        var expectedResult1 = true;
        var expectedResult2 = true;
        var expectedResult3 = false;
        assertThat(expectedResult1)
            .isEqualTo(answer1);
        assertThat(expectedResult2)
            .isEqualTo(answer2);
        assertThat(expectedResult3)
            .isEqualTo(answer3);

    }

    @Test
    public void task8_testAreThereNoRepeatingOnes() {
        // given
        var testCases1 = "101";
        var testCases2 = "10101";
        var testCases3 = "011";


        // when
        var answer1 = areThereNoRepeatingOnes(testCases1);
        var answer2 = areThereNoRepeatingOnes(testCases2);
        var answer3 = areThereNoRepeatingOnes(testCases3);


        // then
        var expectedResult1 = true;
        var expectedResult2 = true;
        var expectedResult3 = false;
        assertThat(expectedResult1)
            .isEqualTo(answer1);
        assertThat(expectedResult2)
            .isEqualTo(answer2);
        assertThat(expectedResult3)
            .isEqualTo(answer3);

    }

    @Test
    public void task8_areThereNo11and111() {
        // given
        var testCases1 = "111";
        var testCases2 = "11";
        var testCases3 = "011";


        // when
        var answer1 = areThereNo11and111(testCases1);
        var answer2 = areThereNo11and111(testCases2);
        var answer3 = areThereNo11and111(testCases3);


        // then
        var expectedResult1 = false;
        var expectedResult2 = false;
        var expectedResult3 = true;
        assertThat(expectedResult1)
            .isEqualTo(answer1);
        assertThat(expectedResult2)
            .isEqualTo(answer2);
        assertThat(expectedResult3)
            .isEqualTo(answer3);

    }
}
