import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class UserReaderTest {
    private UserReader testReader;
    @BeforeEach
    void setUp() {
        testReader = new UserReader();
        File file = new File("fileUser.txt");
        try (FileOutputStream fileWriter = new FileOutputStream(file);
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(fileWriter))) {
            writer.write("name age" + '\n');
            writer.write("alice 21" + '\n');
            writer.write("ryan 30" + '\n');
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    @Test
    void readTxtToJson() {
        testReader.readTxtToJson("fileUser.txt", "fileUser.json");
        String res = "";
        try {
            res = Files.readString(Path.of("fileUser.json"));
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        assertTrue(res.equals("[{\"name\":\"alice\",\"age\":21},{\"name\":\"ryan\",\"age\":30}]"));

    }
}