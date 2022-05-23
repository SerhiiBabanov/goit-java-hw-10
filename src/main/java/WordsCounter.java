import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WordsCounter {
    public void countWordsInFile(String fileName) {
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            ArrayList<String> arrayList = stream.flatMap(s -> Stream.of(s.split(" "))).collect(Collectors.toCollection(ArrayList::new));
            ArrayList<String> uniqWords = arrayList.stream().distinct().collect(Collectors.toCollection(ArrayList::new));
            

            System.out.println("test");
        } catch (IOException e) {
            System.err.println(e.getMessage()); // Handle a potential exception
        }
    }
}
