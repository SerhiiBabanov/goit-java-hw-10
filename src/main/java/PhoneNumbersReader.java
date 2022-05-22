import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;


public class PhoneNumbersReader {
    public void read(String fileName){
        try {
            String reg = "(.*)\\(?\\d{3}\\)?[\\s-]\\d{3}-\\d{4}(.*)";
            Files.lines(Paths.get(fileName)).filter(s -> s.matches(reg)).forEach(s -> System.out.print(s + "\n"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
