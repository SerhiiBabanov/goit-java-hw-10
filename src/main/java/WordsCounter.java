import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WordsCounter {
    public void countWordsInFile(String fileName) {
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            Map<String, Long> wordFreq = stream.flatMap(s -> Stream.of(s.split(" ")))
                    .collect(Collectors.groupingBy(String::toString, Collectors.counting()))
                    .entrySet().stream()
                    .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (k, v) -> k, LinkedHashMap::new));
            for (var entry : wordFreq.entrySet()) {
                System.out.print(entry.getKey() + " " + entry.getValue() + "\n");
            }
        } catch (IOException e) {
            System.err.println(e.getMessage()); // Handle a potential exception
        }
    }
}
