import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


public class PauseMenu extends JFrame {
    public PauseMenu() {
        super("Pause Menu");
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(new EmptyBorder(2, 3, 2, 3));
        JPanel layout = new JPanel(new GridBagLayout());
        layout.setBorder(new EmptyBorder(5, 5, 5, 5));

        JPanel buttonPanel = new JPanel(new GridLayout(10, 1, 10, 5));
        //"Game Paused"
        JLabel paused = new JLabel("Game Paused");
        paused.setFont(new Font("Sans-serif", Font.BOLD, 16));
        buttonPanel.add(paused);
        
        //Resume button
        JButton resumeButton = new JButton("Resume Game");
        resumeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //To resume the game, exit out of the pause menu
                //But keep the game open
                dispose();
            }
        }); 
        buttonPanel.add(resumeButton);


        //Options button
        JButton optionsButton = new JButton("Options");
        optionsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //This would bring up the options menu
                new OptionsMenu();
            }
        }); 
        buttonPanel.add(optionsButton);

        //Main menu button
        JButton mainMenuButton = new JButton("Main Menu");
        // Add the controller as an ActionListener to the button
        mainMenuButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //Doesn't work
                OpeningMenu hangmanMenu = new OpeningMenu();
                hangmanMenu.createOpeningMenu(); //FIX INSTANCE PROBLEM
            }
        }); 
        buttonPanel.add(mainMenuButton);

        //Quit button works!
        JButton quitButton = new JButton("Quit Game");
        quitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        }); 
        buttonPanel.add(quitButton);

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


