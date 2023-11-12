package edu.hw1;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class SampleTest {
    @Test
    public void minutesToSecondsClass_testMinutesToSecondsTryConvertWithStandartValue() {
        // given
        String testCases = "13:56";

        // when
        var answer = MinutesToSecondsClass.minutesToSeconds(testCases);

        // then
        var expectedResult = 836;
        assertThat(expectedResult)
            .isEqualTo(answer);
    }

    @Test
    public void minutesToSecondsClass_testMinutesToSecondsTryConvertWithSixtySeconds() {
        // given
        String testCases = "10:60";

        // when
        var answer = MinutesToSecondsClass.minutesToSeconds(testCases);

        //then
        var expectedResult = -1;
        assertThat(expectedResult)
            .isEqualTo(answer);
    }

    @Test
    public void minutesToSecondsClass_testMinutesToSecondsTryConvertWithUnderZeroSeconds() {
        // given
        String testCases = "10:-2";

        // when
        var answer = MinutesToSecondsClass.minutesToSeconds(testCases);

        //then
        var expectedResult = -1;
        assertThat(expectedResult)
            .isEqualTo(answer);
    }


    @Test
    public void digitsFunctionsClass_testCountDigitsWithPositiveValue() {
        // given
        int testCases = 4666;

        // when
        var answer = DigitsFunctionsClass.countDigits(testCases);

        //then
        var expectedResult = 4;
        assertThat(expectedResult)
            .isEqualTo(answer);

    }
    @Test
    public void digitsFunctionsClass_testCountDigitsWithZeroValue() {
        // given
        int testCases = 0;

        // when
        var answer = DigitsFunctionsClass.countDigits(testCases);

        //then
        var expectedResult = 1;
        assertThat(expectedResult)
            .isEqualTo(answer);
    }
    @Test
    public void digitsFunctionsClass_testCountDigitsWithUnderZeroValue() {
        // given
        int testCases = -128;

        // when
        var answer = DigitsFunctionsClass.countDigits(testCases);

        //then
        var expectedResult = 3;
        assertThat(expectedResult)
            .isEqualTo(answer);
    }
    @Test
    public void arrayFunctionsClass_testIsNestableWithTrueResult() {
        // given
        var testCasesFirstArray = new int[]{1, 2, 3, 4};
        var testCasesSecondArray = new int[]{0, 6};

        // when
        var answer = ArrayFunctionsClass.isNestable(testCasesFirstArray,testCasesSecondArray);

        //then
        var expectedResult = true;
        assertThat(expectedResult)
            .isEqualTo(answer);
    }
    @Test
    public void arrayFunctionsClass_testIsNestableWithFalseResult() {
        // given
        var testCasesFirstArray = new int[]{1, 2, 3, 4};
        var testCasesSecondArray = new int[]{2, 3};

        // when
        var answer = ArrayFunctionsClass.isNestable(testCasesFirstArray,testCasesSecondArray);

        //then
        var expectedResult = false;
        assertThat(expectedResult)
            .isEqualTo(answer);
    }
    @Test
    public void stringFunctionsClass_testFixStringWithStringOfNumbers() {
        // given
        String testCases = "123456";

        // when
        var answer = StringFunctionsClass.fixString(testCases);

        // then
        var expectedResult = "214365";
        assertThat(expectedResult)
            .isEqualTo(answer);
    }

    @Test
    public void stringFunctionsClass_testFixStringWithStringOfSpaces() {
        // given
        String testCases = "hTsii  s aimex dpus rtni.g";

        // when
        var answer = StringFunctionsClass.fixString(testCases);

        // then
        var expectedResult = "This is a mixed up string.";
        assertThat(expectedResult)
            .isEqualTo(answer);
    }
    @Test
    public void digitsFunctionsClass_testCountKWithFourDigitValue() {
        // given
        int testCases = 3524;

        // when
        var answer = DigitsFunctionsClass.countK(testCases);

        //then
        var expectedResult = 3;
        assertThat(expectedResult)
            .isEqualTo(answer);

    }
    @Test
    public void stringFunctionsClass_testIsPalindromeDescendantTrueResult() {
        // given
        int testCases = 11211230;

        // when
        var answer = StringFunctionsClass.isPalindromeDescendant(testCases);

        //then
        var expectedResult = true;
        assertThat(expectedResult)
            .isEqualTo(answer);
    }

    @Test
    public void stringFunctionsClass_testIsPalindromeDescendantWithFalseResult() {
        // given
        int testCases = 1232;

        // when
        var answer = StringFunctionsClass.isPalindromeDescendant(testCases);

        //then
        var expectedResult = false;
        assertThat(expectedResult)
            .isEqualTo(answer);
    }
    @Test
    public void digitsFunctionsClass_testRotateWithRightRotateAndOneShift() {
        // given
        int testCases = 8;
        int shift = 1;

        // when
        var answer = DigitsFunctionsClass.rotateRight(testCases,shift);

        //then
        var expectedResult = 4;
        assertThat(expectedResult)
            .isEqualTo(answer);
    }
    @Test
    public void digitsFunctionsClass_testRotateLeftRotateAndOneShift() {
        // given
        int testCases = 16;
        int shift = 1;

        // when
        var answer = DigitsFunctionsClass.rotateLeft(testCases,shift);

        //then
        var expectedResult = 1;
        assertThat(expectedResult)
            .isEqualTo(answer);

    }
    @Test
    public void digitsFunctionsClass_testRotateLeftRotateAndTwoShift() {
        // given
        int testCases = 17;
        int shift = 2;

        // when
        var answer = DigitsFunctionsClass.rotateLeft(testCases,shift);

        //then
        var expectedResult = 6;
        assertThat(expectedResult)
            .isEqualTo(answer);
    }
    @Test
    public void arrayFunctionsClass_testKnightBoardCaptureWithTrueResult() {
        // given
        int[][] board = {
            {0, 0, 0, 1, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 1, 0, 0, 0, 1, 0, 0},
            {0, 0, 0, 0, 1, 0, 1, 0},
            {0, 1, 0, 0, 0, 1, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 1, 0, 0, 0, 0, 0, 1},
            {0, 0, 0, 0, 1, 0, 0, 0}
        };

        // when
        var answer = ArrayFunctionsClass.knightBoardCapture(board);

        //then
        var expectedResult = true;
        assertThat(expectedResult)
            .isEqualTo(answer);
    }
    @Test
    public void arrayFunctionsClass_testKnightBoardCaptureWithFalseResult() {
        // given
        int[][] board = {
            {1, 0, 1, 0, 1, 0, 1, 0},
            {0, 1, 0, 1, 0, 1, 0, 1},
            {0, 0, 0, 0, 1, 0, 1, 0},
            {0, 0, 1, 0, 0, 1, 0, 1},
            {1, 0, 0, 0, 1, 0, 1, 0},
            {0, 0, 0, 0, 0, 1, 0, 1},
            {1, 0, 0, 0, 1, 0, 1, 0},
            {0, 0, 0, 1, 0, 1, 0, 1}
        };


        // when
        var answer = ArrayFunctionsClass.knightBoardCapture(board);

        //then
        var expectedResult = false;
        assertThat(expectedResult)
            .isEqualTo(answer);

    }
}
