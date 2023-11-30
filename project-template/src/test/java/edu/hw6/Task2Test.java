package edu.hw6;

import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import static edu.hw6.Task2.cloneFile;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task2Test {
    @Test
    public void task2_testCloneFileWithSeveralFiles() throws IOException {
        // given
        Path originalFile = Path.of("I DONT LOVE THAT FAME.txt");

        // when
        try {
            Files.delete(originalFile);
        } catch (NoSuchFileException ignored) {
        }

        try {
            Files.delete(originalFile.resolveSibling("I DONT LOVE THAT FAME — копия.txt"));
        } catch (NoSuchFileException ignored) {
        }

        try {
            Files.delete(originalFile.resolveSibling("I DONT LOVE THAT FAME — копия (2).txt"));
        } catch (NoSuchFileException ignored) {
        }

        try {
            Files.delete(originalFile.resolveSibling("I DONT LOVE THAT FAME — копия (3).txt"));
        } catch (NoSuchFileException ignored) {
        }

        Files.createFile(originalFile);
        cloneFile(originalFile);
        cloneFile(originalFile);
        cloneFile(originalFile);

        // then
        var expectedResult = true;
        assertThat(expectedResult)
            .isEqualTo(Files.exists(originalFile));
        var expectedResult1 = true;
        assertThat(expectedResult)
            .isEqualTo(Files.exists(originalFile.resolveSibling("I DONT LOVE THAT FAME — копия.txt")));
        var expectedResult2 = true;
        assertThat(expectedResult)
            .isEqualTo(Files.exists(originalFile.resolveSibling("I DONT LOVE THAT FAME — копия (2).txt")));
        var expectedResult3 = true;
        assertThat(expectedResult)
            .isEqualTo(Files.exists(originalFile.resolveSibling("I DONT LOVE THAT FAME — копия (3).txt")));

        Files.delete(originalFile);
        Files.delete(originalFile.resolveSibling("I DONT LOVE THAT FAME — копия.txt"));
        Files.delete(originalFile.resolveSibling("I DONT LOVE THAT FAME — копия (2).txt"));
        Files.delete(originalFile.resolveSibling("I DONT LOVE THAT FAME — копия (3).txt"));
    }
}
