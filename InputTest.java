import org.junit.Test;
import static org.junit.Assert.assertTrue;
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

    }

    @Test
    public void wordContains() {
        
    }
}