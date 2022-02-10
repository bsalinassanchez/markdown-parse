import static org.junit.Assert.*;
import org.junit.*;
import java.util.List;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class MarkdownParseTest {
    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
    }
    @Test
    public void getLinks() throws IOException {
        assertEquals("checks that the method getLinks (more words) give correct output",
            List.of("https://something.com", "some-page.html"), 
            MarkdownParse.getLinks(Files.readString(Paths.get("test-file.md"))));
    }


    @Test
    public void spaceTest() throws IOException {
        assertEquals("checks that link is not printed",
            List.of(),
            MarkdownParse.getLinks(Files.readString(Paths.get("failureinducing.md"))));
    }
}