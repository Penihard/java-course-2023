package edu.hw5;

import org.junit.jupiter.api.Test;
import static edu.hw5.FinderSubstring.isSubsequence;
import static edu.hw5.ValidatePassword.validatePassword;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class FinderSubstringTest {
    @Test
    public void testIsSubsequenceWithCorrectValue() {
        // given
        String s = "abc";
        String t = "achfdbaabgabcaabg";

        // when
        var answer = isSubsequence(s,t);

        // then
        var expectedResult = true;
        assertThat(expectedResult)
            .isEqualTo(answer);

    }

    @Test
    public void testIsSubsequenceWithIncorrectValue() {
        // given
        String s = "nikita";
        String t = "pobeda_java";

        // when
        var answer = isSubsequence(s,t);

        // then
        var expectedResult = false;
        assertThat(expectedResult)
            .isEqualTo(answer);
    }
}
