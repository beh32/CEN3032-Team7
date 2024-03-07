import javax.swing.*;
import java.awt.*;

public class InstructionsFrame extends JFrame {
	
	public InstructionsFrame() {
		setSize(600, 400);
		setResizable(false);
		setTitle("Hangman Instructions");
		
		JTextArea instructions = new JTextArea();
		instructions.setEditable(true);
		instructions.setFont(new Font("Arial", Font.PLAIN, 14));
		instructions.setLineWrap(true);
		instructions.setWrapStyleWord(true);
		super.add(instructions);
		
		instructions.setText("Welcome to Team 7's Hangman game! In Hangman, the player tries to figure out the word being displayed by inputting letters into the keyboard as guesses.\n"
				+ "Correct guesses will display in the blank spaces while wrong guesses will cause part of the hangman figure to be drawn.\n "
				+ "The player wins if they can guess all the letters before the hangman figure finishes drawing.\n"
				+ "Click 'Start Game' to begin!");
	}
}
