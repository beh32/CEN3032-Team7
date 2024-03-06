import java.util.Set;

public class InputValidation {
    
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