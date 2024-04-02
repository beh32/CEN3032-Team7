import java.util.ArrayList;
import java.util.List;

public class DIfficulty {
	
	private List<String> easyWords;
	private List<String> mediumWords;
	private List<String> hardWords;
	
	public Difficulty(List<String> easyWords, List<String> mediumWords, List<String> hardWords) {
		this.easyWords = easyWords;
		this.mediumWords = mediumWords;
		this.hardWords = hardWords;
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
