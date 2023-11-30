package edu.hw3;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class AtbashTest {
    @Test
    public void atbashClass_testAtbashEncryptMethodSmallString() {
        // given
        var testCaseOne = "Hello world!";
        // when
        var answer = AtbashClass.atbash(testCaseOne);

        // then
        var expectedResult = "Svool dliow!";
        assertThat(expectedResult)
            .isEqualTo(answer);
    }

    @Test
    public void atbashClass_testAtbashEncryptMethodWithHugeString() {

        // given
        var testCaseOne =  "Any fool can write code that a computer can understand. Good programmers write code that humans can understand. ― Martin Fowler";
        // when
        var answer = AtbashClass.atbash(testCaseOne);

        // then
        var expectedResult = "Zmb ullo xzm dirgv xlwv gszg z xlnkfgvi xzm fmwvihgzmw. Tllw kiltiznnvih dirgv xlwv gszg sfnzmh xzm fmwvihgzmw. ― Nzigrm Uldovi";
        assertThat(expectedResult)
            .isEqualTo(answer);
    }

    @Test
    public void atbashClass_testAtbashEncryptMethodWithRussianWord() {
        // given
        var testCaseOne = "Ориентация fool can write code that a computer can understand. Good programmers write code that humans can understand. ― Martin Fowler";
        // when
        var answer = AtbashClass.atbash(testCaseOne);

        // then
        var expectedResult = "Ориентация ullo xzm dirgv xlwv gszg z xlnkfgvi xzm fmwvihgzmw. Tllw kiltiznnvih dirgv xlwv gszg sfnzmh xzm fmwvihgzmw. ― Nzigrm Uldovi";

        assertThat(expectedResult)
            .isEqualTo(answer);

    }
}
