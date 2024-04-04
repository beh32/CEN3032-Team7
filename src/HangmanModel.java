import java.util.HashSet;
import java.util.Set;

public class HangmanModel {

	private String difficultyString; //CHANGE based on button selected "easy", "medium", "hard"
	private String wordToGuess;
    private String wordDisplayString; 
    private String userPrompt;
    private boolean wordGuessed;
    private int hangmanPartsDrawn;
    private char userInput;
    private Set<Character> usedLetters;
    private Difficulty difficulty;

    public void hangmanRound(String difficultyString) {
        difficulty = new Difficulty(difficultyString);
        getWord();
        initializeRound();
    }

    private void initializeRound() {
        hangmanPartsDrawn = 0;
        wordGuessed = false;
        usedLetters = new HashSet<>(26);
        userPrompt = "Round begin";
    }

    private void getWord() {
    	wordToGuess = difficulty.getWords(difficultyString); //gets word from difficulty class
        wordDisplayString = "";

        for (int i = 0; i < wordToGuess.length(); ++i) //blank spaces equal to word length 
            wordDisplayString += "_";

    }

    public void validateUserInput(char userInput) {
        this.userInput = userInput;
        if (Character.isLetter(userInput)  && !usedLetters.contains(userInput)) { // input is letter but not used.
            usedLetters.add(userInput);
            
            if (wordToGuess.contains(Character.toString(userInput))) { //check if letter is in word
                
                userPrompt = userInput + " is correct!";
                editWordDisplay();

            
                if (wordDisplayString.equals(wordToGuess)) 
                    wordGuessed = true;

            }

            else {
                userPrompt = userInput + " is incorrect!";
                ++hangmanPartsDrawn;
                // Add hangman UI drawing here
            }
        } else {
            if (!usedLetters.contains(userInput)) 
                userPrompt = "Please choose a Letter";    
            else 
                userPrompt = "Letter already used";    
            
        }

    }    

    private void editWordDisplay() {
        int index = wordToGuess.indexOf(userInput); // Swap code out for word display
                    
                while(index >= 0) { // find all instances
                    wordDisplayString = wordDisplayString.substring(0, index) + userInput + wordDisplayString.substring(index+1);
                    index = wordToGuess.indexOf(userInput, index+1);
                }   
    }

    public void endRound() { //FIX INSTANCE PROBLEM

        if (wordGuessed) 
            userPrompt = "    You won!";
        else
            userPrompt = "You lost! The word was: " + wordToGuess;
        // Disable input fields or handle end of game actions
            
    }

    public String getWordDisplayString() {
        return wordDisplayString;
    }

    public int getHangmanPartsDrawn() {
        return hangmanPartsDrawn;
    }

    public boolean isWordGuessed() {
        return wordGuessed;
    }

    public String getPrompt() {
       return userPrompt; 
    }

}
