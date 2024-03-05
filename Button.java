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
}

class WinButton extends Button {

    private JPanel container;
    private CardLayout cardLayout;

    public WinButton(String text, int x, int y, int width, int height, JPanel container, CardLayout cardLayout) {
        super(text, x, y, width, height);
        this.container = container;
        this.cardLayout = cardLayout;
    }

    public void swapCard(String cardNum) {
        this.cardLayout.show(this.container, cardNum);
    }
}

class LossButton extends Button {

    public LossButton(String text, int x, int y, int width, int height) {
        super(text, x, y, width, height);
    }

}
