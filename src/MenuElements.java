import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class MenuElements extends JComponent implements ActionListener {

	private JButton startButton = new JButton("Start Game");
	private JButton quitButton = new JButton("Quit Game");
	private JButton settingsButton = new JButton("Settings");
	private JButton instructionsButton = new JButton("Instructions");
	private static BufferedImage menuBackground;
	
	private InstructionsFrame instructionsFrame = new InstructionsFrame();
	private JFrame menuFrame;

	public MenuElements(JFrame menuFrame) {
		this.menuFrame = menuFrame;
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
		
		startButton.setBounds(400, 400, 300, 100);
		startButton.setFont(new Font("Arial", Font.BOLD, 30));
		super.add(startButton);
		
		quitButton.setBounds(400, 550, 300, 100);
		quitButton.setFont(new Font("Arial", Font.BOLD, 30));
		super.add(quitButton);
		
		settingsButton.setBounds(880, 100, 200, 70);
		settingsButton.setFont(new Font("Arial", Font.BOLD, 20));
		super.add(settingsButton);
		
		instructionsButton.setBounds(880, 200, 200, 70);
		instructionsButton.setFont(new Font("Arial", Font.BOLD, 20));
		super.add(instructionsButton);
		
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == quitButton) {
			System.exit(0);
		} else if(e.getSource() == startButton) {
			

			String[] options = { "easy", "medium", "hard" };
    		var selection = JOptionPane.showOptionDialog(null, "Select one:", "Choose a Difficulty", 
			0, 3, null, options, options[0]);
    
			menuFrame.setVisible(false);
			HangmanLevels hl = new HangmanLevels();
			hl.startHangman(options[selection]); //FIX INSTANCE PROBLEM
			
			
		} else if(e.getSource() == settingsButton) {

			new OptionsMenu();

		} else if(e.getSource() == instructionsButton) {

			instructionsFrame.setVisible(true);
			
		}
		
	}
}
