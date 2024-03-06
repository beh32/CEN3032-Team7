import org.junit.Test;
import static org.junit.Assert.assertTrue;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertFalse;;


public class InputTest {

    @Test
    public void ValidLetterTest() {
        assertTrue(InputValidation.validLetter('a'));
        assertFalse(InputValidation.validLetter('@'));
        assertFalse(InputValidation.validLetter('1'));

    }

    @Test
    public void WasUsedTest() {
        Set<Character> usedLetters = new HashSet<>();
        usedLetters.add('a');
        usedLetters.add('b');
        usedLetters.add('c');
        usedLetters.add('d');
        usedLetters.add('e');
        usedLetters.add('f');
        usedLetters.add('g');
        usedLetters.add('h');

        assertTrue(InputValidation.charUsed(usedLetters, 'b'));
        assertFalse(InputValidation.charUsed(usedLetters, 'z'));
        assertFalse(InputValidation.charUsed(usedLetters, '@'));
    }

    @Test
    public void wordContainsTest() {
        String testWord = "amazing";
        assertTrue(InputValidation.wordContains(testWord,'a'));
        assertFalse(InputValidation.wordContains(testWord,'y'));
        assertFalse(InputValidation.wordContains(testWord,'@')); //symbols will be blocked prior but just to check

    }
}