import javax.swing.JFrame;

public class HangmanMenu extends JFrame {

	private static int HEIGHT = 1000;
	private static int WIDTH = 1200;
	private static JFrame menuFrame = new JFrame();
	
	private static void HangmanMenu() {
		menuFrame.setSize(WIDTH, HEIGHT);
		menuFrame.setResizable(false);
		menuFrame.setTitle("Team 7 Hangman");
		menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//MenuElements openingElement = new MenuElements();
		//menuFrame.add();
		menuFrame.setVisible(true);
	}
}
