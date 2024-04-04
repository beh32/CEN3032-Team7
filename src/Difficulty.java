import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

public class Difficulty {
	private Random random;
	private int maxLength;
	
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
	
	public String getWords(String difficulty) {
		String selectedWord = "";
		int wordCount = 0;
		
		try (BufferedReader reader = new BufferedReader(new FileReader("src/wordbank.txt"))) {
			String word;
			while((word = reader.readLine()) != null && selectedWord == "") {
			if(word.length() <= maxLength) {
				wordCount++;
			} if (random.nextInt(58109) <= 10 && word.length() <= maxLength) {
				selectedWord = word;
			}
			if(wordCount >= 58109) {
				break;
			}
			}
		} catch(IOException e) {}
		return selectedWord;
	}
	
}
