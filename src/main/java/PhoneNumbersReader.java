import java.io.*;

public class PhoneNumbersReader {
    public void read(String fileName){
        File file = new File(fileName);
        try (FileInputStream fileInputStream = new FileInputStream(file);
                BufferedReader reader = new BufferedReader(new InputStreamReader(fileInputStream))) {
            String s;
            while ((s = reader.readLine()) != null)   {
                if (s.matches("(.*)\\(?\\d{3}\\)?[\\s-]\\d{3}-\\d{4}(.*)"))
                {
                    System.out.print(s + "\n");
                }
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
