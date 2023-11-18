package edu.hw3;

import java.util.List;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
public class ClusterizeTest {
    @Test
    public void clusterizerClass_testClusterizeBracketsSimpleInput() {

        // given
        var testCaseOne = "()()()";
        // when
        var answer = ClusterizerClass.clusterize(testCaseOne);

        // then
        var expectedResult = List.of(new String[] {"()", "()", "()"});
        assertThat(expectedResult)
            .isEqualTo(answer);
    }

    @Test
    public void clusterizerClass_testClusterizeBracketsWithoutClusters() {

        // given
        var testCaseOne = "((()))";
        // when
        var answer = ClusterizerClass.clusterize(testCaseOne);

        // then
        var expectedResult = List.of(new String[] {"((()))"});
        assertThat(expectedResult)
            .isEqualTo(answer);

    }

    @Test
    public void clusterizerClass_testClusterizeBracketsWithMultipleClusters() {

        // given
        var testCaseOne = "((()))(())()()(()())";
        // when
        var answer = ClusterizerClass.clusterize(testCaseOne);

        // then
        var expectedResult = List.of(new String[] {"((()))", "(())", "()", "()", "(()())"});
        assertThat(expectedResult)
            .isEqualTo(answer);

    }

    @Test
    public void clusterizerClass_testClusterizeBracketsWithSmallCountOfClusters() {

        // given
        var testCaseOne = "((())())(()(()()))";
        // when
        var answer = ClusterizerClass.clusterize(testCaseOne);

        // then
        var expectedResult = List.of(new String[] {"((())())", "(()(()()))"});
        assertThat(expectedResult)
            .isEqualTo(answer);

    }
}
