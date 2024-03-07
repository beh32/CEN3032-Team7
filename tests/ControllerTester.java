


import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.InputStream;



public class ControllerTester {
    private ByteArrayInputStream inputStream;
    private InputStream originalSystemIn;

    @Test
    public void testWin() {
        textInputs("a\nm\nz\ni\nn\ng\n"); //amazing is default word
        HangmanController hc = new HangmanController();
        hc.hangmanRound();
        assertTrue(hc.isWordGuessed());
        System.setIn(originalSystemIn);

    }

    @Test
    public void testFail() {
        textInputs("b\nc\nd\ne\nf\nh\nj\n"); //7 tries 
        HangmanController hc = new HangmanController();
        hc.hangmanRound();
        assertFalse(hc.isWordGuessed());
        System.setIn(originalSystemIn);

    }

    private void textInputs(String input) {
        originalSystemIn = System.in;
        inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
    }

    public static void main(String[] args) {
        HangmanController hc = new HangmanController();
        hc.hangmanRound(); 
    }

}

    