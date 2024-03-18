import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.FlowLayout;


public class PauseMenu extends JFrame {
    public PauseMenu() {
        super("Pause Menu");
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(new EmptyBorder(2, 3, 2, 3));
        JPanel layout = new JPanel(new GridBagLayout());
        layout.setBorder(new EmptyBorder(5, 5, 5, 5));
        
        //"Game Paused"
        /*JPanel topPanel = new JPanel(new BorderLayout());
        JLabel paused = new JLabel("Game Paused");
        paused.setFont(new Font("Sans-serif", Font.BOLD, 14));
        topPanel.add(paused);*/

        JPanel buttonPanel = new JPanel(new GridLayout(10, 1, 10, 5));
        //"Game Paused"
        JLabel paused = new JLabel("Game Paused");
        paused.setFont(new Font("Sans-serif", Font.BOLD, 16));
        buttonPanel.add(paused);
        
        //Resume button
        JButton resume = new JButton("Resume Game");
        buttonPanel.add(resume);


        //Options button
        JButton options = new JButton("Options");
        buttonPanel.add(options);

        //Main menu button
        JButton mainMenu = new JButton("Main Menu");
        buttonPanel.add(mainMenu);

        //Quit button
        JButton quit = new JButton("Quit Game");
        buttonPanel.add(quit);

        //layout.add(topPanel);
        layout.add(buttonPanel);
        panel.add(layout, BorderLayout.CENTER);
        add(panel);


        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        setSize(300, 200); 
        // Center the frame on the screen
        setLocationRelativeTo(null); 
        setVisible(true); 
    }
    
    public static void main(String[] args) {
        // Create an instance of PauseMenu
        new PauseMenu(); 
    }
}
