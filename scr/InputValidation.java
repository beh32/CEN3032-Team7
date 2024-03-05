package scr;

public class InputValidation {

    public boolean validLetter(char inputChar) {
        if (Character.isLetter(inputChar))
            return true;
        return false;
    }
}