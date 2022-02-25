import static org.junit.Assert.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import org.junit.*;

public class MarkdownParseTest {

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

    @Test
    public void testGetLinks4() {
        String fileName = "test4.md";
        List<String> expected = List.of("google.com");
        try {
            assertTrue("check expected = actual", expected.equals(MarkdownParse.getLinks(Files.readString(Path.of(fileName)))));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetLinksSnippet1() {
        String fileName = "lab-4/snippet1.md";
        List<String> expected = List.of("`google.com", "google.com", "ucsd.edu");
        try {
            assertTrue("check if expected = actual", expected.equals(MarkdownParse.getLinks(Files.readString(Path.of(fileName)))));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetLinksSnippet2() {
        String fileName = "lab-4/snippet2.md";
        List<String> expected = List.of("a.com", "a.com(())", "example.com");
        try {
            assertTrue("check if expected = actual", expected.equals(MarkdownParse.getLinks(Files.readString(Path.of(fileName)))));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetLinksSnippet3() {
        String fileName = "lab-4/snippet3.md";
        List<String> expected = List.of("https://ucsd-cse15l-w22.github.io/");
        try {
            assertTrue("check if expected = actual", expected.equals(MarkdownParse.getLinks(Files.readString(Path.of(fileName)))));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}