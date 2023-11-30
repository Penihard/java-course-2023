package edu.hw6;

import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Task3Test {
    private static final Path TEST_DIR =  Paths.get("src/main/java/edu/hw6/task3_files");

    @Test
    public void task3_testFilterChainWithPng() throws IOException {
        Task3 filter = Task3.REGULAR_FILE
            .and(Task3.READABLE)
            .and(Task3.largerThan(30000))
            .and(Task3.magicNumber(0x89, 'P', 'N', 'G'))
            .and(Task3.globMatches("*.png"))
            .and(Task3.regexContains("[-]"));

        try (DirectoryStream<Path> entries = Files.newDirectoryStream(TEST_DIR, filter)) {
            entries.forEach(System.out::println);
        }
    }
}
