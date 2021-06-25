package com.xyzcorp.instructor.library;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@Tag("integration")
public class LibraryExploratoryIntegrationTest {

    @Test
    void testReadingAFileFromResourcesAndPluggingInLibraryParser() throws URISyntaxException, IOException {
        Stream<String> lines = Util.convertResourceToStream("/library.txt");
        Stream<Checkout> checkoutStream = LibraryParser.parse(lines);
        assertThat(checkoutStream).hasSize(17);
    }

    @Test
    void testDoTheSameReadingButFromAWebsite() throws IOException,
        URISyntaxException {
        URL url = new URL("https://raw.githubusercontent.com/dhinojosa/java-tdd-2021-06-22/master/src/main/resources/library.txt");
        InputStream inputStream = url.openConnection().getInputStream();
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        Stream<String> lines = bufferedReader.lines();
        Stream<Checkout> checkoutStream = LibraryParser.parse(lines);
        checkoutStream.forEach(System.out::println);
    }
}
