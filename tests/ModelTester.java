


import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.junit.Test;



public class ModelTester {
    private ByteArrayInputStream inputStream;
    private InputStream originalSystemIn;

    @Test
    public void testWin() {
        textInputs("a\nm\nz\ni\nn\ng\n"); //amazing is default word
        HangmanModel hc = new HangmanModel();
        hc.hangmanRound();
        assertTrue(hc.isWordGuessed());
        System.setIn(originalSystemIn);

    }

    @Test
    public void testFail() {
        textInputs("b\nc\nd\ne\nf\nh\nj\n"); //7 tries 
        HangmanModel hc = new HangmanModel();
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
        HangmanModel hc = new HangmanModel();
        hc.hangmanRound(); 
    }

}

    