import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WinLossPanel extends JPanel implements ActionListener {

    private WinButton winButton;
    private LossButton lossButton;
    private boolean gameWon;
    private boolean gameLost;

    public WinLossPanel(int WIDTH, int HEIGHT, JPanel container, CardLayout cardLayout) {

        JLabel winLossBg = new JLabel();

        int buttonWidth = 100;
        int buttonHeight = 50;
        int buttonY = HEIGHT - (buttonHeight * 3);

        String winButtonText = "WIN";
        int winButtonX = (WIDTH / 2) - (buttonWidth + 20);
        this.winButton = new WinButton(winButtonText, winButtonX, buttonY, buttonWidth, buttonHeight, container,
                cardLayout);
        this.winButton.addActionListener(this);

        String lossButtonText = "LOSE";
        int lossButtonX = (WIDTH / 2) + 20;
        this.lossButton = new LossButton(lossButtonText, lossButtonX, buttonY, buttonWidth, buttonHeight);
        this.lossButton.addActionListener(this);

        this.setLayout(new BorderLayout());
        this.add(winLossBg);
        winLossBg.setLayout(null);
        winLossBg.add(this.winButton);
        winLossBg.add(this.lossButton);

        this.gameWon = false;
        this.gameLost = false;
    }

    @Override
    public void paintComponent(Graphics g) {

        Graphics2D g2D = (Graphics2D) g.create();
        super.paintComponent(g2D);

        if (this.gameWon || this.gameLost) {
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

        if (e.getSource() == this.winButton) {
            this.gameWon = true;
        }

        if (e.getSource() == this.lossButton) {
            this.gameLost = true;
        }

        repaint();
    }
}
