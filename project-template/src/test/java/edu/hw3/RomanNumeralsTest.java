package edu.hw3;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
public class RomanNumeralsTest {
    @Test
    public void romanNumeralsClass_testConvertToRomanWithSimpleNumber() {

        // given
        var testCaseOne = 2;
        // when
        var answer = RomanNumeralsClass.romanNumerals(testCaseOne);

        // then
        var expectedResult = "II";
        assertThat(expectedResult)
            .isEqualTo(answer);

    }

    @Test
    public void romanNumeralsClass_testConvertToRomanWithTwelve() {

        // given
        var testCaseOne = 12;
        // when
        var answer = RomanNumeralsClass.romanNumerals(testCaseOne);

        // then
        var expectedResult = "XII";
        assertThat(expectedResult)
            .isEqualTo(answer);

    }

    @Test
    public void romanNumeralsClass_testConvertToRomanWithSixteen() {


        // given
        var testCaseOne = 16;
        // when
        var answer = RomanNumeralsClass.romanNumerals(testCaseOne);

        // then
        var expectedResult = "XVI";
        assertThat(expectedResult)
            .isEqualTo(answer);

    }
}
