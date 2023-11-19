package edu.hw5;

import org.junit.jupiter.api.Test;
import static edu.hw5.ValidateSpecialString.isAtLeast3SymbolsAndThirdIsZero;
import static edu.hw5.ValidateSpecialString.isLengthMoreOrEqualsOneAndLessOrEqualsThree;
import static edu.hw5.ValidateSpecialString.isStartAndEndWithSameCharacter;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ValidateSpecString {
    @Test
    public void validateSpecString_testIsAtLeast3SymbolsAndThirdIsZero() {
        // given
        var testCases1 = "1001111111";
        var testCases2 = "000";
        var testCases3 = "01";


        // when
        var answer1 = isAtLeast3SymbolsAndThirdIsZero(testCases1);
        var answer2 = isAtLeast3SymbolsAndThirdIsZero(testCases2);
        var answer3 = isAtLeast3SymbolsAndThirdIsZero(testCases3);


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
    public void validateSpecString_testIsStartAndEndWithSameCharacter() {
        // given
        var testCases1 = "101";
        var testCases2 = "000";
        var testCases3 = "01";


        // when
        var answer1 = isStartAndEndWithSameCharacter(testCases1);
        var answer2 = isStartAndEndWithSameCharacter(testCases2);
        var answer3 = isStartAndEndWithSameCharacter(testCases3);


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
    public void validateSpecString_testIsLengthMoreOrEqualsOneAndLessOrEqualsThree() {
        // given
        var testCases1 = "101";
        var testCases2 = "10";
        var testCases3 = "1111111111111";


        // when
        var answer1 = isLengthMoreOrEqualsOneAndLessOrEqualsThree(testCases1);
        var answer2 = isLengthMoreOrEqualsOneAndLessOrEqualsThree(testCases2);
        var answer3 = isLengthMoreOrEqualsOneAndLessOrEqualsThree(testCases3);


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

}
