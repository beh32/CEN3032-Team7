import javax.swing.*;
import java.io.*;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.*;
import java.awt.Image.BufferedImage;

public class MenuElements extends JFrame {

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
	}
	
	public void actionPerformed(ActionEvent e) {
		
	}
}
