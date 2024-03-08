import javax.swing.*;
import java.awt.*;

public class Button extends JButton {

    private String text;
    private int x;
    private int y;
    private int width;
    private int height;

    public Button(String text, int x, int y, int width, int height) {
        this.text = text;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;

        this.setBounds(this.x, this.y, this.width, this.height);
        this.setText(this.text);
        this.setFocusable(false);
    }

    public Button(String text) {
        this.text = text;

        this.setText(this.text);
        this.setFocusable(false);
    }
}

class StartButton extends Button {

    private JPanel container;
    private CardLayout cardLayout;

    public StartButton(String text, int x, int y, int width, int height, JPanel container, CardLayout cardLayout) {
        super(text, x, y, width, height);
        this.container = container;
        this.cardLayout = cardLayout;
    }

    public void swapCard(String cardNum) {
        this.cardLayout.show(this.container, cardNum);
    }
}

class QuitButton extends Button {

    public QuitButton(String text, int x, int y, int width, int height) {
        super(text, x, y, width, height);
    }

}

// class InstructionsButton extends Button {

// }

// class SettingsButton extends Button {

// }
