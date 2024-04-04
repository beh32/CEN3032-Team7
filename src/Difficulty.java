import java.util.ArrayList;
import java.util.List;

public class DIfficulty {
	String fileName = "wordbank.txt";
	private List<String> easyWords;
	private List<String> mediumWords;
	private List<String> hardWords;
	
	public Difficulty(List<String> easyWords, List<String> mediumWords, List<String> hardWords) {
		
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
		} catch(IOException e) {}
	}
		
	public List<String> getEasyWords() {
		return easyWords;
	}
	
	public List<String> getMediumWords() {
		return mediumWords;
	}
	
	public List<String> getHardWords() {
		return hardWords;
	}
}
