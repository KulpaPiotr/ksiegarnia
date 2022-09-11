package pl.sdacademy.java.advance.exercises.day3.task33;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class ImageFinder {

    public static List<File> findImages(Path directory) {

        try {
            Stream<Path> walk = Files.walk(directory);
            return null;

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
