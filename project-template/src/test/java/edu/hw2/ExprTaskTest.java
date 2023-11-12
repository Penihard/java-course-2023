package edu.hw2;

import edu.hw2.exprTask.Expr;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ExprTaskTest {
    @Test
    public void expr_TestConstantCreate() {
        // given
        var testCases = new Expr.Constant(227);

        // when
        var answer = testCases.evaluate();

        // then
        var expectedResult = 227.0;
        assertThat(expectedResult)
            .isEqualTo(answer);
    }

    @Test
    public void expr_TestNegate() {
        // given
        var testCases = new Expr.Negate(new Expr.Constant(227));

        // when
        var answer = testCases.evaluate();

        // then
        var expectedResult = -227.0;
        assertThat(expectedResult)
            .isEqualTo(answer);
    }

    @Test
    public void expr_TestAddition() {
        // given
        var testCasesOne = new Expr.Constant(1);
        var testCaseTwo = new Expr.Constant(227);

        // when
        var answer = new Expr.Addition(testCasesOne, testCaseTwo).evaluate();

        // then
        var expectedResult = 228.0;
        assertThat(expectedResult)
            .isEqualTo(answer);
    }

    @Test
    public void expr_TestMultiplicationNegative() {
        // given
        var testCasesOne = new Expr.Negate(new Expr.Constant(1));
        var testCaseTwo = new Expr.Constant(227);

        // when
        var answer = new Expr.Multiplication(testCasesOne, testCaseTwo).evaluate();

        // then
        var expectedResult = -227.0;
        assertThat(expectedResult)
            .isEqualTo(answer);
    }

    @Test
    public void expr_TestMultiplicationZero() {
        // given
        var testCasesOne = new Expr.Constant(0);
        var testCaseTwo = new Expr.Constant(227);

        // when
        var answer = new Expr.Multiplication(testCasesOne, testCaseTwo).evaluate();

        // then
        var expectedResult = 0.0;
        assertThat(expectedResult)
            .isEqualTo(answer);
    }

    @Test
    public void expr_TestMultiplication() {
        // given
        var testCasesOne = new Expr.Constant(2);
        var testCaseTwo = new Expr.Constant(227);

        // when
        var answer = new Expr.Multiplication(testCasesOne, testCaseTwo).evaluate();

        // then
        var expectedResult = 454.0;
        assertThat(expectedResult)
            .isEqualTo(answer);
    }

    @Test
    public void expr_TestExponentNegativePower() {
        // given
        var testCaseOne = new Expr.Constant(2);
        var testCaseTwo =new Expr.Negate( new Expr.Constant(2));

        // when
        var answer = new Expr.Exponent(testCaseOne, testCaseTwo).evaluate();

        // then
        var expectedResult = 0.25;
        assertThat(expectedResult)
            .isEqualTo(answer);
    }

    @Test
    public void expr_TestExponentZero() {
        // given
        var testCaseOne = new Expr.Constant(0);
        var testCaseTwo = new Expr.Constant(227);

        // when
        var answer = new Expr.Exponent(testCaseTwo, testCaseOne).evaluate();

        // then
        var expectedResult = 1.0;
        assertThat(expectedResult)
            .isEqualTo(answer);
    }

    @Test
    public void expr_TestExponent() {
        // given
        var testCaseOne = new Expr.Constant(2);
        var testCaseTwo = new Expr.Constant(3);

        // when
        var answer = new Expr.Exponent(testCaseOne, testCaseTwo).evaluate();

        // then
        var expectedResult = 8.0;
        assertThat(expectedResult)
            .isEqualTo(answer);
    }
}
