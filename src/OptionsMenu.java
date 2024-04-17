import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;



public class OptionsMenu extends JFrame {
    public OptionsMenu() {
        super("Options Menu");
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(new EmptyBorder(2, 3, 2, 3));

        //Title panel
        JPanel titlePanel = new JPanel(new BorderLayout()); // Won't center :(
        JLabel titleLabel = new JLabel("Options");
        titleLabel.setFont(new Font("Sans-serif", Font.BOLD, 16));
        titlePanel.add(titleLabel, BorderLayout.CENTER);
        panel.add(titlePanel, BorderLayout.NORTH);

        JPanel layout = new JPanel();
        layout.setLayout(new BoxLayout(layout, BoxLayout.Y_AXIS));

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(0, 1, 10, 5));

        //"Change Theme"
        JLabel changeTheme = new JLabel("Change Theme");
        changeTheme.setFont(new Font("Sans-serif", Font.BOLD, 14));
        buttonPanel.add(changeTheme);

        //Theme settings
        ButtonGroup themeGroup = new ButtonGroup();

        //Theme 1
        JRadioButton theme1Button = new JRadioButton("Theme 1");
        theme1Button.setSelected(true); // Select the first theme by default
        themeGroup.add(theme1Button);
        theme1Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Add theme change logic here
            }
        });
        buttonPanel.add(theme1Button);

        //Theme 2
        JRadioButton theme2Button = new JRadioButton("Theme 2");
        themeGroup.add(theme2Button);
        theme2Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Add theme change logic here
            }
        });
        buttonPanel.add(theme2Button);

        //Theme 3
        JRadioButton theme3Button = new JRadioButton("Theme 3");
        themeGroup.add(theme3Button);
        theme3Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Add theme change logic here
            }
        });
        buttonPanel.add(theme3Button);

        //"Adjust Guesses"
        JLabel adjustGuesses = new JLabel("Adjust Max Guesses");
        adjustGuesses.setFont(new Font("Sans-serif", Font.BOLD, 14));
        buttonPanel.add(adjustGuesses);

        Difficulty difficultySetting = new Difficulty("medium"); // Initialize with medium difficulty

        //Adjust guesses slider
        JSlider guessesSlider = new JSlider(JSlider.HORIZONTAL, 5, 9, 7); // Min, Max, Initial
        guessesSlider.setMajorTickSpacing(1);
        guessesSlider.setMinorTickSpacing(1);
        guessesSlider.setPaintTicks(true);
        guessesSlider.setPaintLabels(true);
        guessesSlider.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                // Get the new value of the slider
                int guesses = guessesSlider.getValue();
                // Update the number of guesses
                difficultySetting.maxLength = guesses;
            }
        });
        buttonPanel.add(adjustGuesses);
        buttonPanel.add(guessesSlider);

        //"Sound Effects"
        JLabel soundEffects = new JLabel("Sound Effects");
        soundEffects.setFont(new Font("Sans-serif", Font.BOLD, 14));
        buttonPanel.add(soundEffects);

        //Sound effects on/off
        JToggleButton soundToggleButton = new JToggleButton("Toggle Sound On");
        soundToggleButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (soundToggleButton.isSelected()) {
                    soundToggleButton.setText("Toggle Sound On");
                    // Turn sound on
                } else {
                    soundToggleButton.setText("Toggle Sound Off");
                    // Turn sound off
                }
            }
        });
        buttonPanel.add(soundToggleButton);

        //Volume slider for adjusting sound volume
        JLabel volumeLabel = new JLabel("Volume");
        volumeLabel.setFont(new Font("Sans-serif", Font.BOLD, 14));
        JSlider volumeSlider = new JSlider(JSlider.HORIZONTAL, 0, 60, 30); // Min, Max, Initial
        volumeSlider.setMajorTickSpacing(10);
        volumeSlider.setMinorTickSpacing(5);
        volumeSlider.setPaintTicks(true);
        volumeSlider.setPaintLabels(true);
        volumeSlider.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                // Get the new value of the slider
                int volume = volumeSlider.getValue();
                // Adjust sound volume based on the new value
            }
        });
        buttonPanel.add(volumeLabel);
        buttonPanel.add(volumeSlider);



        JLabel space = new JLabel(" ");
        buttonPanel.add(space);

        //Reset to default settings
        JButton resetButton = new JButton("Reset to Default Settings");
        resetButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //Reset to default settings
                    //Make theme theme1
                    theme1Button.setSelected(true);
                    //Change guesses to default guesses for that difficulty
                    guessesSlider.setValue(7);
                    //Turn sound off
                    soundToggleButton.setSelected(true);
                    soundToggleButton.setText("Toggle Sound On");
            }
        }); 
        buttonPanel.add(resetButton);

        //Save and exit button
        JButton exitButton = new JButton("Save and Exit");
        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //To resume the game, exit out of the pause menu
                //But keep the game open
                dispose();
            }
        }); 
        buttonPanel.add(exitButton);

        layout.add(buttonPanel);
        JScrollPane scrollPane = new JScrollPane(layout);
        panel.add(scrollPane, BorderLayout.CENTER);
        add(panel);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
        setSize(600, 600); 
        setLocationRelativeTo(null); 
        setVisible(true); 

    
    }

}


