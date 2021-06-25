package com.xyzcorp.instructor.library;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.stream.Stream;

public class Util {
    public static Stream<String> convertResourceToStream(String resource) throws URISyntaxException,
        IOException {
        URL url = Util.class.getResource(resource);

        InputStream inputStream = url.openConnection().getInputStream();
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        Stream<String> lines = bufferedReader.lines();
        return  lines;
    }
}
