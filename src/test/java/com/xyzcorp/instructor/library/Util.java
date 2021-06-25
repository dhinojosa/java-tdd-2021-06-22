package com.xyzcorp.instructor.library;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Util {
    public static Stream<String> convertResourceToStream(String resource) throws URISyntaxException,
        IOException {
        URL url = Util.class.getResource(resource);
        System.out.println(url.toURI());
        Path path = Paths.get(url.toURI());
        return Files.lines(path);
    }
}
