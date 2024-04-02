import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;


public class WordSort {
	
	public WordSort() {
		String fileName = "wordbank.txt";
		List<String> easyWords = new ArrayList<>();
		List<String> mediumWords = new ArrayList<>();
		List<String> hardWords = new ArrayList<>();
		
		try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
			String line;
			//sort words by length
			if(!line.isEmpty()) {
			if(line.length() <= 5) {
				easyWords.add(line);
			} else if (line.length() <= 7) {
				mediumWords.add(line);
			} else {
				hardWords.add(line);
			}
			}
		} catch(IOException e) {
			//insert what to do if IO fails
		}
		Difficulty difficulty = new Difficulty(easyWords, mediumWords, hardWords);
		
	}
}
