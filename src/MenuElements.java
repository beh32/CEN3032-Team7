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
	
	public void paintComponent(Graphics g) {
		
		Graphics2D g2D = (Graphics2D) g;
		try {
			menuBackground = ImageIO.read(new File("images/chalkboardStockPhoto.jpg"));
		} catch(IOException e) {}
		
		g2D.drawImage(menuBackground, 0, 0, 1200, 1000, null);
		g2D.setFont(new Font("Arial", Font.BOLD, 50));
		g2D.setColor(Color.WHITE);
		g2D.drawString("Group 7 Hangman", 300, 300);
		
		quitButton.setBounds(320, 600, 400, 100);
		quitButton.setFont(new Font("Arial", Font.BOLD, 30));
		super.add(quitButton);
		
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == quitButton) {
			System.exit(0);
		}
	}
}
