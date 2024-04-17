import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

public class Difficulty {
	private Random random;
	public int maxLength;
	
	public Difficulty(String difficulty) {
		random = new Random();
		setMaxLength(difficulty);
	}
	
	private void setMaxLength(String difficulty) {
		switch(difficulty) {
		case "easy":
			maxLength = 5;
			break;
		case "medium":
			maxLength = 7;
			break;
		case "hard":
			maxLength = 9;
			break;
		}
	}
	
	public String getWords() {
		String selectedWord = "";
		int wordCount = 0;
		
		try (BufferedReader reader = new BufferedReader(new FileReader("src/wordbank.txt"))) {
			String word;
			while((word = reader.readLine()) != null && selectedWord == "") {
			if(word.length() <= maxLength) {
				wordCount++;
			} if (random.nextInt(57962) <= 20 && word.length() <= maxLength) {
				selectedWord = word;
			}
			if(wordCount >= 57962) {
				break;
			}
			}
		} catch(IOException e) {}
		return selectedWord;
	}
	
}
