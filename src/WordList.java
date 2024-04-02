import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class WordList {

    private ArrayList<Word> listOfWords;
    private Random rand;
    private Word defaultWord;

    public WordList() {
        this.listOfWords = new ArrayList<>();
        this.rand = new Random();
        this.defaultWord = new Word("default");
        addWordsToListOfWords();
    }

    private void addWordsToListOfWords() {
        try {
            File words = new File("wordbank.txt");
            Scanner reader = new Scanner(words);

            while (reader.hasNextLine()) {
                String data = reader.nextLine().strip();
                Word word = new Word(data.toLowerCase());
                word.splitWordToLetters();
                this.listOfWords.add(word);
            }

            reader.close();
        } catch (FileNotFoundException e) {
        }
    }

    public Word selectRandomWord() {
        if (this.listOfWords.size() > 0) {
            int upperbound = this.listOfWords.size();
            return this.listOfWords.get(rand.nextInt(upperbound));
        }
        return this.defaultWord;
    }

    public void resetListOfWords() {
        this.listOfWords.clear();
    }
}
