import org.junit.jupiter.api.*;
import java.io.IOException;
import java.nio.file.*;

import static org.junit.jupiter.api.Assertions.*;

class FileProcessorTest {

    private static final String TEST_FILE = "testfile.txt";
    private final FileProcessor processor = new FileProcessor();

    @AfterEach
    void cleanUp() throws IOException {
        Files.deleteIfExists(Paths.get(TEST_FILE));
    }

    @Test
    void testWriteAndReadFile() throws IOException {
        String content = "Hello, World!";
        processor.writeToFile(TEST_FILE, content);

        String result = processor.readFromFile(TEST_FILE);
        assertEquals(content, result);
    }

    @Test
    void testFileExistsAfterWriting() throws IOException {
        processor.writeToFile(TEST_FILE, "Sample text");

        assertTrue(Files.exists(Paths.get(TEST_FILE)));
    }

    @Test
    void testIOExceptionWhenFileMissing() {
        String nonExistentFile = "does_not_exist.txt";

        assertThrows(IOException.class, () -> {
            processor.readFromFile(nonExistentFile);
        });
    }
}
