import static org.junit.Assert.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import org.junit.*;

public class MarkdownParseTest {
    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
    }

    @Test
    public void testGetLinks1() {
        String fileName = "test-file.md";
        List<String> expected = List.of("https://something.com", "some-page.html");
        try {
            assertEquals(expected, MarkdownParse.getLinks(Files.readString(Path.of(fileName))));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetLinks2() {
        String fileName = "test2.md";
        List<String> expected = List.of("https://google.com");
        try {
            assertEquals(expected, MarkdownParse.getLinks(Files.readString(Path.of(fileName))));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetLinks3() {
        String fileName = "test3.md";
        List<String> expected = List.of("https://something.com");
        try {
            assertEquals(expected, MarkdownParse.getLinks(Files.readString(Path.of(fileName))));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}