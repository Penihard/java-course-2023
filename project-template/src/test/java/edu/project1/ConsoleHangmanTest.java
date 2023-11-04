package edu.project1;


import edu.hw2.exprTask.Expr;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ConsoleHangmanTest {
    @Test
    public void consoleHangmanTest_testHangmanAttempts() {
        // given
        ConsoleHangman hangman = new ConsoleHangman();
        hangman.tryGuess("z");
        hangman.tryGuess("a");
        hangman.tryGuess("g");

        // when
        var answer = hangman.getSession().getAttempts();

        // then
        var expectedResult = 3;
        assertThat(expectedResult)
            .isEqualTo(answer);
    }

    @Test
    public void consoleHangmanTest_testHangmanAttemptsRepeatChoice() {

        // given
        ConsoleHangman hangman = new ConsoleHangman();
        hangman.tryGuess("z");
        hangman.tryGuess("z");

        // when
        var answer = hangman.getSession().getAttempts();

        // then
        var expectedResult = 1;
        assertThat(expectedResult)
            .isEqualTo(answer);

    }

    @Test
    public void consoleHangmanTest_testHangmanAttemptsIncorrectInput() {

        // given
        ConsoleHangman hangman = new ConsoleHangman();
        hangman.tryGuess("zv");

        // when
        var answer = hangman.getSession().getAttempts();

        // then
        var expectedResult = 0;
        assertThat(expectedResult)
            .isEqualTo(answer);

    }

    @Test
    public void consoleHangmanTest_testHangmanAttemptsIncorrectInputWithNumbers() {

        // given
        ConsoleHangman hangman = new ConsoleHangman();
        hangman.tryGuess("333");

        // when
        var answer = hangman.getSession().getAttempts();

        // then
        var expectedResult = 0;
        assertThat(expectedResult)
            .isEqualTo(answer);
    }

    @Test
    public void consoleHangmanTest_testHangmanLose() {
        // given
        ConsoleHangman hangman = new ConsoleHangman("rapapa");
        hangman.tryGuess("a");
        hangman.tryGuess("z");
        hangman.tryGuess("v");
        hangman.tryGuess("f");
        hangman.tryGuess("g");
        hangman.tryGuess("q");
        hangman.tryGuess("p");

        // when
        var answer = hangman.tryGuess("o").state();

        // then
        var expectedResult = States.LOSE;
        assertThat(expectedResult)
            .isEqualTo(answer);
    }

    @Test
    public void consoleHangmanTest_testHangmanInterruptGame() {

        // given
        ConsoleHangman hangman = new ConsoleHangman();

        // when
        var answer = hangman.tryGuess(hangman.getStopWord()).state();

        // then
        var expectedResult = States.GIVE_UP;
        assertThat(expectedResult)
            .isEqualTo(answer);

    }

    @Test
    public void consoleHangmanTest_testHangmanWinGame() {
        // given
        String answerForGame = "boy";
        ConsoleHangman hangman = new ConsoleHangman(answerForGame);
        hangman.tryGuess("b");
        hangman.tryGuess("o");

        // when
        var answer = hangman.tryGuess("y").state();

        // then
        var expectedResult = States.WIN;
        assertThat(expectedResult)
            .isEqualTo(answer);
    }

    @Test
    public void consoleHangmanTest_testThatTryGuessTwiceCorrectInputReturnsSuccessState() {

        // given
        String answerForGame = "nikita";
        ConsoleHangman hangman = new ConsoleHangman(answerForGame);
        hangman.tryGuess("n");

        // when
        var answer = hangman.tryGuess("i").state();

        // then
        var expectedResult = States.SUCCESS_GUESS;
        assertThat(expectedResult)
            .isEqualTo(answer);
    }

    @Test
    public void consoleHangmanTest_testThatTryGuessIncorrectInputReturnsFailGuess() {


        // given
        String answerForGame = "nikita";
        ConsoleHangman hangman = new ConsoleHangman(answerForGame);

        // when
        var answer = hangman.tryGuess("z").state();


        // then
        var expectedResult = States.FAIL_GUESS;
        assertThat(expectedResult)
            .isEqualTo(answer);
    }
}
