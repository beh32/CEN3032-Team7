import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WinLossPanel extends JPanel implements ActionListener {

    private ReplayButton replayButton;
    private static boolean gameWon;
    private static boolean gameLost;

    public WinLossPanel(int WIDTH, int HEIGHT, JPanel container, CardLayout cardLayout) {

        JLabel winLossBg = new JLabel();

        int buttonWidth = 200;
        int buttonHeight = 50;
        int buttonY = HEIGHT - (buttonHeight * 3);

        String replayButtonText = "REPLAY HANGMAN";
        int replayButtonX = (WIDTH / 2) - (buttonWidth + 20);
        this.replayButton = new ReplayButton(replayButtonText, replayButtonX, buttonY, buttonWidth, buttonHeight,
                container,
                cardLayout);
        this.replayButton.addActionListener(this);

        this.setLayout(new BorderLayout());
        this.add(winLossBg);
        winLossBg.setLayout(null);
        winLossBg.add(this.replayButton);

        this.gameWon = false;
        this.gameLost = false;
    }

    @Override
    public void paintComponent(Graphics g) {

        Graphics2D g2D = (Graphics2D) g.create();
        super.paintComponent(g2D);

        if (gameWon || gameLost) {
            this.drawGameOverText(g2D);
        }
    }

    private String gameOverText() {

        if (gameWon) {
            return "YOU WIN!";
        } else {
            return "YOU LOST!";
        }
    }

    private void drawGameOverText(Graphics2D g2D) {

        String text = this.gameOverText();
        String fontName = g2D.getFont().getFontName();
        int fontSize = 100;
        Font font = new Font(fontName, Font.BOLD, fontSize);
        g2D.setFont(font);

        int textX = (800 / 2) - (g2D.getFontMetrics().stringWidth(text) / 2);
        int textY = (600 / 2) - (g2D.getFontMetrics().getHeight() / 2);

        if (text.equals("YOU WIN!")) {
            g2D.setPaint(Color.GREEN);
        } else {
            g2D.setPaint(Color.RED);
        }
        g2D.drawString(text, textX, textY);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == this.replayButton) {
            this.replayButton.swapCard("1");
        }
        repaint();
    }
}
