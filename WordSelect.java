import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.*;
import java.util.Random;

public class WordSelect {
    public String word() {
        String theWord = "";
        Random random = new Random();
        int randomNumber = random.nextInt(58109);
        try (Stream<String> lines = Files.lines(Paths.get("wordbank.txt"))) {
            theWord = lines.skip(randomNumber - 1).findFirst().get();
          }
          catch(IOException e){
            System.out.println(e);
          }
        
        return theWord;
    }
}
