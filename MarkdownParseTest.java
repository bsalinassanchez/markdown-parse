import static org.junit.Assert.*;
import org.junit.*;
import java.util.List;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class MarkdownParseTest {
    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
    }

    @Test
    public void getLinks() throws IOException {
        assertEquals("checks that the method getLinks give correct output",
            List.of("https://something.com", "some-page.html").toString(), 
            MarkdownParse.getLinks(Files.readAllLines(Paths.get("test-file.md")).toArray(String[]::new)).toString());
    }
}