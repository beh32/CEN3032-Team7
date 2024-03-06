import javax.swing.*;
import java.io.*;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

public class MenuElements extends JComponent implements ActionListener {

	private JButton startButton = new JButton("Start Game");
	private JButton quitButton = new JButton("Quit Game");
	private JButton settingsButton = new JButton("Settings");
	private JButton instructionsButton = new JButton("Instructions");
	private static BufferedImage menuBackground;
	
	public MenuElements() {
		startButton.addActionListener(this);
		quitButton.addActionListener(this);
		settingsButton.addActionListener(this);
		instructionsButton.addActionListener(this);
	}
	
	public void paintElements(Graphics g) {
		
		Graphics2D g2d = (Graphics2D) g;
		try {
			menuBackground = ImageIO.read(new File("images/chalkboardStockPhoto.jpg"));
		} catch(IOException e) {}
		
		g2d.drawImage(menuBackground, 0, 0, 1000, 1200, null);
		g2d.setColor(Color.WHITE);
		g2d.drawString("Group 7 Hangman", 300, 300);
		
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource == quitButton) {
			System.exit(0);
		}
	}
}
