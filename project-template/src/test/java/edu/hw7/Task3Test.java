package edu.hw7;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task3Test {
    @Test
    public void task3_testAddAndFindByName() {
        // given
        Person p1 = new Person(1,"Никита","Улица Птушная","79999999999");
        Person p2 = new Person(2,"Никита","Улица кукушкина","73939939939");
        Task3 service = new Task3();

        // when
        service.add(p1);
        service.add(p2);
        var answer = service.findByName("Никита").size();

        // then
        var expectedResult = 2;
        assertThat(expectedResult)
            .isEqualTo(answer);
    }

    @Test
    public void task3_testDeleteAndFindByAddress() {
        // given
        Person p1 = new Person(1,"Никита","Улица Птушная","79999999999");
        Person p2 = new Person(2,"Никита","Улица кукушкина","73939939939");
        Task3 service = new Task3();

        // when
        service.add(p1);
        service.add(p2);
        service.delete(2);
        var answer = service.findByAddress("Улица кукушкина").size();

        // then
        var expectedResult = 0;
        assertThat(expectedResult)
            .isEqualTo(answer);

    }

    @Test
    public void task3_testFindByPhoneNonExistent() {

        // given
        Person p1 = new Person(1,"Никита","Улица Птушная","79999999999");
        Person p2 = new Person(2,"Никита","Улица кукушкина","73939939939");
        Task3 service = new Task3();

        // when
        service.add(p1);
        service.add(p2);
        service.delete(2);
        var answer = service.findByPhone("73939939939").size();

        // then
        var expectedResult = 0;
        assertThat(expectedResult)
            .isEqualTo(answer);

    }

}
