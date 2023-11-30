package edu.hw6;

import org.junit.jupiter.api.Test;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import static edu.hw6.Task4.writeTextToFile;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task4Test {
    @Test
    public void testWriteTextToFile() throws IOException {
        // given
        String fileName = "output.txt";
        writeTextToFile(fileName);
        var answer = new String();

        // when
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line = reader.readLine();
            answer = line;

        }
        // then
        var expectedResult = "Programming is learned by writing programs. ― Brian Kernighan";
        assertThat(expectedResult)
            .isEqualTo(answer);

        try {
            Files.delete(Path.of(fileName));
        } catch (NoSuchFileException ignored) {
        }

    }
}
