import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class HangmanController {

    private Set<Character> usedLetters;
    private String hangmanWord;
    private String hiddenWord;
    private int figureCount;
    private char userInput;
    private boolean wordGuessed;

    public HangmanController() {
        usedLetters = new HashSet<>(26);
        hangmanWord = "amazing"; // default word use wordbank
        hiddenWord = "";

        for (int i = 0; i < hangmanWord.length(); ++i)
            hiddenWord += "_";

        figureCount = 0;
        wordGuessed = false;
    }

    
    public void hangmanRound() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Round begin");

        while (figureCount <=6 && !wordGuessed) {
            System.out.println(hiddenWord);
            System.out.println(figureCount);

            userInput = scan.next().charAt(0);
            
            if (Character.isLetter(userInput)  && !usedLetters.contains(userInput)) {
                    usedLetters.add(userInput);
                
                    if (hangmanWord.contains(Character.toString(userInput))) {
                        // Add stuff for word being correct here. 
                        int index = hangmanWord.indexOf(userInput);
                        while(index >= 0) {
                            System.out.println(index);
                            hiddenWord = hiddenWord.substring(0, index) + userInput + hiddenWord.substring(index+1);
                            index = hangmanWord.indexOf(userInput, index+1);
                        }                       
                        
                        if (hiddenWord.equals(hangmanWord))
                            wordGuessed = true;

                    }
                    
                    else 
                        ++figureCount;
                    
                }

            else {
                System.out.println("Cannot use this letter!");
            }

        }
        
        if (wordGuessed) 
            System.out.println(hiddenWord + "\nYou Won!");
        else
            System.out.println(hangmanWord + "\nYou Lost :(");

        scan.close();
        
    }

}