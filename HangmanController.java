import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class HangmanController {

    private Set<Character> usedLetters;
    private String hangmanWord;
    private int level;
    private int figureCount;
    private char userInput;
    private boolean wordGuessed;

    public HangmanController() {
        usedLetters = new HashSet<>(26);
        hangmanWord = "Amazing"; // default word use wordbank
        figureCount = 0;
        wordGuessed = false;
        level = level++;
    }


    public void hangmanRound() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Round begin");

        while (figureCount <=6 && !wordGuessed) {
            userInput = scan.next().charAt(0);
            
            if (Character.isLetter(userInput)  && !usedLetters.contains(userInput)) {
                    usedLetters.add(userInput);
                
                    if (hangmanWord.contains(Character.toString(userInput))) {}
                    
                    else 
                        ++figureCount;
                    
                }

            else {
                System.out.println("Cannot use this letter!");
            }
        
        }

        scan.close();
        
    }

    public static boolean validLetter(char inputChar) {
        return Character.isLetter(inputChar);
    }
    
    public static boolean charUsed(Set<Character> usedLetters, char inputChar) {
        return usedLetters.contains(inputChar);
    }

    public static boolean wordContains(String word,char inputChar) {
        return word.contains(Character.toString(inputChar));
    }

}