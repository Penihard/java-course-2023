package edu.hw5;

import org.junit.jupiter.api.Test;
import static edu.hw5.ValidatePassword.validatePassword;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
public class PasswordTest {
    @Test
    public void validatePassword_assertThatIsPasswordValidReturnedTrueAnswer() {
        // given
        var testCases = "tysa@";

        // when
        var answer = validatePassword(testCases);

        // then
        var expectedResult = true;
        assertThat(expectedResult)
            .isEqualTo(answer);
    }
    @Test
    public void validatePassword_assertThatIsPasswordValidReturnedFalseAnswer() {
        // given
        var testCases = "qwerty";

        // when
        var answer = validatePassword(testCases);

        // then
        var expectedResult = false;
        assertThat(expectedResult)
            .isEqualTo(answer);
    }
}
