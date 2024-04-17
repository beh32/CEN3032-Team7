import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class OptionsMenu extends JFrame {
    public OptionsMenu() {
        super("Options Menu");
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(new EmptyBorder(2, 3, 2, 3));
        JPanel layout = new JPanel();
        layout.setLayout(new BoxLayout(layout, BoxLayout.Y_AXIS));

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(0, 1, 10, 5));
        
        //"Options"
        JLabel options = new JLabel("Options");
        options.setFont(new Font("Sans-serif", Font.BOLD, 16));
        buttonPanel.add(options);
        
        //Return to game
        JButton resumeButton = new JButton("Return to Game");
        resumeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //To resume the game, exit out of the pause menu
                //But keep the game open
                dispose();
            }
        }); 
        buttonPanel.add(resumeButton);

        //Main menu button
        JButton mainMenuButton = new JButton("Return to Main Menu");
        // Add the controller as an ActionListener to the button
        mainMenuButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //Doesn't work
                OpeningMenu hangmanMenu = new OpeningMenu();
                hangmanMenu.createOpeningMenu(); //FIX INSTANCE PROBLEM
            }
        }); 
        buttonPanel.add(mainMenuButton);

        //"Change Theme"
        JLabel changeTheme = new JLabel("Change Theme");
        changeTheme.setFont(new Font("Sans-serif", Font.BOLD, 16));
        buttonPanel.add(changeTheme);

        //Theme settings
        JButton themeButton = new JButton("Quit Game");
        themeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //Action
            }
        }); 
        buttonPanel.add(themeButton);

        //"Adjust Guesses"
        JLabel adjustGuesses = new JLabel("Adjust Guesses");
        adjustGuesses.setFont(new Font("Sans-serif", Font.BOLD, 16));
        buttonPanel.add(adjustGuesses);

        //Adjust guesses
        JButton guessButton = new JButton("Quit Game");
        guessButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //Action
            }
        }); 
        buttonPanel.add(guessButton);

        //"Sound Effects"
        JLabel soundEffects = new JLabel("Sound Effects");
        soundEffects.setFont(new Font("Sans-serif", Font.BOLD, 16));
        buttonPanel.add(soundEffects);

        //Sound effects on/off
        JButton soundButton = new JButton("Quit Game");
        soundButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //Action
            }
        }); 
        buttonPanel.add(soundButton);

        layout.add(buttonPanel);
        panel.add(layout, BorderLayout.CENTER);
        add(panel);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        setSize(300, 200); 
        setLocationRelativeTo(null); 
        setVisible(true); 

    
    }

    //Not needed, now works thru the driver
    /*public static void main(String[] args) {
        // Create an instance of PauseMenu
        new PauseMenu(); 
    }*/
}


