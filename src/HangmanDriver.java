import javax.swing.*;
import java.awt.*;

public class HangmanDriver {
    public static void main(String[] args) {

        // Use a single JFrame
        final int HEIGHT = 1000;
        final int WIDTH = 1200;
        final ImageIcon gameBackground = new ImageIcon("../images/chalkboardStockPhoto.jpg");

        JFrame gameScreen = new JFrame();
        CardLayout cardLayout = new CardLayout();

        gameScreen.setSize(new Dimension(WIDTH, HEIGHT));
        gameScreen.setTitle("Team 7 Hangman");
        gameScreen.setLocationRelativeTo(null);
        gameScreen.setResizable(false);
        gameScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel container = new JPanel();
        container.setLayout(cardLayout);
        gameScreen.add(container);

        MenuElements menuElements = new MenuElements(WIDTH, HEIGHT, gameBackground, container, cardLayout);
        HangmanUI hangmanUI = new HangmanUI(WIDTH, HEIGHT, container, cardLayout);

        container.add(menuElements, "1");
        container.add(hangmanUI, "2");

        gameScreen.setVisible(true);
    }
}
