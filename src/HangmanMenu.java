import javax.swing.JFrame;

public class HangmanMenu extends JFrame {

	private static int HEIGHT = 1000;
	private static int WIDTH = 1200;
	private static JFrame menuFrame = new JFrame();
	
	public static void HangmanMenu() {
		menuFrame.setSize(WIDTH, HEIGHT);
		menuFrame.setResizable(false);
		menuFrame.setTitle("Team 7 Hangman");
		menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		MenuElements openingElement = new MenuElements();
		menuFrame.add(openingElement);
		menuFrame.setVisible(true);
	}
	
	//use for showcase if neccesary
	//remove this main and comments when main for program is created
	public static void main(String args[]) {
		HangmanMenu();
	}
	
}
