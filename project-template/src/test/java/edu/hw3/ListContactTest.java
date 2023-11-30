package edu.hw3;

import java.util.List;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ListContactTest {

    @Test
    public void listContact_testParseContactsASCSort() {

        // given
        var testCaseOne = new String[] {"John Locke", "Thomas Aquinas", "David Hume", "Rene Descartes"};
        // when
        var answer = List.of(ListContactsClass.listContacts(testCaseOne,OrderByEnum.ASC));

        // then
        var expectedResult = List.of(new String[] {"Thomas Aquinas", "Rene Descartes", "David Hume", "John Locke"});
        assertThat(expectedResult)
            .isEqualTo(answer);

    }

    @Test
    public void listContact_testParseContactsDESCSort() {

        // given
        var testCaseOne = new String[] {"Paul Erdos", "Leonhard Euler", "Carl Gauss"};
        // when
        var answer = List.of(ListContactsClass.listContacts(testCaseOne,OrderByEnum.DESC));

        // then
        var expectedResult = List.of(new String[] {"Carl Gauss", "Leonhard Euler", "Paul Erdos"});
        assertThat(expectedResult)
            .isEqualTo(answer);
    }

    @Test
    public void listContact_testParseContactsWithEmptyArray() {

        // given
        var testCaseOne = new String[] {};
        // when
        var answer = List.of(ListContactsClass.listContacts(testCaseOne,OrderByEnum.DESC));
        // then
        var expectedResult = List.of(new String[] {});
        assertThat(expectedResult)
            .isEqualTo(answer);

    }

    @Test
    public void listContact_testParseContactsWithNull() {

        // given
        String[] testCaseOne = null;
        // when
        var answer = List.of(ListContactsClass.listContacts(testCaseOne,OrderByEnum.DESC));
        // then
        var expectedResult = List.of(new String[] {});
        assertThat(expectedResult)
            .isEqualTo(answer);

    }

}
