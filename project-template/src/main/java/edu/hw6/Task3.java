package edu.hw6;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;

@FunctionalInterface
public interface Task3 extends DirectoryStream.Filter<Path> {
    Task3 REGULAR_FILE = Files::isRegularFile;
    Task3 READABLE = Files::isReadable;

    static Task3 largerThan(long size) {
        return path -> {
            try {
                return Files.size(path) > size;
            } catch (IOException e) {
                return false;
            }
        };
    }

    static Task3 magicNumber(int... magicBytes) {
        return path -> {
            try {
                byte[] fileBytes = Files.readAllBytes(path);
                if (fileBytes.length < magicBytes.length) {
                    return false;
                }
                for (int i = 0; i < magicBytes.length; i++) {
                    if (fileBytes[i] != (byte) magicBytes[i]) {
                        return false;
                    }
                }
                return true;
            } catch (IOException e) {
                return false;
            }
        };
    }

    static Task3 globMatches(String glob) {
        return path -> path.getFileName().toString().matches(glob);
    }

    static Task3 regexContains(String regex) {
        return path -> path.getFileName().toString().matches(".*" + regex + ".*");
    }

    default Task3 and(Task3 other) {
        return path -> this.accept(path) && other.accept(path);
    }
}
