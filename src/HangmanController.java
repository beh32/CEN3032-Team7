import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class HangmanController {

	private String difficultyString = "easy"; //CHANGE based on button selected "easy", "medium", "hard"
	private String wordToGuess;
    private String wordDisplayString; 
    private boolean wordGuessed;
    private int hangmanPartsDrawn;
    private char userInput;
    private Set<Character> usedLetters;
    private Scanner scan;
    private Difficulty difficulty = new Difficulty(difficultyString);
    
    public void hangmanRound() {
        initializeRound();
        getWord(); 
        
        while (hangmanPartsDrawn <=6 && !wordGuessed) {
            System.out.println(wordDisplayString); //Replace with GUI
            System.out.println("Hangman Body Parts Draw: " + hangmanPartsDrawn); 
            System.out.print("Guess: ");
            userInput = scan.next().charAt(0);  
            validateUserInput();

        }

        endRound();

    }

    private void initializeRound() {
        hangmanPartsDrawn = 0;
        wordGuessed = false;
        usedLetters = new HashSet<>(26);
        scan = new Scanner(System.in);
        System.out.println("Round begin");
    }

    private void getWord() {
        wordToGuess = difficulty.getWords(difficultyString); //gets word from difficulty class
        wordDisplayString = "";

        for (int i = 0; i < wordToGuess.length(); ++i) //blank spaces equal to word length 
            wordDisplayString += "_";

    }

    private void validateUserInput() {
        if (Character.isLetter(userInput)  && !usedLetters.contains(userInput)) { // input is letter but not used.
            usedLetters.add(userInput);
            
            if (wordToGuess.contains(Character.toString(userInput))) { //check if letter is in word             
                System.out.println(userInput + " is correct!");
                editWordDisplay();

            
                if (wordDisplayString.equals(wordToGuess)) 
                    wordGuessed = true;

            }
                          
            else {
                System.out.println(userInput + " is incorrect!");
                ++hangmanPartsDrawn;
                // Add hangman UI drawing here
            }
        }

        else 
            System.out.println("Cannot use this letter!");
        
    }    

    private void editWordDisplay() {
        int index = wordToGuess.indexOf(userInput); // Swap code out for word display
                    
                while(index >= 0) { // find all instances
                    wordDisplayString = wordDisplayString.substring(0, index) + userInput + wordDisplayString.substring(index+1);
                    index = wordToGuess.indexOf(userInput, index+1);
                }   
    }

    private void endRound() {
        scan.close();

        if (wordGuessed) 
            System.out.println(wordDisplayString + "\nYou Won!");
        else
            System.out.println(wordToGuess + "\nYou Lost :(");
            
    }

    public boolean isWordGuessed() {
        return wordGuessed;
    }

    public boolean isGameOver() {
        return wordGuessed || hangmanPartsDrawn >= 6;
    }

}
