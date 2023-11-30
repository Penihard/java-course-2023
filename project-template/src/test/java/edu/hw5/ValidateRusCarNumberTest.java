package edu.hw5;

import org.junit.jupiter.api.Test;
import static edu.hw5.ValidateRusCarNumber.validateRusCarNumber;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ValidateRusCarNumberTest {
    @Test
    public void validateRusCarNumber_testValidateRusCarNumberWithCorrectNumbers() {
        // given
        var testCases1 = "А123ВЕ777";
        var testCases2 = "О777ОО177";


        // when
        var answer1 = validateRusCarNumber(testCases1);
        var answer2 = validateRusCarNumber(testCases2);


        // then
        var expectedResult1 = true;
        var expectedResult2 = true;
        assertThat(expectedResult1)
            .isEqualTo(answer1);
        assertThat(expectedResult2)
            .isEqualTo(answer2);

    }

    @Test
    public void validateRusCarNumber_testValidateRusCarNumberWithIncorrectNumbers() {
        // given
        var testCases1 = "123АВЕ777";
        var testCases2 = "А123ВГ77";
        var testCases3 = "А123ВЕ7777";


        // when
        var answer1 = validateRusCarNumber(testCases1);
        var answer2 = validateRusCarNumber(testCases2);
        var answer3 = validateRusCarNumber(testCases3);


        // then
        var expectedResult1 = false;
        var expectedResult2 = false;
        var expectedResult3 = false;
        assertThat(expectedResult1)
            .isEqualTo(answer1);
        assertThat(expectedResult2)
            .isEqualTo(answer2);
        assertThat(expectedResult3)
            .isEqualTo(answer3);

    }
}
