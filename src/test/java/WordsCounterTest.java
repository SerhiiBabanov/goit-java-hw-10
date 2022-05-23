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
        wordsCounter.countWordsInFile("fileWords.txt");
    }
}