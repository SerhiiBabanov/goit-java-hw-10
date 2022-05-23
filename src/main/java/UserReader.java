import com.google.gson.Gson;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Stream;

public class UserReader {
    public void readTxtToJson(String fileInName, String fileOutName){
        ArrayList<User> users = new ArrayList<User>();
        try (Stream<String> stream = Files.lines(Paths.get(fileInName))) {
            stream.skip(1).forEach(s -> {
                users.add(new User(s.split(" ")[0], Integer.valueOf(s.split(" ")[1])));
            });   //collect(Collectors.toCollection(ArrayList::new));
        }
        catch (IOException e) {
            System.err.println(e.getMessage());// Handle a potential exception
        }

        try(FileOutputStream fileOutputStream = new FileOutputStream(new File(fileOutName))
        ) {
            String res = new Gson().toJson(users);
            fileOutputStream.write(res.getBytes(StandardCharsets.UTF_8));
        } catch (IOException ex){
            System.err.println(ex.getMessage());
        }

    }
    class User{
        private String name;
        private int age;

        public User(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }
}
