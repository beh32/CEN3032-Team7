import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        final int WIDTH = 800;
        final int HEIGHT = 600;
        final String TITLE = "Hangman Game";

        JFrame screen = new JFrame();
        CardLayout cardLayout = new CardLayout();
        screen.setSize(new Dimension(WIDTH, HEIGHT));
        screen.setTitle(TITLE);
        screen.setLocationRelativeTo(null);
        screen.setResizable(false);
        screen.setDefaultCloseOperation(screen.EXIT_ON_CLOSE);

        JPanel container = new JPanel();
        container.setLayout(cardLayout);
        screen.add(container);

        WinLossPanel startScreenPanel = new WinLossPanel(WIDTH, HEIGHT, container, cardLayout);

        container.add(startScreenPanel, "1");

        screen.setVisible(true);
    }
}
