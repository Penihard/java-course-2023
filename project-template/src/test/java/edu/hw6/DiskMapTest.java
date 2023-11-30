package edu.hw6;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class DiskMapTest {
    private static final String TEST_FILE_PATH = "test_disk_map.txt";
    private DiskMap diskMap;

    @BeforeEach
    void setUp() {
        diskMap = new DiskMap(TEST_FILE_PATH);
    }

    @AfterEach
    void tearDown() throws IOException {
        Files.deleteIfExists(Path.of(TEST_FILE_PATH));
    }

    @Test
    void diskMap_testPutAndGet() {
        // given
        diskMap.put("key1", "value1");

        // when
        var answer = diskMap.get("key1");

        // then
        var expectedResult = "value1";
        assertThat(expectedResult)
            .isEqualTo(answer);
    }

    @Test
    void diskMap_testRemove() {
        // given
        diskMap.put("key1", "value1");
        diskMap.put("122", "2312");


        // when
        var answer1 = diskMap.remove("key1");
        var answer2 = diskMap.size();

        // then
        var expectedResult1 = "value1";
        var expectedResult2 = 1;
        assertThat(expectedResult1)
            .isEqualTo(answer1);
        assertThat(expectedResult2)
            .isEqualTo(answer2);

    }

    @Test
    void diskMap_testClear() {

        // given
        diskMap.put("key1", "value1");
        diskMap.put("122", "2312");


        // when
        diskMap.clear();

        // then
        var expectedResult = true;
        assertThat(expectedResult)
            .isEqualTo(diskMap.isEmpty());
    }

    @Test
    void diskMap_testContainsKeyWithTrueResult() {
        // given
        diskMap.put("key1", "value1");

        // when
        var answer = diskMap.containsKey("key1");

        // then
        var expectedResult = true;
        assertThat(expectedResult)
            .isEqualTo(answer);

    }
    @Test
    void diskMap_testContainsKeyWithFalseResult() {
        // given

        // when
        var answer = diskMap.containsKey("key1");

        // then
        var expectedResult = false;
        assertThat(expectedResult)
            .isEqualTo(answer);
    }
}
