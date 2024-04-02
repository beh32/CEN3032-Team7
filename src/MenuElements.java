import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class MenuElements extends JPanel implements ActionListener {

	private StartButton startButton;
	private QuitButton quitButton;

	// These buttons can eventually be put into the Button class
	private JButton settingsButton = new JButton("Settings");
	private JButton instructionsButton = new JButton("Instructions");
	private static BufferedImage menuBackground;
	
	private InstructionsFrame instructionsFrame = new InstructionsFrame();
	
	public MenuElements(int WIDTH, int HEIGHT, ImageIcon backgroundImage, JPanel container, CardLayout cardLayout) {
		JLabel menuBackground = new JLabel();

		int buttonWidth = 200;
		int buttonHeight = 100;
		int buttonY = HEIGHT - (buttonHeight * 3);

		String startButtonText = "Start Game";
		int startButtonX = (WIDTH / 2) - (buttonWidth + 20);
		this.startButton = new StartButton(startButtonText, startButtonX, buttonY, buttonWidth, buttonHeight, container,
				cardLayout);
		this.startButton.addActionListener(this);
		settingsButton.addActionListener(this);
		instructionsButton.addActionListener(this);
		Font startButtonFont = startButton.getFont();
		float newSize = startButtonFont.getSize() + 8.0f;
		startButton.setFont(startButtonFont.deriveFont(newSize));

		String quitButtonText = "Quit Game";
		int quitButtonX = (WIDTH / 2) + 20;
		this.quitButton = new QuitButton(quitButtonText, quitButtonX, buttonY, buttonWidth, buttonHeight);
		this.quitButton.addActionListener(this);
		Font quitButtonFont = quitButton.getFont();
		quitButton.setFont(quitButtonFont.deriveFont(newSize));

		this.setLayout(new BorderLayout());
		this.add(menuBackground);

		menuBackground.setLayout(null);
		menuBackground.add(this.startButton);
		menuBackground.add(this.quitButton);
	}
	
	public void paintComponent(Graphics g) {
		
		Graphics2D g2D = (Graphics2D) g;
		try {
			menuBackground = ImageIO.read(new File("../images/chalkboardStockPhoto.jpg"));
		} catch(IOException e) {}
		
		g2D.drawImage(menuBackground, 0, 0, 1200, 1000, null);
		g2D.setFont(new Font("Arial", Font.BOLD, 50));
		g2D.setColor(Color.WHITE);
		g2D.drawString("Group 7 Hangman", 300, 300);

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
		} else if (e.getSource() == startButton) {
			this.startButton.swapCard("2");
		} else if(e.getSource() == settingsButton) {
			
			//OPTIONS MENU TO BE ADDED WITH FUTURE SPRINT
		} else if(e.getSource() == instructionsButton) {
			instructionsFrame.setVisible(true);
		}
		
	}
}
