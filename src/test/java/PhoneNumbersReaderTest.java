import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

class PhoneNumbersReaderTest {
    private PhoneNumbersReader testReader;
    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        testReader = new PhoneNumbersReader();
        File file = new File("file.txt");
        try (FileOutputStream fileWriter = new FileOutputStream(file);
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(fileWriter))) {
            writer.write("987-123-4567" + '\n');
            writer.write("123 456 7890" + '\n');
            writer.write("(123) 456-7890" + '\n');
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @org.junit.jupiter.api.Test
    void read() {
        PrintStream consoleStream = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(outputStream);
        System.setOut(stream);
        testReader.read("file.txt");
        assertTrue(outputStream.toString().trim().equals("987-123-4567\n" +
                                                  "(123) 456-7890"));
    }
}