import javax.swing.JFrame;

public class OpeningMenu extends JFrame {

	private static int HEIGHT = 1000;
	private static int WIDTH = 1200;
	private static JFrame menuFrame = new JFrame();
	
	public void createOpeningMenu() {
		menuFrame.setSize(WIDTH, HEIGHT);
		menuFrame.setResizable(false);
		menuFrame.setTitle("Team 7 Hangman");
		menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		MenuElements openingElement = new MenuElements();
		menuFrame.add(openingElement);
		menuFrame.setVisible(true);
	}
}
