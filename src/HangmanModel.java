import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class HangmanModel {

    private String wordToGuess;
    private String wordDisplayString; 
    private String userPrompt;
    private boolean wordGuessed;
    private int hangmanPartsDrawn;
    private char userInput;
    private Set<Character> usedLetters;
    private Scanner scan;

    public void hangmanRound() {
        initializeRound();
        getWord();
    }

    private void initializeRound() {
        hangmanPartsDrawn = 0;
        wordGuessed = false;
        usedLetters = new HashSet<>(26);
        scan = new Scanner(System.in);
        userPrompt = "Round begin";
    }

    private void getWord() {
        wordToGuess = "amazing"; // default word use wordbank class for wordToGuess/wordDisplayString
        wordDisplayString = "";

        for (int i = 0; i < wordToGuess.length(); ++i) //blank spaces equal to word length 
            wordDisplayString += "_";

    }

    public void validateUserInput(char userInput) {
        this.userInput = userInput;
        System.out.println(wordDisplayString);
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
            userPrompt = "Cannot use this letter!";
        }

    }    

    private void editWordDisplay() {
        int index = wordToGuess.indexOf(userInput); // Swap code out for word display
                    
                while(index >= 0) { // find all instances
                    wordDisplayString = wordDisplayString.substring(0, index) + userInput + wordDisplayString.substring(index+1);
                    index = wordToGuess.indexOf(userInput, index+1);
                }   
    }

    public void endRound() {
        scan.close();

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
