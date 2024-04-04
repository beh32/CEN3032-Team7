import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

public class Difficulty {
	String fileName = "wordbank.txt";
	private Random random;
	private int maxLength;
	
	public Difficulty() {
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
		String selectedWord = null;
		int wordCount = 0;
		
		try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
			String word;
			while((word = reader.readLine()) != null) {
			if(word.length() <= maxLength) {
				wordCount++;
			} if (random.nextInt(wordCount) == 0) {
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
