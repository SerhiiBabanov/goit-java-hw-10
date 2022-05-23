import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

class WordsCounterTest {
    private WordsCounter wordsCounter;

    @BeforeEach
    void setUp() {
        wordsCounter = new WordsCounter();
        File file = new File("fileWords.txt");
        try (FileOutputStream fileWriter = new FileOutputStream(file);
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(fileWriter))) {
            writer.write("the day is sunny the the" + '\n');
            writer.write("the sunny is is");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void countWordsInFile() {

        PrintStream consoleStream = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(outputStream);
        System.setOut(stream);
        wordsCounter.countWordsInFile("fileWords.txt");
        assertTrue(outputStream.toString().trim().equals("the 4\n" +
                "is 3\n" +
                "sunny 2\n" +
                "day 1"));

        System.setOut(consoleStream);
    }
}